package com.controllers;

import com.entity.Stock;
import com.service.StockService;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class StockController {
     private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    
    public void crearStock(int idTienda, int idRopa, int cantidad) {
        try {
            Stock stock = new Stock();
            stock.setIdTienda(idTienda);
            stock.setIdRopa(idRopa);
            stock.setCantidadExistencia(cantidad);
            stock.setFechaUltModificacion(java.time.LocalDateTime.now());

            stockService.add(stock);
            JOptionPane.showMessageDialog(null, "Stock cargado exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al cargar " + e.getMessage());
        }
    }
    public List<Stock> listarStock() {
        try {
            return stockService.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar " + e.getMessage());
            return List.of();
        }
    }
    public Optional<Stock> obtenerStock(int id) {
        try {
            return stockService.findById(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener" + e.getMessage());
            return Optional.empty();
        }
    }
    public void eliminarStock(int id) {
        try {
            stockService.delete(id);
            System.out.println("Stock eliminado exitosamente.");
            JOptionPane.showMessageDialog(null, "Stock eliminado exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al eliminar"+ e.getMessage());
        }
    }
    
    public void actualizarStock(int id, int idTienda, int idRopa, int cantidad) {
        try {
            Stock stock = new Stock(id, idTienda, idRopa, cantidad, java.time.LocalDateTime.now());
            stockService.update(stock);
            JOptionPane.showMessageDialog(null, "Actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }
    
}
