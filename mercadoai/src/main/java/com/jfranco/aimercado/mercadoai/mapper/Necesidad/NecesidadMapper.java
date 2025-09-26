package com.jfranco.aimercado.mercadoai.mapper.Necesidad;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.mapper.Usuario.UsuarioMapper;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUpdateDTO;
import com.jfranco.aimercado.mercadoai.model.Categoria;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Hito;
import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Usuario;

@Mapper(componentModel = "spring", uses = { UsuarioMapper.class})
public abstract class NecesidadMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Mapping(target = "compañiaNombre", source = "necesidad.compania.nombre")
    @Mapping(target = "estadoNombre", source = "necesidad.estado.nombre")
    @Mapping(target = "propuestas", source = "cantidadPropuestas")
    public abstract NecesidadSummaryDTO toSummaryDTO(Necesidad necesidad, Integer cantidadPropuestas);

    public NecesidadUserDetailsDTO toDetailsDTO(
            Necesidad necesidad,
            List<PropuestaUserDetailsDTO> propuestas,
            Double calificacionPromedio,
            Integer cantidadCalificaciones,
            Integer cantidadProyectos,
            List<HitoDTO> hitos) {
        NecesidadUserDetailsDTO dto = new NecesidadUserDetailsDTO();
        dto.setId(necesidad.getId());
        dto.setTitulo(necesidad.getTitulo());
        dto.setDescripcion(necesidad.getDescripcion());
        dto.setPresupuesto(necesidad.getPresupuesto());
        dto.setCompania(usuarioMapper.toUsuarioCalificacionDTO(necesidad.getCompania(), calificacionPromedio,
                cantidadCalificaciones, cantidadProyectos));
        dto.setFechaLimite(necesidad.getFechaLimite());
        dto.setSkillsRequired(necesidad.getSkillsRequired().stream().map(Habilidad::getNombre).toList());
        dto.setRequirements(necesidad.getRequirements());
        dto.setHitos(hitos);
        dto.setEstadoNombre(necesidad.getEstado().getNombre());
        dto.setPropuestas(propuestas);
        dto.setFechaCreacion(necesidad.getFechaCreacion());
        dto.setFechaActualizacion(necesidad.getFechaActualizacion());

        return dto;

    }

    public abstract NecesidadDTO toDTO(Necesidad necesidad);

    @Mapping(target = "compania", source = "compania")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "skillsRequired", source = "habilidades")
    @Mapping(target = "descripcion", source = "dto.descripcion")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categoria", source = "categoria")
    @Mapping(target = "hitos", source = "hitos")
    public abstract Necesidad toEntity(NecesidadCreateDTO dto, Usuario compania, Estado estado,
            List<Habilidad> habilidades, Categoria categoria, List<Hito> hitos);

    public void updateEntity(Necesidad necesidad, NecesidadUpdateDTO dto, Estado estado, List<Habilidad> habilidades,
            Categoria categoria, List<Hito> hitos) {
        if (dto.getTitulo() != null)
            necesidad.setTitulo(dto.getTitulo());
        if (dto.getDescripcion() != null)
            necesidad.setDescripcion(dto.getDescripcion());
        if (dto.getCategoria() != null)
            necesidad.setCategoria(categoria);
        if (dto.getPresupuesto() != null)
            necesidad.setPresupuesto(dto.getPresupuesto());
        if (dto.getFechaLimite() != null)
            necesidad.setFechaLimite(dto.getFechaLimite());
        if (dto.getRequirements() != null)
            necesidad.setRequirements(dto.getRequirements());
        if (estado != null)
            necesidad.setEstado(estado);
        if (habilidades != null)
            necesidad.setSkillsRequired(habilidades);
        if (hitos != null)
            necesidad.setHitos(hitos);
    }
}
