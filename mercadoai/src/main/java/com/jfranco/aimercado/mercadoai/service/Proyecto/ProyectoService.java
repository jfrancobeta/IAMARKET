package com.jfranco.aimercado.mercadoai.service.Proyecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;
import com.jfranco.aimercado.mercadoai.repository.Proyecto.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public ProyectoDTO save(ProyectoCreateDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ProyectoDTO update(Long id, ProyectoUpdateDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ProyectoDTO getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<ProyectoDTO> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}