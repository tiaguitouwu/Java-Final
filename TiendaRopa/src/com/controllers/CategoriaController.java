package com.controllers;

import com.entity.Categoria;
import com.entity.Tienda;
import com.service.CategoriaService;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    public void crearCategoria(String descripcion) {
        try {
            Categoria categoria = new Categoria();
            categoria.setDescripcionCategoria(descripcion);
            categoria.setUsuario("AppUser");
            categoria.setFechaUltModificacion(java.time.LocalDateTime.now());

            categoriaService.add(categoria);
            JOptionPane.showMessageDialog(null, "Categoria creada exitosamente.");
            System.out.println("Categoría creada exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al crear la categoría: " + e.getMessage());
        }
    }
    public List<Categoria> listarCategoria() {
        try {
            return categoriaService.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar categorías: " + e.getMessage());
            return List.of();
        }
    }
    public Optional<Categoria> obtenerCategoria(int id) {
        try {
            return categoriaService.findById(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener la categoría: " + e.getMessage());
            return Optional.empty();
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
    public void actualizarCategoria(int id, String descripcion) {
        try {
            Categoria cat = new Categoria(id, descripcion, "AppUser", java.time.LocalDateTime.now());
            categoriaService.update(cat);
            JOptionPane.showMessageDialog(null, "Categoría actualizada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar la tienda: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar la categoría:");
        }
    }
    
    
}
