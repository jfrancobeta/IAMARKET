package com.jfranco.aimercado.mercadoai.mapper.Entregable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableDTO;
import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableUpdateDTO;
import com.jfranco.aimercado.mercadoai.model.Entregable;

@Mapper(componentModel = "spring")
public interface EntregableMapper {
    @Mapping(target = "estado", source = "entregable.estado")
    EntregableDTO toDTO(Entregable entregable);

    @Mapping(target = "fechaEntrega", ignore = true)
    @Mapping(target = "hito", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "url", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Entregable toEntity(EntregableCreateDTO dto);

    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "fechaEntrega", ignore = true)
    @Mapping(target = "hito", ignore = true)
    @Mapping(target = "url", ignore = true)
    void updateEntity(EntregableUpdateDTO dto, @MappingTarget Entregable entregable);
}