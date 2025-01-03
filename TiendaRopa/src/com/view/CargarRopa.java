/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view;

import com.controllers.RopaController;
import com.entity.Ropa;
import com.repository.Categoria.CategoriaRepository;
import com.repository.Ropa.RopaRepository;
import com.repository.Talla.TallaRepository;
import com.service.CategoriaService;
import com.service.RopaService;
import com.service.TallaService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author yyy
 */
public class CargarRopa extends javax.swing.JFrame {
    
    TallaRepository tallaRepository = new TallaRepository();
    TallaService tallaService = new TallaService(tallaRepository);
    CategoriaRepository categoriaRepository = new CategoriaRepository();
    CategoriaService categoriaService = new CategoriaService(categoriaRepository);
    
    
    RopaRepository ropaRepository = new RopaRepository();
    RopaService ropaService = new RopaService(ropaRepository);
    RopaController ropaController = new RopaController(ropaService,tallaService, categoriaService);
    
    
    Ropa ropaPrueba = new Ropa(
    1, "Camiseta de algodón", 3, 2, "usuario123", LocalDateTime.now());

    List<Ropa> listaRopas = new ArrayList<>();
    /**
     * Creates new form ArticuloCRUD
     */
    public CargarRopa() {
           initComponents();
           cargarTabla();
           cargarCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbArticulo = new javax.swing.JTable();
        lblArticulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblTalla = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        cbTalla = new javax.swing.JComboBox<>();
        cbCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        lblCategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCategoria.setText("Categoria:");

        tbArticulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Descripción", "Talla", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(tbArticulo);

        lblArticulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblArticulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArticulo.setText("ARTICULO");

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblId.setText("Id:");

        txtId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/remove.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDescripcion.setText("Descripción:");

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("");
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/confirm.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setPreferredSize(new java.awt.Dimension(99, 68));
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblTalla.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTalla.setText("Talla:");

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBuscar.setText("Buscar:");

        cbTalla.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbTalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Talla S", "Talla P", "Talla M", "Talla G" }));

        cbCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Verano", "Invierno", "Otoño", "Primavera" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescripcion)
                                    .addComponent(lblTalla)
                                    .addComponent(lblCategoria)
                                    .addComponent(lblId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                    .addComponent(txtDescripcion)
                                    .addComponent(cbTalla, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                            .addComponent(txtBuscar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(lblArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTalla))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
  
        String descripcion = txtDescripcion.getText();
        int idtalla = ropaController.getSelectedComboId(cbTalla);
        int idcategoria = ropaController.getSelectedComboId(cbCategoria);
        ropaController.actualizarCategoria(Integer.valueOf(txtId.getText()), descripcion,idtalla,idcategoria);
        cargarTabla();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if (validarCampos()) {
            String descripcion = txtDescripcion.getText();
            int idtalla = ropaController.getSelectedComboId(cbTalla);
            int idcategoria = ropaController.getSelectedComboId(cbCategoria);

            ropaController.crearRopa(descripcion, idtalla, idcategoria);

            txtId.setText("");
            txtDescripcion.setText("");
            cbTalla.setSelectedIndex(0);
            cbCategoria.setSelectedIndex(0);

            JOptionPane.showMessageDialog(this, "Articulo guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ropaController.eliminarCategoria(Integer.valueOf(txtId.getText()));
        cargarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
        String inputText = txtBuscar.getText().trim();

        if (inputText.isEmpty()) {
            cargarTabla();
        } else {
            try {
                int ropaId = Integer.parseInt(inputText);

                Optional<Ropa> ropaOpt = ropaController.obtenerCategoria(ropaId);

                ropaOpt.ifPresentOrElse(ropa -> {
                    String[] columnNames = {"ID", "Descripción", "Talla", "Fecha de Modificación"};
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

                    model.addRow(new Object[]{
                        ropa.getId(),
                        ropa.getDescripcion(),
                        ropa.getIdTalla(),
                        ropa.getFechaUltModificacion()
                    });

                    tbArticulo.setModel(model);
                }, () -> {
                    JOptionPane.showMessageDialog(null, "Artículo no encontrado");
                });
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido");
            }
        }
    }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void cargarTabla() {
        List<Ropa> ropaList = ropaController.listarCategoria();  

        if (ropaList.isEmpty()) {
            return;
        }

        String[] columnas = {"ID", "Categoría","Talla", "Descripción", "Usuario", "Fecha Últ. Modificación"};

        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        for (Ropa ropa : ropaList) {
            model.addRow(new Object[]{
                    ropa.getId(),
                    ropa.getIdCategoria(),
                    ropa.getIdTalla(),
                    ropa.getDescripcion(),
                    ropa.getUsuario(),
                    ropa.getFechaUltModificacion()
            });
        }
        tbArticulo.setModel(model);
    }
    
    private void cargarCombos(){
        ropaController.tallaParaCombo(cbTalla);
        ropaController.categoriaParaCombo(cbCategoria);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbTalla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArticulo;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTalla;
    private javax.swing.JTable tbArticulo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    private boolean validarCampos() {
        if (txtId.getText().trim().isEmpty() || 
            txtDescripcion.getText().trim().isEmpty() || String.valueOf(cbTalla.getSelectedIndex()).trim().isEmpty() || 
            String.valueOf(cbCategoria.getSelectedIndex()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}