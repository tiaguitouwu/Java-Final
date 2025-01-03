package com.controllers;

import com.entity.PedidoCompra;
import com.service.PedidoCompraService;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class PedidoCompraController {
    private final PedidoCompraService pedidoCompraService;

    public PedidoCompraController(PedidoCompraService pedidoCompraService) {
        this.pedidoCompraService = pedidoCompraService;
    }
    
    public void crearPedidoCompra(String nropedido, int idProveedor, int idTienda) {
        try {
            PedidoCompra ped = new PedidoCompra();
            ped.setNroPedido(nropedido);
            ped.setIdProveedor(idProveedor);
            ped.setIdTienda(idTienda);
            ped.setFechaPedido(LocalDateTime.now());
            ped.setEstado(0);
            ped.setFechaPedido(LocalDateTime.now());
            ped.setUsuario("AppUser");
            ped.setFechaUltModificacion(java.time.LocalDateTime.now());

            pedidoCompraService.add(ped);
            JOptionPane.showMessageDialog(null, "Cargado exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al cargar " + e.getMessage());
        }
    }
    public List<PedidoCompra> listarPedidoCompra() {
        try {
            return pedidoCompraService.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar " + e.getMessage());
            return List.of();
        }
    }
    public Optional<PedidoCompra> obtenerPedidoCompra(int id) {
        try {
            return pedidoCompraService.findById(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener" + e.getMessage());
            return Optional.empty();
        }
    }
    public void eliminarPedidoCompra(int id) {
        try {
            pedidoCompraService.delete(id);
            System.out.println("Tienda eliminada exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al eliminar"+ e.getMessage());
        }
    }
    
    public void actualizarPedidoCompra(int id, String nroPedido, int idProveedor, int idTienda, int estado) {
        try {
            PedidoCompra ped = new PedidoCompra(id, nroPedido, idProveedor, idTienda, java.time.LocalDateTime.now(), estado, "AppUser", java.time.LocalDateTime.now());
            pedidoCompraService.update(ped);
            JOptionPane.showMessageDialog(null, "Actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }
    
}
