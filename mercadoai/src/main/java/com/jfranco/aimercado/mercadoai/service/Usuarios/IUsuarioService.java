package com.jfranco.aimercado.mercadoai.service.Usuarios;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jfranco.aimercado.mercadoai.dto.Auth.RegistroRequest;
import com.jfranco.aimercado.mercadoai.dto.User.UserPersonalUpdateDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;
import com.jfranco.aimercado.mercadoai.model.Usuario;

public interface IUsuarioService {

    List<Usuario> getAllUsuarios();

    void saveUsuario(RegistroRequest registroRequest);

    Usuario getUsuarioById(Long id);

    UsuarioDTO getUsuarioByUsername(String username);

    void eliminarUsuario(Long id);

    boolean sendResetCode(String email);

    boolean verifyResetCode(String email, String code);

    boolean resetPassword(String email, String code, String newPassword);

    UsuarioDTO updateUsuarioPersonal(Long id, UserPersonalUpdateDTO model);

    String uploadProfilePhoto(Long id, MultipartFile photoData); 


    

    
    
}
