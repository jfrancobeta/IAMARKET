package com.jfranco.aimercado.mercadoai.mapper.Necesidad;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUpdateDTO;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Usuario;

@Mapper(componentModel = "spring")
public abstract class NecesidadMapper {

    @Mapping(target = "compañiaNombre", source = "necesidad.compania.nombre")
    @Mapping(target = "estadoNombre", source = "necesidad.estado.nombre")
    @Mapping(target = "propuestas", source = "cantidadPropuestas")
    public abstract NecesidadSummaryDTO toSummaryDTO(Necesidad necesidad, Integer cantidadPropuestas);

    public NecesidadDetailsDTO toDetailsDTO(Necesidad necesidad){
        return new NecesidadDetailsDTO();
    }
    
    public NecesidadDTO toDTO(Necesidad necesidad){
        return new NecesidadDTO();
    }


    public Necesidad toEntity(NecesidadCreateDTO dto, Usuario compania, Estado estado, List<Habilidad> habilidades){
        return new Necesidad();
    }

    public void updateEntity(Necesidad necesidad, NecesidadUpdateDTO dto, Estado estado, List<Habilidad> habilidades){

    }
}

