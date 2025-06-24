package com.jfranco.aimercado.mercadoai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.NecesidadesRepository;
import com.jfranco.aimercado.mercadoai.repository.PropuestaRepository;
import com.jfranco.aimercado.mercadoai.repository.UsuarioRepository;

public class PropuestaServiceImpl implements IPropuestasService{

    @Autowired
    private PropuestaRepository propuestaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NecesidadesRepository necesidadesRepository;

    @Override
    public List<Propuesta> getAllPropuestas() {
        return propuestaRepository.findAll();
    }

    @Override
    public List<Propuesta> getPropuestasByDesarrollador() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = usuarioRepository.findByUsername(email)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));
        return propuestaRepository.findByDesarrollador(usuario);
    }

    @Override
    public Propuesta getPropuestaById(Long id) {
        return propuestaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Propuesta no encontrada con id: " + id));
    }

    @Override
    public Propuesta createPropuesta(Propuesta propuesta) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = usuarioRepository.findByUsername(email)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));
        
        propuesta.setDesarrollador(usuario);
        
        Necesidad necesidad = necesidadesRepository.findById(propuesta.getNecesidad().getId())
            .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + propuesta.getNecesidad().getId()));
        
        propuesta.setNecesidad(necesidad);
        
        return propuestaRepository.save(propuesta);
    }

    @Override
    public void eliminarPropuesta(Long id) {
        Propuesta propuesta = propuestaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Propuesta no encontrada con id: " + id));
        propuestaRepository.delete(propuesta);
    }

    @Override
    public List<Propuesta> getPropuestasByNecesidad(Long necesidadId) {
       Necesidad necesidad = necesidadesRepository.findById(necesidadId)
            .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + necesidadId));
        return propuestaRepository.findByNecesidad(necesidad);
    }
    
}
