/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.admin;

import com.adminClass.precios;
import com.login.Listas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carol
 */
public class PreciosPanel extends javax.swing.JPanel {
    Listas newListas;
    private String CodRegion;
    private double Estandar;
    private double Especial;

    /**
     * Creates new form Kioscos
     */
    public PreciosPanel() {
        initComponents();
    }
    public void setListas(Listas newListas){
        this.newListas = newListas;
        llenarTabla();
    }
    
     private boolean camposLlenos() {
        String msj = "";


        String Estan = this.EstandarTxt.getText();
        String Esp = this.EspecialTxt.getText();
        int Estan2 = Integer.parseInt(this.EstandarTxt.getText());
        int Esp2 = Integer.parseInt(this.EspecialTxt.getText());
       

        if (CodRegion.isEmpty())msj += "Codigo obligatorio\n";
        
        if (Estan2 == 0 || this.EstandarTxt.getText().isEmpty() || Estan.equals(" "))msj += "El precio no puede ser 0.00\n";
        
        if (EspecialTxt.getText().isEmpty() || Esp2==0 || Esp.equals(" "))msj += "El precio no puede ser 0.00\n";
        
        if (!msj.equals("")) {
            mensaje(msj);
            return false;
        }
        return true;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPrecios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        ListaRegiones = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EstandarTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        EspecialTxt = new javax.swing.JTextField();
        actualizarBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TablaPrecios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaPrecios);

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Control de Precios");

        ListaRegiones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "NT", "NO", "SO", "SOC", "NOC" }));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Precio especial");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Actualizar precios");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Codigo de Región");

        EstandarTxt.setBackground(new java.awt.Color(255, 255, 255));
        EstandarTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        EstandarTxt.setForeground(new java.awt.Color(0, 0, 0));
        EstandarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EstandarTxtKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Precio estandar");

        EspecialTxt.setBackground(new java.awt.Color(255, 255, 255));
        EspecialTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        EspecialTxt.setForeground(new java.awt.Color(0, 0, 0));
        EspecialTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EspecialTxtKeyTyped(evt);
            }
        });

        actualizarBtn.setBackground(new java.awt.Color(0, 0, 153));
        actualizarBtn.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        actualizarBtn.setText("Actualizar");
        actualizarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        actualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Precios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ListaRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(EstandarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EspecialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(actualizarBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(555, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ListaRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EstandarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EspecialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(actualizarBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(337, Short.MAX_VALUE)))
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

    private void EstandarTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EstandarTxtKeyTyped
        // TODO add your handling code here:
        char C = evt.getKeyChar();
        
        if(Character.isLetter(C)){
            
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            EstandarTxt.setCursor(null);
            
        }else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47 || (int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                || (int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96 || (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255){
            
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            EstandarTxt.setCursor(null);
            
        }        
    }//GEN-LAST:event_EstandarTxtKeyTyped

    private void EspecialTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EspecialTxtKeyTyped
        // TODO add your handling code here:
        char C = evt.getKeyChar();
        
        if(Character.isLetter(C)){
            
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            EspecialTxt.setCursor(null);
            
        }else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47 || (int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                || (int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96 || (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255){
            
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            EspecialTxt.setCursor(null);
            
        }        
        
        
    }//GEN-LAST:event_EspecialTxtKeyTyped

    
    
     private void actualizar(){
        this.CodRegion = this.ListaRegiones.getSelectedItem().toString();
        this.Estandar = Double.valueOf(this.EstandarTxt.getText());
        this.Especial = Double.valueOf(this.EspecialTxt.getText());
        if(this.CodRegion!=null){
            CodRegion = this.ListaRegiones.getSelectedItem().toString();
            String PEstandar = this.EstandarTxt.getText();
            String PEspecial = this.EspecialTxt.getText();
            
            this.newListas.getNewPrecios().actualizar(CodRegion, Double.valueOf(PEstandar), Double.valueOf(PEspecial));
            llenarTabla();
        }
    }
    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        // TODO add your handling code here:
        try {
            if(camposLlenos()){
            actualizar();
            mensaje("Actualizado");
        }
            
        } catch (Exception e) {
            mensaje("Los campos no pueden estar vacios");
        }

    }//GEN-LAST:event_actualizarBtnActionPerformed

    DefaultTableModel modelo;
   private void llenarTabla(){
        this.TablaPrecios.removeAll();
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Codigo Region");
        modelo.addColumn("Estandar");
        modelo.addColumn("Especial");
        
       
                
        int cantidad = this.newListas.getNewPrecios().cantidad();
        precios tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.newListas.getNewPrecios().getPrecios(i);
            addRowTable(tmp.getRegion(), String.valueOf(tmp.getEstandar()), String.valueOf(tmp.getEspecial()));
        }
        
        this.TablaPrecios.setModel(modelo);
       
    }
    
    private void addRowTable(String codK, String nomK, String codR){
        modelo.addRow(new Object[]{codK, nomK, codR});
        this.TablaPrecios.setModel(modelo);
    }
    
    private void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EspecialTxt;
    private javax.swing.JTextField EstandarTxt;
    private javax.swing.JComboBox<String> ListaRegiones;
    private javax.swing.JTable TablaPrecios;
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
