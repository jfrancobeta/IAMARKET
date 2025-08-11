package com.jfranco.aimercado.mercadoai.service.Usuarios;

import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Auth.RegistroRequest;
import com.jfranco.aimercado.mercadoai.model.Usuario;

public interface IUsuarioService {

    List<Usuario> getAllUsuarios();

    void saveUsuario(RegistroRequest registroRequest);

    Usuario getUsuarioById(Long id);

    void eliminarUsuario(Long id);

    boolean sendResetCode(String email);

    boolean verifyResetCode(String email, String code);

    boolean resetPassword(String email, String code, String newPassword);


    

    
    
}
