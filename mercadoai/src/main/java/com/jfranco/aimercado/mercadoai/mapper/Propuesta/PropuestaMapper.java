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
import com.jfranco.aimercado.mercadoai.mapper.Necesidad.NecesidadMapper;
import com.jfranco.aimercado.mercadoai.mapper.Usuario.UsuarioMapper;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Usuario;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, HitoMapper.class, EntregableMapper.class, NecesidadMapper.class})
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
    @Mapping(target = "hitos", source = "propuesta.hitos")
    public abstract PropuestaDTO toDto(Propuesta propuesta);
    
    @Mapping(target = "estadoNombre", source = "propuesta.estado.nombre")
    public abstract PropuestaSummaryDTO toSummaryDto(Propuesta propuesta);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "desarrollador", source = "desarrollador")
    @Mapping(target = "necesidad", source = "necesidad")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "descripcion", source = "dto.descripcion")
    @Mapping(target = "hitos", source = "dto.hitos")
    public abstract Propuesta toEntity(PropuestaCreateDTO dto, Necesidad necesidad, Usuario desarrollador, Estado estado);

    public abstract Propuesta updateEntityFromDto(PropuestaUpdateDTO dto, @MappingTarget Propuesta propuesta);

}
