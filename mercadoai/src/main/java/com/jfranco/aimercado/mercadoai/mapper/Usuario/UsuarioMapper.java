package com.jfranco.aimercado.mercadoai.mapper.Usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.jfranco.aimercado.mercadoai.dto.User.UserPersonalUpdateDTO;
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
    @Mapping(target = "perfilCompania.industria", source = "usuario.perfilCompania.industria.nombre")
    public UsuarioCalificacionDTO toUsuarioCalificacionDTO(
        Usuario usuario,
        Double calificacionPromedio,
        Integer cantidadCalificaciones,
        Integer cantidadProyectos);
        
    @Mapping(target = "roles" , source = "usuario.roles", qualifiedByName = "rolesToNombreList")
    @Mapping(target = "perfilCompania.industria", source = "usuario.perfilCompania.industria.nombre")
    @Mapping(target = "pais", source = "usuario.pais")
    public UsuarioDTO toDTO(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "foto", ignore = true)
    @Mapping(target = "pais", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "perfilCompania", ignore = true)
    @Mapping(target = "perfilDesarrollador", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "userType", ignore = true)
    @Mapping(target = "username", ignore = true)
    public Usuario updateEntity(UserPersonalUpdateDTO dto, @MappingTarget Usuario usuario);

    @Named("rolesToNombreList")
    default List<String> rolesToNombreList(List<Role> roles) {
        if (roles == null) return null;
        return roles.stream()
            .map(Role::getNombre)
            .collect(Collectors.toList());
    }
}
