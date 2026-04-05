package com.jfranco.aimercado.mercadoai.repository.CancelRequest;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfranco.aimercado.mercadoai.model.FinalizeRequest;
import com.jfranco.aimercado.mercadoai.model.FinalizeStatus;

@Repository
public interface FinalizeRequestRepository extends JpaRepository<FinalizeRequest, Long> {

    boolean existsByProyectoIdAndStatus(Long proyectoId, FinalizeStatus status);
    Optional<FinalizeRequest> findFirstByProyectoIdAndStatus(Long proyectoId, FinalizeStatus status);
}
