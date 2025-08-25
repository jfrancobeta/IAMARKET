package com.jfranco.aimercado.mercadoai.mapper.Habilidad;

import org.mapstruct.Mapper;

import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadDTO;
import com.jfranco.aimercado.mercadoai.model.Habilidad;

@Mapper(componentModel = "spring")
public interface HabilidadMapper {

    public HabilidadDTO toDTO(Habilidad habilidad);

    public Habilidad toEntity(HabilidadCreateDTO habilidadDTO);
}
