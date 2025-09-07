package com.jfranco.aimercado.mercadoai.service.Industria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.model.Industria;
import com.jfranco.aimercado.mercadoai.repository.Industria.IndustriaRepository;

@Service
public class IndustriaService implements IIndustriaService {

    @Autowired
    private IndustriaRepository industriaRepository;

    @Override
    public List<Industria> getAllIndustrias() {
        return industriaRepository.findAll();
    }

    @Override
    public Optional<Industria> getIndustriaById(Long id) {
        return industriaRepository.findById(id);
    }
}
