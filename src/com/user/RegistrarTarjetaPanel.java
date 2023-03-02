/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.user;

import com.login.Listas;
import com.userClass.tarjetasCredito;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carol
 */
public class RegistrarTarjetaPanel extends javax.swing.JPanel {

    Listas newListas;
    private String correo;
    private String contraseña;
    private String nombreTarjeta;
    private String numeroTarjeta;
    private String fechaVencimiento;
    int u = 0;

    /**
     * Creates new form Kioscos
     */
    public RegistrarTarjetaPanel() {
        initComponents();
    }

    public void setListas(Listas newListas) {
        this.newListas = newListas;
    }

    public void setUsuarios(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
        llenarTabla();
        llenarTarjetas();

    }

    private boolean camposLlenos() {
        String msj = "";

        this.nombreTarjeta = this.NombreTarjetaTxt.getText();

        if (nombreTarjeta.isEmpty()) {
            msj += "Nombre obligatorio\n";
        }

        if (this.NumeroTarjetaTxt.getText().isEmpty()) {
            msj += "Numero obligatoria\n";
        }

        if (!msj.equals("")) {
            mensaje(msj);
            return false;
        }
        return true;
    }

    public void registrar() {
        String Num = this.NumeroTarjetaTxt.getText();
        boolean pasar = false;

        if (pasar == false) {
            for (int i = 0; i < 12; i++) {
                char letraVieja;
                letraVieja = Num.charAt(i);
                Num = Num.replaceFirst(String.valueOf(letraVieja), "X");

                letraVieja++;

            }
            System.out.println(" " + Num);
            pasar = true;
        }

        this.numeroTarjeta = Num;
        this.fechaVencimiento = FechaVenceTxt.getText();

        int result = 0;
        result = this.newListas.getNewTarjetas().ReTarjeta(correo, nombreTarjeta, numeroTarjeta, fechaVencimiento);
        switch (result) {
            case 1:
                mensaje("Tarjeta Registrada");
                break;
            case 2:
                mensaje("La tarjeta con el numero: " + numeroTarjeta + " ya existe");
                break;

        }

    }
    DefaultTableModel modelo;

    private void llenarTabla() {
        this.TablaTarjetas.removeAll();
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Numero");
        modelo.addColumn("Fecha Vencimiento");

        int cantidad = this.newListas.getNewTarjetas().cantidad();
        tarjetasCredito tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.newListas.getNewTarjetas().getTarCredito(i);
            if (tmp.getCorreo().equals(correo)) {

                addRowTable(tmp.getNombreTarjeta(), tmp.getNumeroTarjeta(), tmp.getFechaVencimiento());
            }
        }

