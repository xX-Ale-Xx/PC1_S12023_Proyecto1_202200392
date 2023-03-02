/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.admin;
import com.adminClass.RegistroDep;
import com.adminClass.RegistroMuni;
import com.adminClass.departamentos;
import com.adminClass.municipios;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Carol
 */
public class DepartamentosPanel extends javax.swing.JPanel {
    RegistroDep NewDep = new RegistroDep();
    RegistroMuni NewMuni = new RegistroMuni();
    
    private String CodDepa;
    private String Region;
    private String nomDepa;
    
    
    
    private String CodDepartamento;
    private String CodMuni;
    private String nomMuni;
    
    

    /**
     * Creates new form Kioscos
     */
    public DepartamentosPanel() {
        initComponents();
        llegarOpcionCategoria();
        llenarTabla();
        llenarTablaMuni();
        MuniBtn.setForeground(Color.WHITE);
        DepBtn.setForeground(Color.WHITE);
    }
    
    public void setListas(RegistroDep usuarios){
        this.NewDep = usuarios;
        llegarOpcionCategoria();
    }
     public void setListas2(RegistroMuni usuarios){
        this.NewMuni = usuarios;
    }
    
    public void registrar(){
        setListas(NewDep);
        int result=0;
        result= this.NewDep.ReDep(CodDepa,Region ,nomDepa );
        switch (result) {
            case 1:
                mensaje("Departamento Registrado");                
                break;
            case 2:
                mensaje("El departamento con el codigo: "+CodDepa+" ya existe");
                break;
            
        }
    }
private void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }



 private boolean camposLlenos() {
        String msj = "";

        this.CodDepa = this.CodRegionAgregar.getText();
        this.Region = this.RegionAgregar.getSelectedItem().toString();
        this.nomDepa = this.NomRegionAgregar.getText();
       

        if (CodDepa.isEmpty())msj += "Codigo obligatorio\n";
        
        if (Region.isEmpty())msj += "Region obligatoria\n";
        
        if (nomDepa.isEmpty())msj += "Nombre obligatorio\n";
        
        if (!msj.equals("")) {
            mensaje(msj);
            return false;
        }
        return true;
    }
 
  private boolean camposLlenosMuni() {
        String msj = "";

        this.CodDepartamento = this.listaDepartamentos.getSelectedItem().toString();
        this.CodMuni = this.CodMunicipioAgregar.getText();
        this.nomMuni = this.NomMunicipioAgregar.getText();
       

        if (CodDepartamento.isEmpty())msj += "Codigo del Departamento obligatorio\n";
        
        if (CodMuni.isEmpty())msj += "Codigo del Municipio obligatoria\n";
        
        if (nomMuni.isEmpty())msj += "Nombre obligatorio\n";
        
        if (!msj.equals("")) {
            mensaje(msj);
            return false;
        }
        return true;
    }
 
  
  
   public void registrarMuni(){
        setListas2(NewMuni);
        int result=0;
        result= this.NewMuni.ReMuni(CodDepartamento,CodMuni ,nomMuni );
        switch (result) {
            case 1:
                mensaje("Departamento Registrado");                
                break;
            case 2:
                mensaje("El Municipio con el codigo: "+CodMuni+" ya existe");
                break;
            
        }
    }

  
  
  

  private void llegarOpcionCategoria(){
        this.listaDepartamentos.removeAllItems();
        int cantidad = this.NewDep.cantidad();
        for (int i = 0; i < cantidad; i++) {
            this.listaDepartamentos.addItem(this.NewDep.getCategoria(i).getCodigoDep());
        }
    }
  
  DefaultTableModel modelo;
   private void llenarTabla(){
        this.TablaDep.removeAll();
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Region");
        modelo.addColumn("Departamento");
        
       
                
        int cantidad = this.NewDep.cantidad();
        departamentos tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.NewDep.getDepartamento(i);
            addRowTable(tmp.getCodigoDep(), tmp.getRegionDep(), tmp.getNombreDep());
        }
        
        this.TablaDep.setModel(modelo);
       
    }
    
    private void addRowTable(String depa, String codigo, String porcentaje){
        modelo.addRow(new Object[]{depa, codigo, porcentaje});
        this.TablaDep.setModel(modelo);
    }
    
    
    //Tabla Muni
    private void llenarTablaMuni(){
        this.TablaMuni.removeAll();
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Cod Dep");
        modelo.addColumn("Cod Muni");
        modelo.addColumn("Municipio");
        
       
                
        int cantidad = this.NewMuni.cantidad();
        municipios tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.NewMuni.getMunicipio(i);
            addRowTable2(tmp.getCodigoDep(), tmp.getCodigoReg(), tmp.getNombre());
        }
        
        this.TablaMuni.setModel(modelo);
       
    }
    
    private void addRowTable2(String depa, String codigo, String porcentaje){
        modelo.addRow(new Object[]{depa, codigo, porcentaje});
        this.TablaMuni.setModel(modelo);
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
        AgregarPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CodRegionAgregar = new javax.swing.JTextField();
        NomRegionAgregar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CodMunicipioAgregar = new javax.swing.JTextField();
        NomMunicipioAgregar = new javax.swing.JTextField();
        MuniBtn = new javax.swing.JButton();
        DepBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        listaDepartamentos = new javax.swing.JComboBox<>();
        RegionAgregar = new javax.swing.JComboBox<>();
        verPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDep = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaMuni = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        AgregarPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Agregar Departamento");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Agregar Municipio");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Agregar");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Codigo de region:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Region:");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nombre:");

        CodRegionAgregar.setBackground(new java.awt.Color(255, 255, 255));
        CodRegionAgregar.setForeground(new java.awt.Color(0, 0, 0));

        NomRegionAgregar.setBackground(new java.awt.Color(255, 255, 255));
        NomRegionAgregar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Codigo del departamento:");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nombre del municipio:");

        CodMunicipioAgregar.setBackground(new java.awt.Color(255, 255, 255));
        CodMunicipioAgregar.setForeground(new java.awt.Color(0, 0, 0));
        CodMunicipioAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodMunicipioAgregarActionPerformed(evt);
            }
        });

        NomMunicipioAgregar.setBackground(new java.awt.Color(255, 255, 255));
        NomMunicipioAgregar.setForeground(new java.awt.Color(0, 0, 0));
        NomMunicipioAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomMunicipioAgregarActionPerformed(evt);
            }
        });

        MuniBtn.setBackground(new java.awt.Color(0, 0, 204));
        MuniBtn.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        MuniBtn.setText("Agregar");
        MuniBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MuniBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MuniBtnActionPerformed(evt);
            }
        });

        DepBtn.setBackground(new java.awt.Color(0, 0, 204));
        DepBtn.setText("Agregar");
        DepBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DepBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepBtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Codigo de region:");

        listaDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaDepartamentosActionPerformed(evt);
            }
        });

        RegionAgregar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "NT", "NO", "SO", "SOC", "NOC" }));

        javax.swing.GroupLayout AgregarPanelLayout = new javax.swing.GroupLayout(AgregarPanel);
        AgregarPanel.setLayout(AgregarPanelLayout);
        AgregarPanelLayout.setHorizontalGroup(
            AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarPanelLayout.createSequentialGroup()
                .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregarPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(AgregarPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(listaDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AgregarPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CodMunicipioAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AgregarPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NomMunicipioAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(AgregarPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(AgregarPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CodRegionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AgregarPanelLayout.createSequentialGroup()
                                .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomRegionAgregar)
                                    .addGroup(AgregarPanelLayout.createSequentialGroup()
                                        .addComponent(RegionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DepBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AgregarPanelLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(MuniBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgregarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(148, 148, 148))
        );
        AgregarPanelLayout.setVerticalGroup(
            AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(CodRegionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregarPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(RegionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(NomRegionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgregarPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DepBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(listaDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(CodMunicipioAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(NomMunicipioAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MuniBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        verPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Departamentos");

        TablaDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Region", "Departamento"
            }
        ));
        jScrollPane1.setViewportView(TablaDep);

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ver Datos");

        TablaMuni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Region", "Departamento"
            }
        ));
        jScrollPane2.setViewportView(TablaMuni);

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Municipios");

        javax.swing.GroupLayout verPanelLayout = new javax.swing.GroupLayout(verPanel);
        verPanel.setLayout(verPanelLayout);
        verPanelLayout.setHorizontalGroup(
            verPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(verPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(verPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(verPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        verPanelLayout.setVerticalGroup(
            verPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(verPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(verPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(verPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(verPanelLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel11)
                    .addContainerGap(446, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(AgregarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AgregarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(verPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void CodMunicipioAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodMunicipioAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodMunicipioAgregarActionPerformed

    private void NomMunicipioAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomMunicipioAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomMunicipioAgregarActionPerformed

    private void DepBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepBtnActionPerformed
        
        if(camposLlenos()){
            registrar();
             llegarOpcionCategoria();
             llenarTabla();
        }
        
    }//GEN-LAST:event_DepBtnActionPerformed

    private void listaDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaDepartamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaDepartamentosActionPerformed

    private void MuniBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuniBtnActionPerformed
        // TODO add your handling code here:
          if(camposLlenosMuni()){
            registrarMuni();
            llenarTablaMuni();

        }
    }//GEN-LAST:event_MuniBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AgregarPanel;
    private javax.swing.JTextField CodMunicipioAgregar;
    private javax.swing.JTextField CodRegionAgregar;
    private javax.swing.JButton DepBtn;
    private javax.swing.JButton MuniBtn;
    private javax.swing.JTextField NomMunicipioAgregar;
    private javax.swing.JTextField NomRegionAgregar;
    private javax.swing.JComboBox<String> RegionAgregar;
    private javax.swing.JTable TablaDep;
    private javax.swing.JTable TablaMuni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> listaDepartamentos;
    private javax.swing.JPanel verPanel;
    // End of variables declaration//GEN-END:variables
}
