package com.jfranco.aimercado.mercadoai.mapper.Rating;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jfranco.aimercado.mercadoai.dto.Rating.PendingRatingDTO;
import com.jfranco.aimercado.mercadoai.dto.Rating.RatingDTO;
import com.jfranco.aimercado.mercadoai.mapper.Proyecto.ProyectoMapper;
import com.jfranco.aimercado.mercadoai.mapper.Usuario.UsuarioMapper;
import com.jfranco.aimercado.mercadoai.model.Rating.Calificacion;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, ProyectoMapper.class})
public interface RatingMapper {
    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "usuarioCalificado", target = "usuarioCalificado")
    @Mapping(source = "proyecto", target = "proyecto")
    RatingDTO toDTO(Calificacion calificacion);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "proyecto", target = "proyecto")
    @Mapping(source = "usuarioCalificado", target = "usuarioCalificado")
    PendingRatingDTO toPendingDTO(Calificacion calificacion);
}
