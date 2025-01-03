package com.controllers;

import com.entity.Cliente;
import com.service.ClienteService;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }
    
    public void crearCliente(String nombre, String apellido, String razonSocial, String ruc) {
        try {
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setRazonSocial(razonSocial);
            cliente.setRuc(ruc);
            cliente.setUsuario("AppUser");
            cliente.setFechaUltModificacion(java.time.LocalDateTime.now());

            service.add(cliente);
            System.out.println("Cliente creado exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al crear el cliente: " + e.getMessage());
        }
    }
    public List<Cliente> listarCliente() {
        try {
            return service.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
            return List.of();
        }
    }
    public Optional<Cliente> obtenerCliente(int id) {
        try {
            return service.findById(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener los clientes: " + e.getMessage());
            return Optional.empty();
        }
    }
    
    public void eliminarCliente(int id) {
        try {
            service.delete(id);
            System.out.println("Cliente eliminado exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }
    public void actualizarCliente(int id, String nombre, String apellido, String razonSocial, String ruc) {
        try {
            Cliente cliente = new Cliente(id, razonSocial, nombre, apellido, ruc, "AppUser", java.time.LocalDateTime.now());
            service.update(cliente);
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar el cliente: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente:");
        }
    }
}
