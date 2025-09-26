package com.jfranco.aimercado.mercadoai.mapper.Hito;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoUpdateDTO;
import com.jfranco.aimercado.mercadoai.model.Hito;

@Mapper(componentModel = "spring")
public interface HitoMapper {

    HitoDTO toDTO(Hito hito);


    @Mapping(target = "entregables", ignore = true)
    @Mapping(target = "id", ignore = true)
    Hito toEntity(HitoCreateDTO dto);

    @Mapping(target = "entregables", ignore = true)
    Hito toEntity(HitoUpdateDTO dto);
    
}