        this.TablaTarjetas.setModel(modelo);

    }

    private void addRowTable(String codK, String nomK, String codR) {
        modelo.addRow(new Object[]{codK, nomK, codR});
        this.TablaTarjetas.setModel(modelo);
    }
    
         private boolean isNumero(){
        String Num = NumeroTarjetaTxt.getText();
        if(Num.length()==16){
            return true;
        }else{
             mensaje("Ingrese un numero de tarjeta valido");
        return false;}
    }
    

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    private void llenarTarjetas() {
        this.TarjetasLista.removeAllItems();
        
        int cantidad = this.newListas.getNewTarjetas().cantidad();
            tarjetasCredito tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.newListas.getNewTarjetas().getCategoria(i);
            if(tmp.getCorreo().equals(correo)){

            this.TarjetasLista.addItem(this.newListas.getNewTarjetas().getCategoria(i).getNombreTarjeta());
            }
        }

    }
    
    private void eliminar(){
        
        if(this.TarjetasLista!=null){
            String nombre =this.TarjetasLista.getSelectedItem().toString();

            this.newListas.getNewTarjetas().eliminar(nombre);
            System.out.println("eliminar Departamento");
           llenarTarjetas();
            llenarTabla();
        }
    }
 
    private void actualizar(){
        if(this.nombreTarjeta!=null){
            nombreTarjeta = this.NombreTarjetaTxt.getText();
             String Num = this.NumeroTarjetaTxt.getText();
        boolean pasar = false;

        if (pasar == false) {
            for (int i = 0; i < 12; i++) {
                char letraVieja;
                letraVieja = Num.charAt(i);
                Num = Num.replaceFirst(String.valueOf(letraVieja), "X");

                letraVieja++;

            }
            System.out.println(" " + Num);
            pasar = true;
        }

            String numero = Num;
            String Fecha = this.FechaVenceTxt.getText();
            
            this.newListas.getNewTarjetas().actualizar(nombreTarjeta, numero, Fecha);
            llenarTabla();
            llenarTarjetas();
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
        NombreTarjetaTxt = new javax.swing.JTextField();
        NumeroTarjetaTxt = new javax.swing.JTextField();
        FechaVenceTxt = new javax.swing.JTextField();
        ColocarFechaJCalendar = new com.toedter.calendar.JCalendar();
        GuardarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTarjetas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TarjetasLista = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        ActualizarTarjetasBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Tarjetas de Credito/Debito");

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre de la tarjeta:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Número de la tarjeta:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha de vencimiento:");

        NombreTarjetaTxt.setBackground(new java.awt.Color(255, 255, 255));
        NombreTarjetaTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        NumeroTarjetaTxt.setBackground(new java.awt.Color(255, 255, 255));
        NumeroTarjetaTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        NumeroTarjetaTxt.setForeground(new java.awt.Color(0, 0, 0));
        NumeroTarjetaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NumeroTarjetaTxtKeyTyped(evt);
            }
        });

        FechaVenceTxt.setBackground(new java.awt.Color(255, 255, 255));
        FechaVenceTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        FechaVenceTxt.setEnabled(false);

        ColocarFechaJCalendar.setBackground(new java.awt.Color(255, 255, 255));
        ColocarFechaJCalendar.setForeground(new java.awt.Color(0, 0, 0));
        ColocarFechaJCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ColocarFechaJCalendarPropertyChange(evt);
            }
        });

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

        TablaTarjetas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaTarjetas);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tarjetas Registradas");

        TarjetasLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ActualizarTarjetasBtn.setBackground(new java.awt.Color(0, 51, 204));
        ActualizarTarjetasBtn.setForeground(new java.awt.Color(255, 255, 255));
        ActualizarTarjetasBtn.setText("Actualizar");
        ActualizarTarjetasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarTarjetasBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NombreTarjetaTxt)
                            .addComponent(FechaVenceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumeroTarjetaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ColocarFechaJCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(135, 135, 135))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(GuardarBtn)
                .addGap(19, 19, 19)
                .addComponent(ActualizarTarjetasBtn)
                .addGap(18, 18, 18)
                .addComponent(TarjetasLista, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addGap(99, 99, 99))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(NombreTarjetaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NumeroTarjetaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(FechaVenceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ColocarFechaJCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GuardarBtn)
                            .addComponent(TarjetasLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(ActualizarTarjetasBtn))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void ColocarFechaJCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ColocarFechaJCalendarPropertyChange
        // TODO add your handling code here:
        if (evt.getOldValue() != null) {
            SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
            FechaVenceTxt.setText(ff.format(ColocarFechaJCalendar.getCalendar().getTime()));
        }
    }//GEN-LAST:event_ColocarFechaJCalendarPropertyChange

    private void GuardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarBtnActionPerformed
        // TODO add your handling code here:
        if (camposLlenos() && isNumero()) {
            registrar();
            llenarTabla();
            llenarTarjetas();
        }
    }//GEN-LAST:event_GuardarBtnActionPerformed

    private void NumeroTarjetaTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumeroTarjetaTxtKeyTyped
        // TODO add your handling code here:
        char C = evt.getKeyChar();
        
        if(Character.isLetter(C)){
            
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            NumeroTarjetaTxt.setCursor(null);
            
        }else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47 || (int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                || (int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96 || (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255){
            
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            NumeroTarjetaTxt.setCursor(null);
            
        }        
    }//GEN-LAST:event_NumeroTarjetaTxtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ActualizarTarjetasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarTarjetasBtnActionPerformed
        // TODO add your handling code here:
         if (isNumero()) {
             actualizar();
             llenarTabla();
            llenarTarjetas();
             mensaje("Actualizado");
         }
    }//GEN-LAST:event_ActualizarTarjetasBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarTarjetasBtn;
    private com.toedter.calendar.JCalendar ColocarFechaJCalendar;
    private javax.swing.JTextField FechaVenceTxt;
    private javax.swing.JButton GuardarBtn;
    private javax.swing.JTextField NombreTarjetaTxt;
    private javax.swing.JTextField NumeroTarjetaTxt;
    private javax.swing.JTable TablaTarjetas;
    private javax.swing.JComboBox<String> TarjetasLista;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
