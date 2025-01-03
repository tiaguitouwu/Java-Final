/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.entity.Proveedor;
import com.service.ProveedorService;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author yyy
 */
public class ProveedorController {
    
    private final ProveedorService proveedorService;
    
    
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }
    
    public void crearProveedor(String razonSocial, String nombre, String apellido, String ruc, String usuario, LocalDateTime fecha) {
        try {
            Proveedor prov = new Proveedor();
            prov.setRazonSocial(razonSocial);
            prov.setNombre(nombre);
            prov.setApellido(apellido);
            prov.setRuc(ruc);
            prov.setUsuario(usuario);
            prov.setFechaUltModificacion(fecha);
            
            proveedorService.add(prov);
            System.out.println("Categoría creada exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al crear la categoría: " + e.getMessage());
        }
    }
    public List<Proveedor> listarProveedor() {
        try {
            return proveedorService.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar proveedores: " + e.getMessage());
            return List.of();
        }
    }
    public Optional<Proveedor> obtenerProveedor(int id) {
        try {
            return proveedorService.findById(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener el proveedor: " + e.getMessage());
            return Optional.empty();
        }
    }
    
    public void eliminarProveedor(int id) {
        try {
            proveedorService.delete(id);
            System.out.println("Proveedor eliminado exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al eliminar al Proveedor: " + e.getMessage());
        }
    }
    public void actualizarProveedor(Proveedor prov) {
        try {
            proveedorService.update(prov);
            JOptionPane.showMessageDialog(null, "Tienda creada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar la tienda: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar la tienda:");
        }
    }
}
