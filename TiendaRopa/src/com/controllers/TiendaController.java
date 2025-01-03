package com.controllers;

import com.entity.Tienda;
import com.service.TiendaService;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class TiendaController {
     private final TiendaService tiendaService;

    public TiendaController(TiendaService tiendaService) {
        this.tiendaService = tiendaService;
    }
    
    public void crearTienda(String descripcion, String direccion, String correo, String telf) {
        try {
            Tienda tienda = new Tienda();
            tienda.setDescripcionTienda(descripcion);
            tienda.setDireccion(direccion);
            tienda.setCorreo(correo);
            tienda.setTelefono(telf);
            tienda.setUsuario("AppUser");
            tienda.setFechaUltModificacion(java.time.LocalDateTime.now());

            tiendaService.add(tienda);
            JOptionPane.showMessageDialog(null, "Tienda creada exitosamente.");
            System.out.println("Tienda creada exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al crear la categoría: " + e.getMessage());
        }
    }
    public List<Tienda> listarTienda() {
        try {
            return tiendaService.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar categorías: " + e.getMessage());
            return List.of();
        }
    }
    public Optional<Tienda> obtenerTienda(int id) {
        try {
            return tiendaService.findById(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener la categoría: " + e.getMessage());
            return Optional.empty();
        }
    }
    public void eliminarTienda(int id) {
        try {
            tiendaService.delete(id);
            System.out.println("Tienda eliminada exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al eliminar la categoría: " + e.getMessage());
        }
    }
    
    public void actualizarTienda(int id, String descripcion, String direccion,String tel, String correo) {
        try {
            
            Tienda tienda = new Tienda(id, descripcion, direccion, tel,  correo, "AppUser", java.time.LocalDateTime.now());
            tiendaService.update(tienda);
            JOptionPane.showMessageDialog(null, "Tienda creada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar la tienda: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar la tienda:");
        }
    }
    
}
