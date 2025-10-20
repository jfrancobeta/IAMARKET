package com.jfranco.aimercado.mercadoai.service.Profile;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Profile.PerfilDesarrolladorDTO;
import com.jfranco.aimercado.mercadoai.dto.Profile.ProfileDeveloperUpdateDTO;
import com.jfranco.aimercado.mercadoai.exception.ResourceNotFoundException;
import com.jfranco.aimercado.mercadoai.mapper.Profile.ProfileMapper;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.PerfilDesarrollador;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.Habilidad.HabilidadRepository;
import com.jfranco.aimercado.mercadoai.repository.Perfiles.DesarrolladorRepository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;

@Service
public class ProfileService implements IProfileService {

    private final UsuarioRepository usuarioRepository;
    private final DesarrolladorRepository desarrolladorRepository;
    private final ProfileMapper profileMapper;
    private final HabilidadRepository   habilidadRepository;

    public ProfileService(
            UsuarioRepository usuarioRepository,
            DesarrolladorRepository desarrolladorRepository,
            ProfileMapper profileMapper,
            HabilidadRepository habilidadRepository) {
        this.usuarioRepository = usuarioRepository;
        this.desarrolladorRepository = desarrolladorRepository;
        this.profileMapper = profileMapper;
        this.habilidadRepository = habilidadRepository;
    }

    @Override
    public PerfilDesarrolladorDTO updateDeveloperProfile(Long usuarioId,
            ProfileDeveloperUpdateDTO perfilDesarrollador) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado",
                        "No se encontró el usuario con ID: " + usuarioId, usuarioId));

        PerfilDesarrollador perfil = usuario.getPerfilDesarrollador();

        if (perfilDesarrollador.getHabilidades() != null) {
            List<Habilidad> habilidades = habilidadRepository.findAllById(perfilDesarrollador.getHabilidades());
            perfil.setHabilidades(habilidades);
        }

        profileMapper.updateEntityDeveloper(perfilDesarrollador, perfil);
        desarrolladorRepository.save(perfil);

        return profileMapper.toDTO(perfil);
    }

}
