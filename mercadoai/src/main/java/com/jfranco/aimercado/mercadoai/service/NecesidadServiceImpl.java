
package com.jfranco.aimercado.mercadoai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.EstadoRepository;
import com.jfranco.aimercado.mercadoai.repository.HabilidadesRepository;
import com.jfranco.aimercado.mercadoai.repository.NecesidadesRepository;
import com.jfranco.aimercado.mercadoai.repository.UsuarioRepository;

@Service
public class NecesidadServiceImpl implements INecesidadesService {

    @Autowired
    private NecesidadesRepository necesidadesRepostitory;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private HabilidadesRepository habilidadesRepository;
    
    @Override
    public List<Necesidad> getAllNecesidades() {
        return necesidadesRepostitory.findAll();
    }

    @Override
    public Necesidad getNecesidadById(Long id) {
        return necesidadesRepostitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));
    }

    @Override
    public Necesidad saveNecesidad(NecesidadDTO necesidadDTO) {
        Usuario compania = usuarioRepository.findById(necesidadDTO.getCompañiaId())
                .orElseThrow(() -> new RuntimeException("Compañía no encontrada con id: " + necesidadDTO.getCompañiaId()));

        Estado estado = estadoRepository.findById(necesidadDTO.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con id: " + necesidadDTO.getEstadoId()));

        List<Habilidad> habilidades = habilidadesRepository.findAllById(necesidadDTO.getSkillsRequiredIds());
        Necesidad necesidad = new Necesidad();
        necesidad.setTitulo(necesidadDTO.getTitulo());
        necesidad.setDescripcion(necesidadDTO.getDescripcion());
        necesidad.setCategoria(necesidadDTO.getCategoria());
        necesidad.setPresupuesto(necesidadDTO.getPresupuesto());
        necesidad.setCompañia(compania);
        necesidad.setFechaLimite(necesidadDTO.getFechaLimite());
        necesidad.setSkillsRequired(habilidades);
        necesidad.setRequirements(necesidadDTO.getRequirements());
        necesidad.setExpectedDeliverables(necesidadDTO.getExpectedDeliverables());
        necesidad.setEstado(estado);

        return necesidadesRepostitory.save(necesidad);
    }

    @Override
    public Necesidad updateNecesidad(Long id, NecesidadDTO dto) {
        Necesidad necesidad = getNecesidadById(id);
        Usuario compania = usuarioRepository.findById(dto.getCompañiaId())
                .orElseThrow(() -> new RuntimeException("Compañía no encontrada con id: " + dto.getCompañiaId()));
        Estado estado = estadoRepository.findById(dto.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con id: " + dto.getEstadoId()));
        List<Habilidad> habilidades = habilidadesRepository.findAllById(dto.getSkillsRequiredIds());

        necesidad.setTitulo(dto.getTitulo());
        necesidad.setDescripcion(dto.getDescripcion());
        necesidad.setCategoria(dto.getCategoria());
        necesidad.setPresupuesto(dto.getPresupuesto());
        necesidad.setCompañia(compania);
        necesidad.setFechaLimite(dto.getFechaLimite());
        necesidad.setSkillsRequired(habilidades);
        necesidad.setRequirements(dto.getRequirements());
        necesidad.setExpectedDeliverables(dto.getExpectedDeliverables());
        necesidad.setEstado(estado);
       

        return necesidadesRepostitory.save(necesidad);
    }

    @Override
    public void deleteNecesidad(Long id) {
        Necesidad necesidad = getNecesidadById(id);
        necesidadesRepostitory.delete(necesidad);
    }
    
}
