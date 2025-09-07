package com.jfranco.aimercado.mercadoai.service.Industria;

import java.util.List;
import java.util.Optional;

import com.jfranco.aimercado.mercadoai.model.Industria;

public interface IIndustriaService {
    List<Industria> getAllIndustrias();
    Optional<Industria> getIndustriaById(Long id);
}
