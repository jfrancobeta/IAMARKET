package com.jfranco.aimercado.mercadoai.service.Soluciones;

import java.util.List;

import com.jfranco.aimercado.mercadoai.model.Solucion;

public interface ISolucionesService {

    List<Solucion> getAllSoluciones();
    Solucion getSolucionById(Long id);
    Solucion saveSolucion(Solucion solucion);
    void eliminarSolucion(Long id);
    
}
