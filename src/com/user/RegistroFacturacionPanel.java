/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.user;

import com.login.Listas;
import com.registro.Usuarios;
import com.userClass.DatosFacturacion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Carol
 */
public class RegistroFacturacionPanel extends javax.swing.JPanel {
    Listas newListas;
    private String correo;
    private String contraseña;
    private String nombre;
    private String direccion;
    private String NIT;
    /**
     * Creates new form Kioscos
     */
    public RegistroFacturacionPanel() {
        initComponents();
    }
     public void setListas(Listas newListas){
        this.newListas=newListas;
    }
     public void setUsuarios(String correo, String contraseña){
      this.correo = correo;
      this.contraseña = contraseña;
       llenarTabla();
       colocar();
     
    }
     DefaultTableModel modelo;

    private void llenarTabla() {
        this.TablaDatos.removeAll();
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Nit");

        int cantidad = this.newListas.getNewDatosFac().cantidad();
        DatosFacturacion tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.newListas.getNewDatosFac().getDatosFac(i);
            if (tmp.getCorreo().equals(correo)) {

                addRowTable(tmp.getNombre(), tmp.getDireccion(), tmp.getNIT());
            }
        }

        this.TablaDatos.setModel(modelo);

    }

    private void addRowTable(String codK, String nomK, String codR) {
        modelo.addRow(new Object[]{codK, nomK, codR});
        this.TablaDatos.setModel(modelo);
    }
     public void registrar() {
        

        this.nombre = this.NombreTxt.getText();
        this.direccion = this.DireccionTxt.getText();
        this.NIT = this.NitTxt.getText();

        int result = 0;
        result = this.newListas.getNewDatosFac().ReDatosFac(correo, nombre, direccion, NIT);
        switch (result) {
            case 1:
                mensaje("Datos Registrados");
                break;
            case 2:
                mensaje("La tarjeta con el numero: " + direccion + " ya existe");
                break;

        }

    }
     
     private boolean camposLlenos() {
        String msj = "";

        this.nombre = this.NombreTxt.getText();
        this.direccion = this.DireccionTxt.getText();
        this.NIT = this.NitTxt.getText();

        if (this.NombreTxt.getText().isEmpty()) {
            msj += "Nombre obligatorio\n";
        }

        if (this.DireccionTxt.getText().isEmpty()) {
            msj += "Direccion obligatoria\n";
        }
        if (this.NitTxt.getText().isEmpty()) {
            msj += "NIT obligatorio\n";
        }


        if (!msj.equals("")) {
            mensaje(msj);
            return false;
        }
        return true;
    }
    

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
     private void colocar(){
        Usuarios usuario =  newListas.getNewRegis().buscarUsuario2(correo, contraseña);
       if(usuario!= null){
        NombreTxt.setText(usuario.getNombre()+" "+usuario.getApellido());
       }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NombreTxt = new javax.swing.JTextField();
        DireccionTxt = new javax.swing.JTextField();
        NitTxt = new javax.swing.JTextField();
        GuardarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registro de datos de Facturacion");

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre completo:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Direccion:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NIT:");

        NombreTxt.setBackground(new java.awt.Color(255, 255, 255));
        NombreTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        DireccionTxt.setBackground(new java.awt.Color(255, 255, 255));
        DireccionTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        NitTxt.setBackground(new java.awt.Color(255, 255, 255));
        NitTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        GuardarBtn.setBackground(new java.awt.Color(0, 0, 204));
        GuardarBtn.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        GuardarBtn.setForeground(new java.awt.Color(255, 255, 255));
        GuardarBtn.setText("Guardar");
        GuardarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GuardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarBtnActionPerformed(evt);
            }
        });

        TablaDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaDatos);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Datos Registrados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(NombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(DireccionTxt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(GuardarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(NombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(DireccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(NitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(GuardarBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void GuardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarBtnActionPerformed
        // TODO add your handling code here:
        if (camposLlenos()) {
            registrar();
            llenarTabla();
        }
    }//GEN-LAST:event_GuardarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DireccionTxt;
    private javax.swing.JButton GuardarBtn;
    private javax.swing.JTextField NitTxt;
    private javax.swing.JTextField NombreTxt;
    private javax.swing.JTable TablaDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
