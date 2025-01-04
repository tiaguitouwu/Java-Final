package com.controllers;

import com.entity.DetallePedidoCompra;
import com.entity.PedidoCompra;
import com.entity.Proveedor;
import com.entity.Ropa;
import com.entity.Tienda;
import com.service.DetallePedidoCompraService;
import com.service.PedidoCompraService;
import com.service.ProveedorService;
import com.service.RopaService;
import com.service.TiendaService;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PedidoCompraController {
    private final PedidoCompraService pedidoCompraService;
    private DetallePedidoCompraService servicio = null;
    private RopaService ropaService = null;
    private ProveedorService provserv = null;
    private TiendaService tserv = null;

    public PedidoCompraController(PedidoCompraService pedidoCompraServico) {
        this.pedidoCompraService = pedidoCompraServico;
    }
    
    public PedidoCompraController(PedidoCompraService pedidoCompraServico, 
                                  DetallePedidoCompraService servicio, 
                                  RopaService ropaservice,
                                  ProveedorService provserv,
                                  TiendaService tserv) {
        this.pedidoCompraService = pedidoCompraServico;
        this.servicio = servicio;
        this.ropaService = ropaservice;
        this.provserv = provserv;
        this.tserv = tserv;
    }
    
    public void crearPedidoCompra(int idProveedor, int idTienda, int idropa, int cantidad, int precio){
        try {
            PedidoCompra ped = new PedidoCompra();
            ped.setIdProveedor(idProveedor);
            ped.setNroPedido("0");
            ped.setIdTienda(idTienda);
            ped.setFechaPedido(LocalDateTime.now());
            ped.setEstado(0);
            ped.setUsuario("AppUser");
            ped.setFechaUltModificacion(java.time.LocalDateTime.now());
            pedidoCompraService.add(ped);
            
            Optional<Integer> lastId = obtenerUltimoId();
            
            DetallePedidoCompra det = new DetallePedidoCompra();
            det.setIdPedidoCompra(lastId.get());
            det.setCantidad(cantidad);
            det.setIdRopa(idropa);
            det.setPrecio(precio);
            det.setUsuario("AppUser");
            det.setFechaUltModificacion(java.time.LocalDateTime.now());
            
            servicio.add(det);
            
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
    
    public Optional<Integer> obtenerUltimoId() {
        try {
            return pedidoCompraService.findAll()
                .stream()
                .map(PedidoCompra::getId) // Assuming getId() exists
                .max(Integer::compareTo); // Get the maximum ID
        } catch (SQLException e) {
            System.err.println("Error al obtener el último ID: " + e.getMessage());
            return Optional.empty();
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
            System.out.println("Pedido eliminado exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al eliminar"+ e.getMessage());
        }
    }
    
    public void actualizarPedidoCompra(int id, int idProveedor, int idTienda, int estado,int cantidad, int idropa, int precio) {
        try {
            PedidoCompra ped = new PedidoCompra(id, "1", idProveedor, idTienda, java.time.LocalDateTime.now(), estado, "AppUser", java.time.LocalDateTime.now(),null);
            pedidoCompraService.update(ped);
            
            DetallePedidoCompra det = new DetallePedidoCompra();
            det.setIdPedidoCompra(id);
            det.setCantidad(cantidad);
            det.setIdRopa(idropa);
            det.setPrecio(precio);
            
            JOptionPane.showMessageDialog(null, "Actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }
    
    public List<DetallePedidoCompra> listarDetallePedidoCompra() {
        try {
            return servicio.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar " + e.getMessage());
            return List.of();
        }
    }
    
    public void ropaParaCombo(JComboBox<String> comboBox) {
        try {
            List<Ropa> ropaList = ropaService.findAll();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            comboBox.setModel(model);
            comboBox.removeAllItems();

            for (Ropa ropa : ropaList) {
                model.addElement(ropa.getDescripcion());
                comboBox.putClientProperty(ropa.getDescripcion(), ropa.getId());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las tallas: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void proveedorParaCombo(JComboBox<String> comboBox) {
        try {
            List<Proveedor> ropaList = provserv.findAll();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            comboBox.setModel(model);
            comboBox.removeAllItems();

            for (Proveedor ropa : ropaList) {
                model.addElement(ropa.getRazonSocial());
                comboBox.putClientProperty(ropa.getRazonSocial(), ropa.getId());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las tallas: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void tiendaParaCombo(JComboBox<String> comboBox) {
        try {
            List<Tienda> ropaList = tserv.findAll();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            comboBox.setModel(model);
            comboBox.removeAllItems();

            for (Tienda ropa : ropaList) {
                model.addElement(ropa.getDescripcionTienda());
                comboBox.putClientProperty(ropa.getDescripcionTienda(), ropa.getId());
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
