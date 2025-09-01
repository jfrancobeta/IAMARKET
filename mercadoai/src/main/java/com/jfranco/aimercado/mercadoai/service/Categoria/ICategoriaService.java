package com.jfranco.aimercado.mercadoai.service.Categoria;

import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Categoria.CategoriaCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Categoria.CategoriaDTO;
import com.jfranco.aimercado.mercadoai.dto.Categoria.CategoriaUpdateDTO;

public interface ICategoriaService {
    List<CategoriaDTO> getAllCategorias();
    CategoriaDTO getCategoriaById(Long id);
    CategoriaDTO createCategoria(CategoriaCreateDTO dto);
    CategoriaDTO updateCategoria(Long id, CategoriaUpdateDTO dto);
    void deleteCategoria(Long id);
}
