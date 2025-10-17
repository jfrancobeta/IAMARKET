package com.jfranco.aimercado.mercadoai.mapper.Profile;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.jfranco.aimercado.mercadoai.dto.Profile.PerfilDesarrolladorDTO;
import com.jfranco.aimercado.mercadoai.dto.Profile.ProfileDeveloperUpdateDTO;
import com.jfranco.aimercado.mercadoai.mapper.Habilidad.HabilidadMapper;
import com.jfranco.aimercado.mercadoai.model.PerfilDesarrollador;

@Mapper(componentModel = "spring", uses = {HabilidadMapper.class})
public interface ProfileMapper {

    public PerfilDesarrolladorDTO toDTO(PerfilDesarrollador perfil);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    public PerfilDesarrollador updateEntityDeveloper(ProfileDeveloperUpdateDTO dto, @MappingTarget PerfilDesarrollador perfil);
    
}
