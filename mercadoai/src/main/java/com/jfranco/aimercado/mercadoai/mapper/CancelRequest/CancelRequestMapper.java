package com.jfranco.aimercado.mercadoai.mapper.CancelRequest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jfranco.aimercado.mercadoai.dto.CancelRequest.CancelRequestDTO;
import com.jfranco.aimercado.mercadoai.model.CancelRequest.CancelRequest;

@Mapper(componentModel = "spring")
public interface CancelRequestMapper {
    
    @Mapping(source = "proyecto.id", target = "proyectoId")
    @Mapping(source = "requestedBy.id", target = "requestedById")
    @Mapping(source = "requestedBy.username", target = "requestedByUsername")
    @Mapping(source = "requestedTo.id", target = "requestedToId")
    @Mapping(source = "requestedTo.username", target = "requestedToUsername")
    public CancelRequestDTO toDTO(CancelRequest cancelRequest);
}
