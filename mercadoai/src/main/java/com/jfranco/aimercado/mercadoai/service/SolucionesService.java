package com.jfranco.aimercado.mercadoai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.model.Solucion;
import com.jfranco.aimercado.mercadoai.repository.SolucionesRespository;

@Service
public class SolucionesService implements ISolucionesService {


    @Autowired
    private SolucionesRespository solucionesRespository;

    @Override
    public List<Solucion> getAllSoluciones() {
        return solucionesRespository.findAll();
    }

    @Override
    public Solucion getSolucionById(Long id) {
        return solucionesRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solución no encontrada con ID: " + id));
    }

    @Override
    public Solucion saveSolucion(Solucion solucion) {
        return solucionesRespository.save(solucion);
    }

    @Override
    public void eliminarSolucion(Long id) {
        Solucion solucion = getSolucionById(id);
        solucionesRespository.delete(solucion);
    }
    
}
