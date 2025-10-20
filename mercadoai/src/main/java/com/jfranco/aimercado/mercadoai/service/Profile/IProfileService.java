package com.jfranco.aimercado.mercadoai.service.Profile;

import com.jfranco.aimercado.mercadoai.dto.Profile.PerfilDesarrolladorDTO;
import com.jfranco.aimercado.mercadoai.dto.Profile.ProfileDeveloperUpdateDTO;

public interface IProfileService {
    PerfilDesarrolladorDTO updateDeveloperProfile(Long usuarioId, ProfileDeveloperUpdateDTO perfilDesarrollador);
}
