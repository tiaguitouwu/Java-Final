/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view;

import javax.swing.JFrame;

/**
 *
 * @author tiago
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    public Inicio() {
        
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

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cargaVenta = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        cargarCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cargarCompra = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        cargarStock = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión Tienda Ropa");
        setAutoRequestFocus(false);
        setForeground(java.awt.Color.white);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/fondoApp2.jpg"))); // NOI18N
        jLabel1.setFocusable(false);

        jMenu1.setLabel("Venta");

        cargaVenta.setText("Pedidos");
        cargaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargaVentaActionPerformed(evt);
            }
        });
        jMenu1.add(cargaVenta);

        jMenuItem4.setText("Factura");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        cargarCliente.setText("Clientes");
        jMenu1.add(cargarCliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setLabel("Compra");

        cargarCompra.setText("Pedidos");
        cargarCompra.setActionCommand("Pedido");
        jMenu2.add(cargarCompra);

        jMenuItem5.setText("Factura");
        jMenu2.add(jMenuItem5);

        jMenuItem1.setText("Proveedores");
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        cargarStock.setLabel("Inventario");

        jMenuItem3.setText("Stock");
        cargarStock.add(jMenuItem3);

        jMenu6.setText("Articulos");

        jMenuItem7.setText("Articulo");
        jMenu6.add(jMenuItem7);

        jMenuItem8.setText("Categoria");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        cargarStock.add(jMenu6);

        jMenuBar1.add(cargarStock);

        jMenu3.setText("Gestión Tiendas");

        jMenuItem6.setText("Sucursales");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem9.setText("Comprobantes");
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Timbrados");
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargaVentaActionPerformed
        CargarPedidoVenta pedidoVenta = new CargarPedidoVenta();
        pedidoVenta.show();
    }//GEN-LAST:event_cargaVentaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CargarFacturaVenta facturaVenta = new CargarFacturaVenta();
        facturaVenta.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        CargarCategoria categoria = new CargarCategoria();
        categoria.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        CargaSucursal sucursales = new CargaSucursal();
        sucursales.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cargaVenta;
    private javax.swing.JMenuItem cargarCliente;
    private javax.swing.JMenuItem cargarCompra;
    private javax.swing.JMenu cargarStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
