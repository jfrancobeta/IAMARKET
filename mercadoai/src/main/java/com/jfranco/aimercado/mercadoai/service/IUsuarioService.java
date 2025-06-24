package com.jfranco.aimercado.mercadoai.service;

import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.RegistroRequest;
import com.jfranco.aimercado.mercadoai.model.Usuario;

public interface IUsuarioService {

    List<Usuario> getAllUsuarios();

    void saveUsuario(RegistroRequest registroRequest);

    Usuario getUsuarioById(Long id);

    void eliminarUsuario(Long id);

    

    
    
}
