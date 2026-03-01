package com.jfranco.aimercado.mercadoai.repository.Proyecto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jfranco.aimercado.mercadoai.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    @Query("SELECT COUNT(p) FROM Proyecto p WHERE LOWER(p.estado.nombre) = LOWER(:estado)")
    long countByEstadoNombre(@Param("estado") String estado);

    @Query("SELECT COUNT(p) FROM Proyecto p WHERE LOWER(p.estado.nombre) <> LOWER(:estado)")
    long countByEstadoNombreNot(@Param("estado") String estado);

    @Query("SELECT COALESCE(SUM(p.presupuesto), 0) FROM Proyecto p")
    java.math.BigDecimal sumPresupuesto();

    @Query("SELECT COALESCE(SUM(p.presupuesto), 0) FROM Proyecto p WHERE p.empresa.id = :usuarioId OR p.desarrollador.id = :usuarioId")
    java.math.BigDecimal sumPresupuestoByUsuario(@Param("usuarioId") Long usuarioId);

    @Query("SELECT COUNT(p) FROM Proyecto p WHERE LOWER(p.estado.nombre) = LOWER(:estado) AND (p.empresa.id = :usuarioId OR p.desarrollador.id = :usuarioId)")
    long countByEstadoNombreAndUsuario(@Param("estado") String estado, @Param("usuarioId") Long usuarioId);

    @Query("SELECT COUNT(p) FROM Proyecto p WHERE LOWER(p.estado.nombre) <> LOWER(:estado) AND (p.empresa.id = :usuarioId OR p.desarrollador.id = :usuarioId)")
    long countByEstadoNombreNotAndUsuario(@Param("estado") String estado, @Param("usuarioId") Long usuarioId);

    Integer countByPropuesta_Desarrollador_id(Long propuestaId);

    Page<Proyecto> findByEmpresaIdOrDesarrolladorId(Long empresaId, Long desarrolladorId, Pageable pageable);

    @Query("""
            SELECT p FROM Proyecto p
            WHERE p.solucion IS NOT NULL
            AND (p.empresa.id = :usuarioId OR p.desarrollador.id = :usuarioId)
            """)
    Page<Proyecto> findBySolucionIsNotNullAndUsuario(@Param("usuarioId") Long usuarioId, Pageable pageable);

    // Filtros combinados para usuario + propuesta
    @Query("""
            SELECT p FROM Proyecto p
            WHERE p.propuesta IS NOT NULL
            AND (p.empresa.id = :usuarioId OR p.desarrollador.id = :usuarioId)
            """)
    Page<Proyecto> findByPropuestaIsNotNullAndUsuario(@Param("usuarioId") Long usuarioId, Pageable pageable);

    // Filtros combinados para usuario + estado
    @Query("""
            SELECT p FROM Proyecto p
            WHERE LOWER(p.estado.nombre) = LOWER(:estado)
            AND (p.empresa.id = :usuarioId OR p.desarrollador.id = :usuarioId)
            """)
    Page<Proyecto> findByEstadoNombreIgnoreCaseAndUsuario(@Param("estado") String estado,
            @Param("usuarioId") Long usuarioId, Pageable pageable);

    // Filtros combinados para usuario + búsqueda por título
    @Query("""
            SELECT p FROM Proyecto p
            WHERE
                ((p.propuesta IS NOT NULL AND LOWER(p.propuesta.necesidad.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')))
                OR (p.solucion IS NOT NULL AND LOWER(p.solucion.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))))
            AND (p.empresa.id = :usuarioId OR p.desarrollador.id = :usuarioId)
            """)
    Page<Proyecto> searchByTituloAndUsuario(@Param("titulo") String titulo, @Param("usuarioId") Long usuarioId,
            Pageable pageable);

}
