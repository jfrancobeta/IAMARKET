package com.jfranco.aimercado.mercadoai.mapper.Entregable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableDTO;
import com.jfranco.aimercado.mercadoai.model.Entregable;

@Mapper(componentModel = "spring")
public interface EntregableMapper {
    
    EntregableDTO toDTO(Entregable entregable);

    @Mapping(target = "hito", ignore = true)
    Entregable toEntity(EntregableDTO dto);
}