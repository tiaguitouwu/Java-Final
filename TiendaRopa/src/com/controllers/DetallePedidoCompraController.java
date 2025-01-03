package com.controllers;

import com.entity.DetallePedidoCompra;
import com.service.DetallePedidoCompraService;
import java.sql.SQLException;
import java.util.List;

public class DetallePedidoCompraController {
    private final DetallePedidoCompraService servicio;

    public DetallePedidoCompraController(DetallePedidoCompraService servicio) {
        this.servicio = servicio;
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
