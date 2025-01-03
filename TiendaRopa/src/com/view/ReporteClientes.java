/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view;

import com.controllers.ClienteController;
import com.entity.Cliente;
import com.repository.Cliente.ClienteRepository;
import com.service.ClienteService;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jen
 */
public class ReporteClientes extends javax.swing.JFrame {

    ClienteRepository clienteRepository = new ClienteRepository();
    ClienteService clienteService = new ClienteService(clienteRepository);
    ClienteController clienteController = new ClienteController(clienteService);
    
    public ReporteClientes() {
        initComponents();
        cargarTabla();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Razon Social", "Nombre", "Apellido", "RUC"
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
        jLabel2.setText("REPORTE DE CLIENTES REGISTRADOS");

        jLabel1.setText("ID Cliente");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel2)))
                .addContainerGap(15, Short.MAX_VALUE))
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
            Optional<Cliente> clienteOpt = clienteController.obtenerCliente(Integer.valueOf(jTextField1.getText()));  // Get Tienda by ID

            clienteOpt.ifPresentOrElse(cliente -> {
            String[] columnNames = {"ID", "Razón Social", "Nombre", "Apellido", "RUC" , "Usuario", "Fecha de Modificación"};

            // Create the table model
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            // Add the Tienda data to the table model (for a single Tienda)
            model.addRow(new Object[]{
                    cliente.getId(),
                    cliente.getRazonSocial(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getRuc(),
                    cliente.getUsuario(),
                    cliente.getFechaUltModificacion()
            });

            jTable1.setModel(model);


        }, () -> {
            JOptionPane.showMessageDialog(null, "Tienda no encontrada");
        });
        }
    }//GEN-LAST:event_jTextField1KeyPressed
    
    public void cargarTabla(){
        List<Cliente> clienteList = clienteController.listarCliente();
        if (clienteList.isEmpty()) {
            return;
        }
        String[] columnNames = {"ID", "Razón Social", "Nombre", "Apellido", "RUC" , "Usuario", "Fecha de Modificación"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Cliente cliente : clienteList) {
            model.addRow(new Object[]{
                    cliente.getId(),
                    cliente.getRazonSocial(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getRuc(),
                    cliente.getUsuario(),
                    cliente.getFechaUltModificacion()
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
