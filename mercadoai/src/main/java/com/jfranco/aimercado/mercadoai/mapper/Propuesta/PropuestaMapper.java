package com.jfranco.aimercado.mercadoai.mapper.Propuesta;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.mapper.Usuario.UsuarioMapper;
import com.jfranco.aimercado.mercadoai.model.Propuesta;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
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
}
