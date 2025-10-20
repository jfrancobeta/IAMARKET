package com.jfranco.aimercado.mercadoai.repository.CancelRequest;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfranco.aimercado.mercadoai.model.CancelRequest.CancelRequest;
import com.jfranco.aimercado.mercadoai.model.CancelRequest.CancelStatus;

@Repository
public interface CancelRequestRepository extends JpaRepository<CancelRequest, Long> {

    boolean existsByProyectoIdAndStatus(Long proyectoId, CancelStatus status);
    Optional<CancelRequest> findFirstByProyectoIdAndStatus(Long proyectoId, CancelStatus status);
}
