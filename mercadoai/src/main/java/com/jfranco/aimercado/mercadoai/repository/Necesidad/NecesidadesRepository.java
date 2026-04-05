package com.jfranco.aimercado.mercadoai.repository.Necesidad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jfranco.aimercado.mercadoai.model.Necesidad;

public interface NecesidadesRepository extends JpaRepository<Necesidad,Long>{

    Page<Necesidad> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
    Page<Necesidad> findByCategoriaNombreIgnoreCase(String categoria, Pageable pageable);
    Page<Necesidad> findByEstadoNombreIgnoreCase(String estado, Pageable pageable);
    Page<Necesidad> findByCompaniaId(Long companiaId, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM necesidad_expected_deliverables WHERE necesidad_id = :id", nativeQuery = true)
    void deleteExpectedDeliverables(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM necesidad_requirements WHERE necesidad_id = :id", nativeQuery = true)
    void deleteRequirements(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM necesidad_habilidad WHERE necesidad_id = :id", nativeQuery = true)
    void deleteSkills(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hitos WHERE proyecto_id IN (SELECT id FROM proyectos WHERE necesidad_id = :id)", nativeQuery = true)
    void deleteProjectHitos(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hitos WHERE necesidad_id = :id", nativeQuery = true)
    void deleteHitos(@Param("id") Long id);
}
