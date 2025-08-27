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
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Usuario;
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
    public NecesidadUserDetailsDTO getNecesidadById(Long id) {
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
        
        Necesidad necesidad = new Necesidad();
        necesidad.setTitulo(necesidadDTO.getTitulo());
        necesidad.setDescripcion(necesidadDTO.getDescripcion());
        necesidad.setCategoria(necesidadDTO.getCategoria());
        necesidad.setPresupuesto(necesidadDTO.getPresupuesto());
        necesidad.setCompania(compania);
        necesidad.setFechaLimite(necesidadDTO.getFechaLimite());
        necesidad.setSkillsRequired(habilidades);
        necesidad.setRequirements(necesidadDTO.getRequirements());
        necesidad.setExpectedDeliverables(necesidadDTO.getExpectedDeliverables());
        necesidad.setEstado(estado);

        Necesidad saved = necesidadesRepostitory.save(necesidad);
        
        return necesidadMapper.toDTO(saved);
    }

    @Override
    @Transactional
    public NecesidadDTO updateNecesidad(Long id, NecesidadUpdateDTO dto) {
        Necesidad necesidad = necesidadesRepostitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));

        if (dto.getTitulo() != null)
            necesidad.setTitulo(dto.getTitulo());
        if (dto.getDescripcion() != null)
            necesidad.setDescripcion(dto.getDescripcion());
        if (dto.getCategoria() != null)
            necesidad.setCategoria(dto.getCategoria());
        if (dto.getPresupuesto() != null)
            necesidad.setPresupuesto(dto.getPresupuesto());
        if (dto.getCompañiaId() != null) {
            Usuario compania = usuarioRepository.findById(dto.getCompañiaId())
                    .orElseThrow(() -> new RuntimeException("Compañía no encontrada con id: " + dto.getCompañiaId()));
            necesidad.setCompania(compania);
        }
        if (dto.getFechaLimite() != null)
            necesidad.setFechaLimite(dto.getFechaLimite());
        if (dto.getSkillsRequiredIds() != null) {
            List<Habilidad> habilidades = habilidadesRepository.findAllById(dto.getSkillsRequiredIds());
            necesidad.setSkillsRequired(habilidades);
        }
        if (dto.getRequirements() != null)
            necesidad.setRequirements(dto.getRequirements());
        if (dto.getExpectedDeliverables() != null)
            necesidad.setExpectedDeliverables(dto.getExpectedDeliverables());
        if (dto.getEstadoId() != null) {
            Estado estado = estadoRepository.findById(dto.getEstadoId())
                    .orElseThrow(() -> new RuntimeException("Estado no encontrado con id: " + dto.getEstadoId()));
            necesidad.setEstado(estado);
        }

        Necesidad updated = necesidadesRepostitory.save(necesidad);
        List<Propuesta> propuestas = propuestaRepository
                .findByNecesidad(
                        necesidadesRepostitory.findById(updated.getId()).get());
        
        Usuario compania = updated.getCompania();
        
        if (compania.getUserType() == 0 && compania.getPerfilCompania() != null) {
            compania.getPerfilCompania().getNombreCompania();
        }

        return new NecesidadDTO();
    }

    @Override
    public boolean deleteNecesidad(Long id) {
        Necesidad necesidad = necesidadesRepostitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));
        necesidadesRepostitory.delete(necesidad);
        return true;
    }
}