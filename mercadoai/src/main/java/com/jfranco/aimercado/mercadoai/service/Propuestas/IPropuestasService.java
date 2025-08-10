package com.jfranco.aimercado.mercadoai.service.Propuestas;

import java.util.List;

import com.jfranco.aimercado.mercadoai.model.Propuesta;

public interface IPropuestasService {


    List<Propuesta> getAllPropuestas();
    List<Propuesta> getPropuestasByDesarrollador();
    Propuesta getPropuestaById(Long id);
    Propuesta createPropuesta(Propuesta propuesta);
    void eliminarPropuesta(Long id);

    List<Propuesta> getPropuestasByNecesidad(Long necesidadId);

    
}
