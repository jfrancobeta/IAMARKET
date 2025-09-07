package com.jfranco.aimercado.mercadoai.service.Pais;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.model.Pais;
import com.jfranco.aimercado.mercadoai.repository.Pais.PaisRepository;

@Service
public class PaisService implements IPaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    @Override
    public Optional<Pais> getPaisById(Long id) {
        return paisRepository.findById(id);
    }
}
