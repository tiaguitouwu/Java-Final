package com.controllers;

import com.entity.Categoria;
import com.entity.Ropa;
import com.entity.Talla;
import com.service.CategoriaService;
import com.service.RopaService;
import com.service.TallaService;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class RopaController {
    private final RopaService ropaService;
    private final TallaService tallaService;
    private final CategoriaService categoriaService;

    public RopaController(RopaService ropaService, TallaService tallaService, CategoriaService categoriaService) {
        this.ropaService = ropaService;
        this.tallaService = tallaService;
        this.categoriaService = categoriaService;
    }
    
    public void crearRopa(String descripcion, int idtalla, int idcategoria) {
        try {
            Ropa ropa = new Ropa();
            ropa.setDescripcion(descripcion);
            ropa.setIdTalla(idtalla);
            ropa.setIdCategoria(idcategoria);
            ropa.setUsuario("AppUser");
            ropa.setFechaUltModificacion(java.time.LocalDateTime.now());

            ropaService.add(ropa);
            System.out.println("Articulo creado exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al crear el articulo: " + e.getMessage());
        }
    }
    public List<Ropa> listarCategoria() {
        try {
            return ropaService.findAll();
        } catch (SQLException e) {
            System.err.println("Error al listar articulos: " + e.getMessage());
            return List.of();
        }
    }
    public Optional<Ropa> obtenerCategoria(int id) {
        try {
            return ropaService.findById(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener el articulo: " + e.getMessage());
            return Optional.empty();
        }
    }
    
    public void eliminarCategoria(int id) {
        try {
            ropaService.delete(id);
            System.out.println("Articulo eliminado exitosamente.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error al eliminar el articulo: " + e.getMessage());
        }
    }
    public void actualizarCategoria(int id, String descripcion, int idtalla, int idcategoria) {
        try {
            Ropa ropa = new Ropa(id, descripcion,idtalla,idcategoria, "AppUser", java.time.LocalDateTime.now());
            ropaService.update(ropa);
            JOptionPane.showMessageDialog(null, "Articulo actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar el Articulo: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar el Articulo:");
        }
    }
    public void tallaParaCombo(JComboBox<String> comboBox) {
        try {
            List<Talla> tallaList = tallaService.findAll();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            comboBox.setModel(model);
            comboBox.removeAllItems();

            for (Talla talla : tallaList) {
                model.addElement(talla.getDescripcionTalla());
                comboBox.putClientProperty(talla.getDescripcionTalla(), talla.getId());
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
    
    public void categoriaParaCombo(JComboBox<String> comboBox) {
        try {
            List<Categoria> catList = categoriaService.findAll();
            
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            comboBox.setModel(model);
            comboBox.removeAllItems();

            for (Categoria cat : catList) {
                model.addElement(cat.getDescripcionCategoria());
                comboBox.putClientProperty(cat.getDescripcionCategoria(), cat.getId());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las categorias: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean existeRopa(int id) {
         try {
            return ropaService.findById(id).isPresent();
        } catch (SQLException e) {
            System.err.println("Error al obtener: " + e.getMessage());
            return false;
        }
    }
}

    
    

