package com.jfranco.aimercado.mercadoai.mapper.Usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.jfranco.aimercado.mercadoai.dto.User.UsuarioCalificacionDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;
import com.jfranco.aimercado.mercadoai.model.Role;
import com.jfranco.aimercado.mercadoai.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "roles" , source = "usuario.roles", qualifiedByName = "rolesToNombreList")
    @Mapping(target = "calificacionPromedio", source = "calificacionPromedio")
    @Mapping(target = "cantidadCalificaciones", source = "cantidadCalificaciones")
    @Mapping(target = "cantidadProyectos", source = "cantidadProyectos")
    public UsuarioCalificacionDTO toUsuarioCalificacionDTO(
        Usuario usuario,
        Double calificacionPromedio,
        Integer cantidadCalificaciones,
        Integer cantidadProyectos);
        
    @Mapping(target = "roles" , source = "usuario.roles", qualifiedByName = "rolesToNombreList")
    public UsuarioDTO toDTO(Usuario usuario);

    @Named("rolesToNombreList")
    default List<String> rolesToNombreList(List<Role> roles) {
        if (roles == null) return null;
        return roles.stream()
            .map(Role::getNombre)
            .collect(Collectors.toList());
    }
}
