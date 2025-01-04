/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.entity.FacturaCompra;
import com.entity.PedidoCompra;
import com.service.FacturaCompraService;
import com.service.PedidoCompraService;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Romina
 */
public class FacturaCompraController {
    private final FacturaCompraService servicio;
    private PedidoCompraService serv = null;

    public FacturaCompraController(FacturaCompraService servicio) {
        this.servicio = servicio;
    }
    
    public FacturaCompraController(FacturaCompraService servicio, PedidoCompraService serv){
        this.servicio = servicio;
        this.serv = serv;
    }
    
    public void crearFactura(String nrofactura, int idpedido) throws SQLException{
        
        FacturaCompra facturaCompra = new FacturaCompra();
        
        facturaCompra.setNroFactura(nrofactura);
        facturaCompra.setIdPedidoCompra(idpedido);
        facturaCompra.setUsuario("AppUser");
        facturaCompra.setFechaFactura(java.time.LocalDateTime.now());
        facturaCompra.setFechaUltModificacion(java.time.LocalDateTime.now());
        
        servicio.add(facturaCompra);
    }
    
    public List<FacturaCompra> listarFacturaCompra() {
        try {
            return servicio.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar " + e.getMessage());
            return List.of();
        }
    }
    public Optional<FacturaCompra> obtenerFacturaCompra(int id) {
        try {
            return servicio.findById(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener" + e.getMessage());
            return Optional.empty();
        }
    }
    public void pedidoCombo(JComboBox<String> comboBox) {
        try {
            List<PedidoCompra> ropaList = serv.findAll();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            comboBox.setModel(model);
            comboBox.removeAllItems();

            for (PedidoCompra ropa : ropaList) {
                model.addElement(ropa.getId() + "");
                comboBox.putClientProperty(ropa.getId() + "", ropa.getId());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las tallas: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int getSelectedComboId(JComboBox<String> comboBox) {
        String selectedDescripcion = (String) comboBox.getSelectedItem();
        return selectedDescripcion != null ? (int) comboBox.getClientProperty(selectedDescripcion) : -1;
    }
}
