package com.jfranco.aimercado.mercadoai.service.Necesidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadResponseDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUpdateDTO;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.EstadoRepository;
import com.jfranco.aimercado.mercadoai.repository.HabilidadesRepository;
import com.jfranco.aimercado.mercadoai.repository.NecesidadesRepository;
import com.jfranco.aimercado.mercadoai.repository.PropuestaRepository;
import com.jfranco.aimercado.mercadoai.repository.UsuarioRepository;

@Service
public class NecesidadServiceImpl implements INecesidadesService {

    @Autowired
    private NecesidadesRepository necesidadesRepostitory;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private HabilidadesRepository habilidadesRepository;

    @Autowired
    private PropuestaRepository propuestaRepository;

    @Override
    public List<NecesidadSummaryDTO> getAllNecesidades() {
        List<Necesidad> necesidades = necesidadesRepostitory.findAll();
       
        return necesidades.stream()
                .map(necesidad ->{ 
                    Integer propuestas = propuestaRepository.countByNecesidadId(necesidad.getId());
                    return new NecesidadSummaryDTO(
                        necesidad.getId(),
                        necesidad.getTitulo(),
                        necesidad.getCategoria(),
                        necesidad.getPresupuesto(),
                        necesidad.getCompania().getNombre(), 
                        necesidad.getFechaLimite(),
                        necesidad.getEstado().getNombre(), 
                        necesidad.getFechaCreacion(),
                        propuestas,
                        necesidad.getDescripcion());
                })
                .toList();
    }

    @Override
    public NecesidadResponseDTO getNecesidadById(Long id) {
        return necesidadesRepostitory.findById(id)
                .map(necesidad -> new NecesidadResponseDTO(
                        necesidad.getId(),
                        necesidad.getTitulo(),
                        necesidad.getDescripcion(),
                        necesidad.getCategoria(),
                        necesidad.getPresupuesto(),
                        necesidad.getCompania().getNombre(),
                        necesidad.getFechaLimite(),
                        necesidad.getSkillsRequired().stream()
                                .map(Habilidad::getNombre)
                                .toList(),
                        necesidad.getRequirements(),
                        necesidad.getExpectedDeliverables(),
                        necesidad.getEstado().getNombre(),
                        necesidad.getFechaCreacion(),
                        necesidad.getFechaActualizacion()))
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));
    }

    @Override
    public NecesidadResponseDTO saveNecesidad(NecesidadCreateDTO necesidadDTO) {
        Usuario compania = usuarioRepository.findById(necesidadDTO.getCompañiaId())
                .orElseThrow(
                        () -> new RuntimeException("Compañía no encontrada con id: " + necesidadDTO.getCompañiaId()));

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

        return new NecesidadResponseDTO(
                saved.getId(),
                saved.getTitulo(),
                saved.getDescripcion(),
                saved.getCategoria(),
                saved.getPresupuesto(),
                saved.getCompania().getNombre(),
                saved.getFechaLimite(),
                saved.getSkillsRequired().stream().map(Habilidad::getNombre).toList(),
                saved.getRequirements(),
                saved.getExpectedDeliverables(),
                saved.getEstado().getNombre(),
                saved.getFechaCreacion(),
                saved.getFechaActualizacion());
    }

    @Override
    public NecesidadResponseDTO updateNecesidad(Long id, NecesidadUpdateDTO dto) {
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
        return new NecesidadResponseDTO(
                updated.getId(),
                updated.getTitulo(),
                updated.getDescripcion(),
                updated.getCategoria(),
                updated.getPresupuesto(),
                updated.getCompania().getNombre(),
                updated.getFechaLimite(),
                updated.getSkillsRequired().stream().map(Habilidad::getNombre).toList(),
                updated.getRequirements(),
                updated.getExpectedDeliverables(),
                updated.getEstado().getNombre(),
                updated.getFechaCreacion(),
                updated.getFechaActualizacion());
    }

    @Override
    public boolean deleteNecesidad(Long id) {
        Necesidad necesidad = necesidadesRepostitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));
        necesidadesRepostitory.delete(necesidad);
        return true;
    }
}