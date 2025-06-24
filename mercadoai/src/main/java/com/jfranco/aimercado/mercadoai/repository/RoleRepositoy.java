package com.jfranco.aimercado.mercadoai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfranco.aimercado.mercadoai.model.Role;

public interface RoleRepositoy extends JpaRepository<Role, Long> {
    
    Optional<Role> findByNombre(String nombre);
}
