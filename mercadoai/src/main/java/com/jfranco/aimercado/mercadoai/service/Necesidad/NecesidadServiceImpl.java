package com.jfranco.aimercado.mercadoai.service.Necesidad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUpdateDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.mapper.Necesidad.NecesidadMapper;
import com.jfranco.aimercado.mercadoai.mapper.Propuesta.PropuestaMapper;
import com.jfranco.aimercado.mercadoai.model.Categoria;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.Categoria.CategoriaRepository;
import com.jfranco.aimercado.mercadoai.repository.Estado.EstadoRepository;
import com.jfranco.aimercado.mercadoai.repository.Habilidad.HabilidadRepository;
import com.jfranco.aimercado.mercadoai.repository.Necesidad.NecesidadesRepository;
import com.jfranco.aimercado.mercadoai.repository.Propuesta.PropuestaRepository;
import com.jfranco.aimercado.mercadoai.repository.Proyecto.ProyectoRepository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;
import com.jfranco.aimercado.mercadoai.service.Calificacion.ICalificacionService;

@Service
public class NecesidadServiceImpl implements INecesidadesService {

    @Autowired
    private NecesidadesRepository necesidadesRepostitory;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private HabilidadRepository habilidadesRepository;

    @Autowired
    private PropuestaRepository propuestaRepository;

    @Autowired
    private ICalificacionService calificacionService;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private NecesidadMapper necesidadMapper;

    @Autowired
    private PropuestaMapper propuestaMapper;

    @Override
    public List<NecesidadSummaryDTO> getAllNecesidades() {
        List<Necesidad> necesidades = necesidadesRepostitory.findAll();
        return necesidades.stream().map(necesidad ->
         necesidadMapper.toSummaryDTO(necesidad, propuestaRepository.countByNecesidadId(necesidad.getId()))).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public NecesidadUserDetailsDTO getNecesidadByIdDetails(Long id) {
            Necesidad necesidad = necesidadesRepostitory.findById(id)
                    .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));
            
            List<Propuesta> propuestas = propuestaRepository.findByNecesidad(necesidad);

            List<PropuestaUserDetailsDTO> propuestasDetailsDTO = new ArrayList<>();
            
            for (Propuesta propuesta : propuestas) {
                Usuario desarrollador = propuesta.getDesarrollador();
                Double calificacionPromedio = calificacionService.getPromedioCalificacionByUsuarioId(desarrollador.getId());
                if (calificacionPromedio != null) {
                    calificacionPromedio = Math.round(calificacionPromedio * 10.0) / 10.0;
                }
                Integer cantidadCalificaciones = 0;
                Integer cantidadProyectos = proyectoRepository.countByPropuesta_Desarrollador_id(desarrollador.getId());

                PropuestaUserDetailsDTO propuestaDTO = propuestaMapper.toPropuestasUserDetailsDTO(
                    propuesta,
                    calificacionPromedio,
                    cantidadCalificaciones,
                    cantidadProyectos);

                propuestasDetailsDTO.add(propuestaDTO);
            }
            
            Double calificacionPromedio = calificacionService.getPromedioCalificacionByUsuarioId(necesidad.getCompania().getId());
            if (calificacionPromedio != null) {
                calificacionPromedio = Math.round(calificacionPromedio * 10.0) / 10.0;
            }
            Integer cantidadCalificaciones = 0;
            Integer cantidadProyectos = proyectoRepository.countByPropuesta_Desarrollador_id(necesidad.getCompania().getId());

            NecesidadUserDetailsDTO dto = necesidadMapper.toDetailsDTO(
                necesidad,
                propuestasDetailsDTO,
                calificacionPromedio,
                cantidadCalificaciones,
                cantidadProyectos
            );

            return dto;
    }
                
                 

    @Override
    @Transactional
    public NecesidadDTO saveNecesidad(NecesidadCreateDTO necesidadDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username  =  authentication.getName();
        Usuario usuario = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con username: " + username));
        Usuario compania = usuarioRepository.findById(usuario.getId())
                .orElseThrow(
                        () -> new RuntimeException("Compañía no encontrada con id: " + usuario.getId()));

        Estado estado = estadoRepository.findById(necesidadDTO.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con id: " + necesidadDTO.getEstadoId()));

        List<Habilidad> habilidades = habilidadesRepository.findAllById(necesidadDTO.getSkillsRequiredIds());

        Categoria categoria = categoriaRepository.findById(necesidadDTO.getCategoria())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + necesidadDTO.getCategoria()));

        Necesidad necesidad = necesidadMapper.toEntity(necesidadDTO, compania, estado, habilidades, categoria);

        Necesidad saved = necesidadesRepostitory.save(necesidad);
        
        return necesidadMapper.toDTO(saved);
    }

    @Override
    @Transactional
    public NecesidadDTO updateNecesidad(Long id, NecesidadUpdateDTO dto) {
        Necesidad necesidad = necesidadesRepostitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));

        Estado estado = null;

        if(dto.getEstadoId() != null) {
            estado = estadoRepository.findById(dto.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con id: " + dto.getEstadoId()));
        }

        List<Habilidad> habilidades = null;

        if(dto.getSkillsRequiredIds() != null) {
            habilidades = habilidadesRepository.findAllById(dto.getSkillsRequiredIds());
        }

        Categoria categoria = null;

        if(dto.getCategoria() != null) {
            categoria = categoriaRepository.findById(dto.getCategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + dto.getCategoria()));
        }

        necesidadMapper.updateEntity(necesidad, dto, estado, habilidades, categoria);

        Necesidad updated = necesidadesRepostitory.save(necesidad);

        return necesidadMapper.toDTO(updated);
    }

    @Override
    public boolean deleteNecesidad(Long id) {
        Necesidad necesidad = necesidadesRepostitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));
        necesidadesRepostitory.delete(necesidad);
        return true;
    }

    @Override
    public NecesidadDTO getNecesidadById(Long id) {
        Necesidad necesidad = necesidadesRepostitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));
        return necesidadMapper.toDTO(necesidad);
    }
}