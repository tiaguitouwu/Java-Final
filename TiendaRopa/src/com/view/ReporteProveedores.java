/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view;

import com.controllers.ProveedorController;
import com.entity.Proveedor;
import com.repository.Proveedor.ProveedorRepository;
import com.service.ProveedorService;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jen
 */
public class ReporteProveedores extends javax.swing.JFrame {

    ProveedorRepository proveedorRepository = new ProveedorRepository();
    ProveedorService proveedorService = new ProveedorService(proveedorRepository);
    ProveedorController proveedorController = new ProveedorController(proveedorService);
    /**
     * Creates new form ReporteProductos
     */
    public ReporteProveedores() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Proveedor", "Razon Social", "Nombre", "Apellido", "RUC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("REPORTE DE PROVEEDORES REGISTRADOS");

        jLabel1.setText("ID Proveedor");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER) {
        String inputText = jTextField1.getText().trim();
        
        if (inputText.isEmpty()) {
            cargarTabla();
        } else {
            try {
                int proveedorId = Integer.parseInt(inputText); 
                
                Optional<Proveedor> clienteOpt = proveedorController.obtenerProveedor(proveedorId);
                clienteOpt.ifPresentOrElse(proveedor -> {
                    String[] columnNames = {"ID", "Razón Social", "Nombre", "Apellido", "RUC", "Usuario", "Fecha Mod."};

                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

                    model.addRow(new Object[]{
                        proveedor.getId(),
                        proveedor.getRazonSocial(),
                        proveedor.getNombre(),
                        proveedor.getApellido(),
                        proveedor.getRuc(),
                        proveedor.getUsuario(),
                        proveedor.getFechaUltModificacion()
                    });

                    jTable1.setModel(model);
                }, () -> {
                    JOptionPane.showMessageDialog(null, "Proveedor no encontrado");
                });
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido");
            }
        }
    }
    }//GEN-LAST:event_jTextField1KeyPressed

    public void cargarTabla(){
        List<Proveedor> proveedorList = proveedorController.listarProveedor();
        if (proveedorList.isEmpty()) {
            return;
        }
        String[] columnNames = {"ID", "Razón Social", "Nombre", "Apellido", "RUC" , "Usuario", "Fecha Mod."};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Proveedor proveedor : proveedorList) {
            model.addRow(new Object[]{
                    proveedor.getId(),
                    proveedor.getRazonSocial(),
                    proveedor.getNombre(),
                    proveedor.getApellido(),
                    proveedor.getRuc(),
                    proveedor.getUsuario(),
                    proveedor.getFechaUltModificacion()
            });
        }

        // Set the table model to jTable1
        jTable1.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
