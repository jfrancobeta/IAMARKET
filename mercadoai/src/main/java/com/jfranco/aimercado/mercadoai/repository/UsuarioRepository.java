package com.jfranco.aimercado.mercadoai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfranco.aimercado.mercadoai.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);
    
}
