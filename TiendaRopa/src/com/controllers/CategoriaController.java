package com.controllers;

import com.entity.Categoria;
import com.service.CategoriaService;
import java.sql.SQLException;

public class CategoriaController {
     private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    public void crearCategoria(String descripcion, String usuario) {
        try {
            Categoria categoria = new Categoria();
            categoria.setDescripcionCategoria(descripcion);
            categoria.setUsuario(usuario);
            categoria.setFechaUltModificacion(java.time.LocalDateTime.now());

            categoriaService.add(categoria);
            System.out.println("Categoría creada exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al crear la categoría: " + e.getMessage());
        }
    }
    
    
}
