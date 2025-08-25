package com.jfranco.aimercado.mercadoai.mapper.Necesidad;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.mapper.Usuario.UsuarioMapper;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Necesidad;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public abstract class NecesidadMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Mapping(target = "compañiaNombre", source = "necesidad.compania.nombre")
    @Mapping(target = "estadoNombre", source = "necesidad.estado.nombre")
    @Mapping(target = "propuestas", source = "cantidadPropuestas")
    public abstract NecesidadSummaryDTO toSummaryDTO(Necesidad necesidad, Integer cantidadPropuestas);

    public NecesidadUserDetailsDTO toDetailsDTO(
        Necesidad necesidad,
        List<PropuestaUserDetailsDTO> propuestas,
        Double calificacionPromedio,
        Integer cantidadCalificaciones,
        Integer cantidadProyectos){
            NecesidadUserDetailsDTO dto = new NecesidadUserDetailsDTO();
            dto.setId(necesidad.getId());
            dto.setTitulo(necesidad.getTitulo());
            dto.setDescripcion(necesidad.getDescripcion());
            dto.setPresupuesto(necesidad.getPresupuesto());
            dto.setCompania(usuarioMapper.toUsuarioCalificacionDTO(necesidad.getCompania(), calificacionPromedio, cantidadCalificaciones, cantidadProyectos));
            dto.setFechaLimite(necesidad.getFechaLimite());
            dto.setSkillsRequired(necesidad.getSkillsRequired().stream().map(Habilidad::getNombre).toList());
            dto.setRequirements(necesidad.getRequirements());
            dto.setExpectedDeliverables(necesidad.getExpectedDeliverables());
            dto.setEstadoNombre(necesidad.getEstado().getNombre());
            dto.setPropuestas(propuestas);
            dto.setFechaCreacion(necesidad.getFechaCreacion());
            dto.setFechaActualizacion(necesidad.getFechaActualizacion());

            return dto;

    }

    @Mapping(target = "estadoNombre", source = "necesidad.estado.nombre")
    @Mapping(target = "skillsRequired", source = "necesidad.skillsRequired", qualifiedByName = "habilidadesToStringList")
    public abstract NecesidadDTO toDTO(Necesidad necesidad);

    @Named("habilidadesToStringList")
    public List<String> habilidadesToStringList(List<Habilidad> habilidades) {
        if (habilidades == null) return null;
        return habilidades.stream().map(Habilidad::getNombre).toList();
    }

    // public Necesidad toEntity(NecesidadCreateDTO dto, Usuario compania, Estado estado, List<Habilidad> habilidades){
    //     return new Necesidad();
    // }

    // public void updateEntity(Necesidad necesidad, NecesidadUpdateDTO dto, Estado estado, List<Habilidad> habilidades){

    // }
}

