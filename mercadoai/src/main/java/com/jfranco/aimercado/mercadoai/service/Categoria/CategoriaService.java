package com.jfranco.aimercado.mercadoai.service.Categoria;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Categoria.CategoriaCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Categoria.CategoriaDTO;
import com.jfranco.aimercado.mercadoai.dto.Categoria.CategoriaUpdateDTO;
import com.jfranco.aimercado.mercadoai.model.Categoria;
import com.jfranco.aimercado.mercadoai.repository.Categoria.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaRepository.findAll().stream()
                .map(categoria -> new CategoriaDTO(categoria.getId(), categoria.getNombre()))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO getCategoriaById(Long id) {
        return categoriaRepository.findById(id)
                .map(categoria -> new CategoriaDTO(categoria.getId(), categoria.getNombre()))
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    @Override
    public CategoriaDTO createCategoria(CategoriaCreateDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria.getId(), categoria.getNombre());
    }

    @Override
    public CategoriaDTO updateCategoria(Long id, CategoriaUpdateDTO dto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        categoria.setNombre(dto.getNombre());
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria.getId(), categoria.getNombre());
    }

    @Override
    public void deleteCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        categoriaRepository.delete(categoria);
    }
}
