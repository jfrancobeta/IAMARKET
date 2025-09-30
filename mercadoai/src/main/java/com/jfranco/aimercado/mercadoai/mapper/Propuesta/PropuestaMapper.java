package com.jfranco.aimercado.mercadoai.mapper.Propuesta;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUpdateDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.mapper.Entregable.EntregableMapper;
import com.jfranco.aimercado.mercadoai.mapper.Hito.HitoMapper;
import com.jfranco.aimercado.mercadoai.mapper.Usuario.UsuarioMapper;
import com.jfranco.aimercado.mercadoai.model.Propuesta;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, HitoMapper.class, EntregableMapper.class})
public abstract class PropuestaMapper {
    
    @Autowired
    private UsuarioMapper usuarioMapper;

    public PropuestaUserDetailsDTO toPropuestasUserDetailsDTO(
        Propuesta propuesta,
        Double calificacionPromedio,
        Integer cantidadCalificaciones,
        Integer cantidadProyectos) {

        PropuestaUserDetailsDTO dto = new PropuestaUserDetailsDTO();
        dto.setId(propuesta.getId());
        dto.setDescripcion(propuesta.getDescripcion());
        dto.setFechaCreacion(propuesta.getFechaCreacion());
        dto.setEntrega(propuesta.getEntrega());
        dto.setEstado(propuesta.getEstado().getNombre());
        dto.setNecesidad(propuesta.getNecesidad().getId());
        dto.setPrecio(propuesta.getPrecio());
        dto.setDesarrollador(usuarioMapper
        .toUsuarioCalificacionDTO(
            propuesta.getDesarrollador(),
            calificacionPromedio,
            cantidadCalificaciones,
            cantidadProyectos));
        
        return dto;
    }

    @Mapping(target = "necesidad", source = "propuesta.necesidad")
    @Mapping(target = "estado", source = "propuesta.estado")
    public abstract PropuestaDTO toDto(Propuesta propuesta);
    
    @Mapping(target = "id", source = "propuesta.id")
    @Mapping(target = "desarrolladorId", source = "propuesta.desarrollador.id")
    @Mapping(target = "necesidadId", source = "propuesta.necesidad.id")
    @Mapping(target = "estadoNombre", source = "propuesta.estado.nombre")
    public abstract PropuestaSummaryDTO toSummaryDto(Propuesta propuesta);

    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    public abstract Propuesta toEntity(PropuestaCreateDTO dto);

    public abstract Propuesta updateEntityFromDto(PropuestaUpdateDTO dto, @MappingTarget Propuesta propuesta);

}
