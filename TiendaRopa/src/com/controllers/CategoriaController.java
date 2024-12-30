package com.controllers;

import com.entity.Categoria;
import com.service.CategoriaService;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
    public void listarCategorias() {
        try {
            List<Categoria> categorias = categoriaService.findAll();
            if (categorias.isEmpty()) {
                System.out.println("No hay categorías disponibles.");
            } else {
                System.out.println("Categorías:");
                for (Categoria categoria : categorias) {
                    System.out.printf("ID: %d, Descripción: %s, Usuario: %s, Fecha: %s%n",
                            categoria.getId(),
                            categoria.getDescripcionCategoria(),
                            categoria.getUsuario(),
                            categoria.getFechaUltModificacion());
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar categorías: " + e.getMessage());
        }
    }
    public void obtenerCategoria(int id) {
        try {
            Optional<Categoria> categoria = categoriaService.findById(id);
            if (categoria.isPresent()) {
                System.out.printf("ID: %d, Descripción: %s, Usuario: %s, Fecha: %s%n",
                        categoria.get().getId(),
                        categoria.get().getDescripcionCategoria(),
                        categoria.get().getUsuario(),
                        categoria.get().getFechaUltModificacion());
            } else {
                System.out.println("Categoría no encontrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la categoría: " + e.getMessage());
        }
    }
    public void eliminarCategoria(int id) {
        try {
            categoriaService.delete(id);
            System.out.println("Categoría eliminada exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al eliminar la categoría: " + e.getMessage());
        }
    }
    
    
}
