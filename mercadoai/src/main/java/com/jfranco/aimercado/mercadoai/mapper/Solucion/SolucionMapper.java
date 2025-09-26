package com.jfranco.aimercado.mercadoai.mapper.Solucion;

import java.util.List;

import org.mapstruct.Mapper;

import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionUpdateDTO;
import com.jfranco.aimercado.mercadoai.mapper.Usuario.UsuarioMapper;
import com.jfranco.aimercado.mercadoai.model.Categoria;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Hito;
import com.jfranco.aimercado.mercadoai.model.Solucion;
import com.jfranco.aimercado.mercadoai.model.Usuario;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UsuarioMapper.class })
public abstract class SolucionMapper {

    @Mapping(target = "categoriaId", source = "categoria.id")
    @Mapping(target = "desarrolladorId", source = "desarrollador.id")
    @Mapping(target = "estadoId", source = "estado.id")
    @Mapping(target = "habilidadesIds", expression = "java(solucion.getHabilidades() == null ? null : solucion.getHabilidades().stream().map(h -> h.getId()).toList())")
    public abstract SolucionDTO toDTO(Solucion solucion);

    @Mapping(target = "desarrollador", source = "desarrollador")
    public abstract SolucionDetailsDTO toDetailsDTO(Solucion solucion);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "descripcion", source = "solucionDTO.descripcion")
    @Mapping(target = "categoria", source = "categoria")
    @Mapping(target = "desarrollador", source = "desarrollador")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "habilidades", source = "habilidades")
    @Mapping(target = "hitos", source = "hitos")
    @Mapping(target = "pedidos", ignore = true)
    @Mapping(target = "vistas", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    public abstract Solucion toEntity(
            SolucionCreateDTO solucionDTO,
            Categoria categoria,
            Usuario desarrollador,
            Estado estado,
            List<Habilidad> habilidades,
            List<Hito> hitos);

    public void toEntity(
            Solucion solucion,
            SolucionUpdateDTO solucionDTO,
            Categoria categoria,
            Estado estado,
            List<Habilidad> habilidades,
            List<Hito> hitos) {
        solucion.setTitulo(solucionDTO.getTitulo());
        solucion.setDescripcion(solucionDTO.getDescripcion());
        solucion.setPrecio(solucionDTO.getPrecio());
        solucion.setCategoria(categoria);
        solucion.setEstado(estado);
        solucion.setHabilidades(habilidades);
        solucion.setCaracteristicas(solucionDTO.getCaracteristicas());
        solucion.setRequisitos(solucionDTO.getRequisitos());
        solucion.setTiempoEntrega(solucionDTO.getTiempoEntrega());
        solucion.setUnidadEntrega(solucionDTO.getUnidadEntrega());
        solucion.setHitos(hitos);
    }

    @Mapping(target = "categoriaNombre", source = "solucion.categoria.nombre")
    @Mapping(target = "estadoNombre", source = "solucion.estado.nombre")
    @Mapping(target = "habilidades", expression = "java(solucion.getHabilidades() == null ? null : solucion.getHabilidades().stream().map(h -> h.getNombre()).toList())")
    public abstract SolucionSummaryDTO toSummaryDTO(Solucion solucion);
}
