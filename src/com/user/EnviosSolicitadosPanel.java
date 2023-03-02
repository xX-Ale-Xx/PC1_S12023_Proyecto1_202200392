/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.user;

import com.login.Listas;
import com.userClass.CodigoDeBarras;
import com.userClass.FacturaHtml;
import com.userClass.cotizacion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carol
 */
public class EnviosSolicitadosPanel extends javax.swing.JPanel {

    Listas newListas;
    private String correo;
    private String contraseña;

    /**
     * Creates new form Kioscos
     */
    public EnviosSolicitadosPanel() {
        initComponents();
    }

    public void setListas(Listas newListas) {
        this.newListas = newListas;
    }

    public void setUsuarios(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
        llenarFacturas();
        llenarTabla();
    }

    private void llenarFacturas() {
        this.ListaDeFactura.removeAllItems();

        int cantidad = this.newListas.getNewCotizacion().cantidad();
        cotizacion tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.newListas.getNewCotizacion().getCategoria(i);
            if (tmp.getCorreo().equals(correo)) {

                this.ListaDeFactura.addItem(this.newListas.getNewCotizacion().getCotizacion(i).getCodigoFactura());
            }
        }

    }

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    DefaultTableModel modelo;

    private void llenarTabla() {
        this.Tabla.removeAll();
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Departamento");
        modelo.addColumn("Municipio");
        modelo.addColumn("Destinatario");
        modelo.addColumn("Total");
        modelo.addColumn("Tipo de Pago");

        int cantidad = this.newListas.getNewCotizacion().cantidad();
        cotizacion tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.newListas.getNewCotizacion().getCategoria(i);
            if (tmp.getCorreo().equals(correo)) {

                addRowTable(tmp.getCodigoFactura(), tmp.getDepDestino(), tmp.getMuniDestino(), tmp.getDirDestino(), String.valueOf(tmp.getTotal()), tmp.getTipoDePago());
            }
        }

        this.Tabla.setModel(modelo);

    }

    private void addRowTable(String codF, String depDes, String MuniDes, String DirDes, String Total, String Tipo) {
        modelo.addRow(new Object[]{codF, depDes, MuniDes, DirDes, Total, Tipo});
        this.Tabla.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        GenerarFacturaBtn = new javax.swing.JButton();
        ListaDeFactura = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        GuiaBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cotización de paquetes");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        GenerarFacturaBtn.setBackground(new java.awt.Color(0, 0, 204));
        GenerarFacturaBtn.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        GenerarFacturaBtn.setForeground(new java.awt.Color(255, 255, 255));
        GenerarFacturaBtn.setText("Generar factura");
        GenerarFacturaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GenerarFacturaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarFacturaBtnActionPerformed(evt);
            }
        });

        ListaDeFactura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(" codigos de paquetes:");

        GuiaBtn.setBackground(new java.awt.Color(0, 0, 0));
        GuiaBtn.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        GuiaBtn.setText("Generar Guia");
        GuiaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GuiaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuiaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ListaDeFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GenerarFacturaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GuiaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addComponent(ListaDeFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(GenerarFacturaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GuiaBtn)
                        .addGap(84, 84, 84))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GenerarFacturaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarFacturaBtnActionPerformed
        // TODO add your handling code here:
        try {
            FacturaHtml fac = new FacturaHtml();
            fac.CrearDoc(this.ListaDeFactura.getSelectedItem().toString(), this.ListaDeFactura.getSelectedItem().toString(), correo, newListas);
            mensaje("Factura guardada en archivos");

        } catch (Exception e) {
            mensaje("Faltan Datos");

        }

    }//GEN-LAST:event_GenerarFacturaBtnActionPerformed

    private void GuiaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuiaBtnActionPerformed
        // TODO add your handling code here:
        CodigoDeBarras guia = new CodigoDeBarras();

        guia.GenerarCodigo(this.ListaDeFactura.getSelectedItem().toString(), this.ListaDeFactura.getSelectedItem().toString(), correo, newListas);

        mensaje("La guia se guardo en los archivos");
    }//GEN-LAST:event_GuiaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerarFacturaBtn;
    private javax.swing.JButton GuiaBtn;
    private javax.swing.JComboBox<String> ListaDeFactura;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
