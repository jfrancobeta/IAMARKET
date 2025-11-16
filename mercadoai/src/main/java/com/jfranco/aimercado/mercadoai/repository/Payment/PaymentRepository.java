package com.jfranco.aimercado.mercadoai.repository.Payment;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.model.Payment.Payment;
import com.jfranco.aimercado.mercadoai.model.Payment.StatusPayment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByPreferenceId(String preferenceId);
    Optional<Payment> findByPaymentId(String paymentId);

    // Todos los pagos donde el usuario participa como buyer o receiver
    @Query("SELECT p FROM Payment p WHERE p.buyer = :user OR p.receiver = :user")
    Page<Payment> findByUserParticipation(@Param("user") Usuario user, Pageable pageable);

    // Pagos donde el usuario participa y filtra por estado
    @Query("SELECT p FROM Payment p WHERE (p.buyer = :user OR p.receiver = :user) AND p.status = :status")
    Page<Payment> findByUserParticipationAndStatus(@Param("user") Usuario user, @Param("status") StatusPayment status, Pageable pageable);

    // Pagos donde el usuario participa y filtra por búsqueda en descripción de propuesta o solución
    @Query("SELECT p FROM Payment p WHERE (p.buyer = :user OR p.receiver = :user) AND " +
           "(LOWER(p.propuesta.descripcion) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(p.solucion.descripcion) LIKE LOWER(CONCAT('%', :search, '%')))")
    Page<Payment> findByUserParticipationAndSearch(@Param("user") Usuario user, @Param("search") String search, Pageable pageable);

    // Pagos donde el usuario participa y filtra por tipo (propuesta o solucion)
    @Query("SELECT p FROM Payment p WHERE (p.buyer = :user OR p.receiver = :user) AND " +
           "(:type = 'propuesta' AND p.propuesta IS NOT NULL OR :type = 'solucion' AND p.solucion IS NOT NULL)")
    Page<Payment> findByUserParticipationAndType(@Param("user") Usuario user, @Param("type") String type, Pageable pageable);

    // Pagos pendientes donde el usuario es buyer
    @Query("SELECT p FROM Payment p WHERE p.buyer = :buyer AND p.status = :status")
    Page<Payment> findByBuyerAndStatus(@Param("buyer") Usuario buyer, @Param("status") StatusPayment status, Pageable pageable);
}
    