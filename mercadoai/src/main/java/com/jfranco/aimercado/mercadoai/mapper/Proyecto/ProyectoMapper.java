package com.jfranco.aimercado.mercadoai.mapper.Proyecto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;
import com.jfranco.aimercado.mercadoai.mapper.Hito.HitoMapper;
import com.jfranco.aimercado.mercadoai.mapper.Propuesta.PropuestaMapper;
import com.jfranco.aimercado.mercadoai.mapper.Solucion.SolucionMapper;
import com.jfranco.aimercado.mercadoai.mapper.Usuario.UsuarioMapper;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Proyecto;
import com.jfranco.aimercado.mercadoai.model.Solucion;

@Mapper(componentModel = "spring", uses = {HitoMapper.class, SolucionMapper.class, PropuestaMapper.class, UsuarioMapper.class})
public interface ProyectoMapper {
    
    @Mapping(target = "solucionId", source = "proyecto.solucion.id")
    @Mapping(target = "propuestaId", source = "proyecto.propuesta.necesidad.id")
    @Mapping(target = "estado", source = "proyecto.estado.nombre")
    ProyectoDTO toDto(Proyecto proyecto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "hitos.entregables", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "hitos", source = "proyectoDTO.hitos")
    Proyecto toEntity(ProyectoCreateDTO proyectoDTO, Propuesta propuesta, Solucion solucion);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "solucion", source = "solucion")
    @Mapping(target = "propuesta", source = "propuesta")
    ProyectoSummaryDTO toSummaryDTO(Proyecto proyecto);

    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "propuesta", ignore = true)
    @Mapping(target = "solucion", ignore = true)
    Proyecto updateEntity(ProyectoUpdateDTO dto, @MappingTarget Proyecto proyecto);


}
