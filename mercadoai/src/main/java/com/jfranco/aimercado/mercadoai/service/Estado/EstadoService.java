package com.jfranco.aimercado.mercadoai.service.Estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.repository.Estado.EstadoRepository;

@Service
public class EstadoService implements IEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }
    
}
