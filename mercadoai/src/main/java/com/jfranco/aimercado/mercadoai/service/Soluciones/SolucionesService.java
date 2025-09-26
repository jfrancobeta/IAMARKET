package com.jfranco.aimercado.mercadoai.service.Soluciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionUpdateDTO;
import com.jfranco.aimercado.mercadoai.mapper.Hito.HitoMapper;
import com.jfranco.aimercado.mercadoai.mapper.Solucion.SolucionMapper;
import com.jfranco.aimercado.mercadoai.model.Categoria;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Hito;
import com.jfranco.aimercado.mercadoai.model.Solucion;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.Categoria.CategoriaRepository;
import com.jfranco.aimercado.mercadoai.repository.Estado.EstadoRepository;
import com.jfranco.aimercado.mercadoai.repository.Habilidad.HabilidadRepository;
import com.jfranco.aimercado.mercadoai.repository.Solucion.SolucionesRespository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;

@Service
public class SolucionesService implements ISolucionesService {

        @Autowired
        private SolucionesRespository solucionesRespository;

        @Autowired
        private SolucionMapper solucionMapper;

        @Autowired
        private CategoriaRepository categoriaRepository;

        @Autowired
        private EstadoRepository estadoRepository;

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Autowired
        private HabilidadRepository habilidadRepository;

        @Autowired
        private HitoMapper hitoMapper;

        @Override
        public Page<SolucionSummaryDTO> getAllSoluciones(String search, String categoria, String estado,
                        Pageable pageable) {
                Page<Solucion> solucionesPage;
                if (search != null && !search.isEmpty()) {
                        solucionesPage = solucionesRespository.findByTituloContainingIgnoreCase(search, pageable);
                } else if (categoria != null && !categoria.isEmpty()) {
                        solucionesPage = solucionesRespository.findByCategoriaNombreIgnoreCase(categoria, pageable);
                } else if (estado != null && !estado.isEmpty()) {
                        solucionesPage = solucionesRespository.findByEstadoNombreIgnoreCase(estado, pageable);
                } else {
                        solucionesPage = solucionesRespository.findAll(pageable);
                }
                return solucionesPage.map(solucionMapper::toSummaryDTO);
        }

        @Override
        public SolucionDetailsDTO getSolucionById(Long id) {
                Solucion solucion = solucionesRespository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Solución no encontrada"));

                solucion.incrementarVistas();
                solucionesRespository.save(solucion);

                return solucionMapper.toDetailsDTO(solucion);
        }

        @Override
        public SolucionDTO saveSolucion(SolucionCreateDTO solucionCreate) {

                Categoria categoria = categoriaRepository.findById(solucionCreate.getCategoriaId())
                                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

                Estado estado = estadoRepository.findById(solucionCreate.getEstadoId())
                                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                String username = authentication.getName();
                Usuario usuario = usuarioRepository.findByUsername(username)
                                .orElseThrow(() -> new RuntimeException(
                                                "Usuario no encontrado con username: " + username));

                List<Habilidad> habilidades = habilidadRepository.findAllById(
                                solucionCreate.getHabilidadesIds() != null ? solucionCreate.getHabilidadesIds()
                                                : List.of());

                List<Hito> hitos = new ArrayList<>();
                if (solucionCreate.getHitos() != null) {
                        hitos = solucionCreate.getHitos().stream()
                                        .map(hitoMapper::toEntity)
                                        .toList();
                }
                Solucion solucion = solucionMapper.toEntity(solucionCreate, categoria, usuario, estado, habilidades,
                                hitos);
                solucion = solucionesRespository.save(solucion);
                return solucionMapper.toDTO(solucion);
        }

        @Override
        public SolucionDTO updateSolucion(Long id, SolucionUpdateDTO solucionDTO) {
                Solucion existingSolucion = solucionesRespository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Solución no encontrada"));
                                
                Categoria categoria = categoriaRepository.findById(solucionDTO.getCategoriaId())
                                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

                Estado estado = estadoRepository.findById(solucionDTO.getEstadoId())
                                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

                List<Habilidad> habilidades = habilidadRepository.findAllById(
                                solucionDTO.getHabilidadesIds() != null ? solucionDTO.getHabilidadesIds() : List.of());
                List<Hito> hitos;

                if (solucionDTO.getHitos() != null) {
                        hitos = new ArrayList<>(solucionDTO.getHitos().stream()
                                        .map(hitoMapper::toEntity)
                                        .toList());
                } 
                else {
                        hitos = new ArrayList<>();
                }
                solucionMapper.toEntity(existingSolucion, solucionDTO, categoria, estado, habilidades, hitos);
                return solucionMapper.toDTO(solucionesRespository.save(existingSolucion));
        }

        @Override
        public void eliminarSolucion(Long id) {
                Solucion existingSolucion = solucionesRespository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Solución no encontrada"));
                solucionesRespository.delete(existingSolucion);
        }

}
