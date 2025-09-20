package com.jfranco.aimercado.mercadoai.service.Soluciones;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionUpdateDTO;

public interface ISolucionesService {

    Page<SolucionSummaryDTO> getAllSoluciones(String search, String categoria, String estado, Pageable pageable);
    SolucionDetailsDTO getSolucionById(Long id);
    SolucionDTO saveSolucion(SolucionCreateDTO solucion);
    SolucionDTO updateSolucion(Long id, SolucionUpdateDTO solucionDTO);   
    void eliminarSolucion(Long id);
    
}