package com.controllers;

import com.entity.DetallePedidoCompra;
import com.service.DetallePedidoCompraService;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DetallePedidoCompraController {
    private final DetallePedidoCompraService servicio;

    public DetallePedidoCompraController(DetallePedidoCompraService servicio) {
        this.servicio = servicio;
    }
    public Optional<DetallePedidoCompra> obtenerdetalle(int id) {
        try {
            return servicio.findById(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener" + e.getMessage());
            return Optional.empty();
        }
    }
    public List<DetallePedidoCompra> listarPedidoCompra() {
        try {
            return servicio.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar " + e.getMessage());
            return List.of();
        }
    }
    
}
