package com.jfranco.aimercado.mercadoai.mapper.Proyecto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;
import com.jfranco.aimercado.mercadoai.mapper.Hito.HitoMapper;
import com.jfranco.aimercado.mercadoai.mapper.Propuesta.PropuestaMapper;
import com.jfranco.aimercado.mercadoai.mapper.Solucion.SolucionMapper;
import com.jfranco.aimercado.mercadoai.mapper.Usuario.UsuarioMapper;
import com.jfranco.aimercado.mercadoai.model.Proyecto;

@Mapper(componentModel = "spring", uses = {HitoMapper.class, SolucionMapper.class, PropuestaMapper.class, UsuarioMapper.class})
public interface ProyectoMapper {
    
    @Mapping(target = "solucion", source = "proyecto.solucion")
    @Mapping(target = "propuesta", source = "proyecto.propuesta")
    @Mapping(target = "estado", source = "proyecto.estado.nombre")
    @Mapping(target = "empresa", source = "proyecto.empresa")
    @Mapping(target = "desarrollador", source = "proyecto.desarrollador")
    ProyectoDTO toDto(Proyecto proyecto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "solucion", source = "solucion")
    @Mapping(target = "propuesta", source = "propuesta")
    ProyectoSummaryDTO toSummaryDTO(Proyecto proyecto);

    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "propuesta", ignore = true)
    @Mapping(target = "solucion", ignore = true)
    @Mapping(target = "empresa", ignore = true)
    @Mapping(target = "desarrollador", ignore = true)
    Proyecto updateEntity(ProyectoUpdateDTO dto, @MappingTarget Proyecto proyecto);


}
