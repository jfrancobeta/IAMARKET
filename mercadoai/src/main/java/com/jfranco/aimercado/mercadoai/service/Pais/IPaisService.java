package com.jfranco.aimercado.mercadoai.service.Pais;

import java.util.List;
import java.util.Optional;

import com.jfranco.aimercado.mercadoai.model.Pais;

public interface IPaisService {
    List<Pais> getAllPaises();
    Optional<Pais> getPaisById(Long id);
}
