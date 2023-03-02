/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.user;


import com.adminClass.departamentos;
import com.adminClass.kioscos;
import com.adminClass.municipios;
import com.adminClass.precios;
import com.login.Listas;
import com.registro.Usuarios;
import com.userClass.CodigoDeBarras;
import com.userClass.DatosFacturacion;
import com.userClass.CotizacionHTML;
import com.userClass.FacturaHtml;
import com.userClass.cotizacion;
import com.userClass.tarjetasCredito;
import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Carol
 */
public class CotizacionPanel extends javax.swing.JPanel {
     String letras = new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_123456789");

    Listas newListas;
    private String correo;
    private String contraseña;
    private String DepOrigen;
    private String DepDestino;
    private String MuniOrigen;
    private String MuniDestino;
    private String DirOrigen;
    private String DirDestino;
    private int numPaquetes;
    private String tamaño;
    private double total;
    private double valorTamaño;
    private double precioRegion;
    private String tipoDePago;
    private String efectivoOtarjeta;
    private String nombre;
    private String CodigoFactura;
 
    private String NIT;
    private String CVV; 
    /**
     * Creates new form Kioscos
     */
    public CotizacionPanel() {
        initComponents();
        this.DescargarGuiaBtn.setForeground(Color.WHITE);
        this.ComprarBtn.setForeground(Color.WHITE);
        
    }

    public void setListas(Listas newListas) {
        this.newListas = newListas;


    }

    public void setUsuarios(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
         llenarDireccionOrigen();
         evaluar();
         GenerarCodigo();
         System.out.println(CodigoFactura);
 

    }
    private void evaluar(){
                 if(BuscarSiExisteKiosco()){

             BuscarKiosco();
              LLenarSeleccion();
          DepOrigenLista.setEnabled(false);
       LLenarSeleccion2();
             llenarDatosFacturacion();
      llenarTarjetas();
         }else{
             
          llegarOpcionCategoria();
        LLenarSeleccion();
       LLenarSeleccion2();
             llenarDatosFacturacion();
      llenarTarjetas();
         }
    }

    private void llegarOpcionCategoria() {
        this.DepOrigenLista.removeAllItems();
        this.DepDestinoLista.removeAllItems();
        int cantidad = this.newListas.getNewDep().cantidad();
        for (int i = 0; i < cantidad; i++) {
            this.DepOrigenLista.addItem(this.newListas.getNewDep().getCategoria(i).getNombreDep());
            this.DepDestinoLista.addItem(this.newListas.getNewDep().getCategoria(i).getNombreDep());
        }

    }

    private void LLenarSeleccion() {
            try {
            departamentos Depa = newListas.getNewDep().buscarDepa(this.DepOrigenLista.getSelectedItem().toString());
            String codDepa = Depa.getCodigoDep();

            this.MuniOrigenLista.removeAllItems();

            int cantidad = this.newListas.getNewMuni().cantidad();
            municipios tmp;

            for (int i = 0; i < cantidad; i++) {
                tmp = this.newListas.getNewMuni().getMunicipio(i);
                if (tmp.getCodigoDep().equals(codDepa)) {
                    this.MuniOrigenLista.addItem(tmp.getNombre());
                }
            }
        } catch (Exception e) {
        }
            
      
    }
    
    
    private void LLenarSeleccion2() {
            try {
            departamentos Depa = newListas.getNewDep().buscarDepa(this.DepDestinoLista.getSelectedItem().toString());
            String codDepa = Depa.getCodigoDep();

            this.MuniDestinoLista.removeAllItems();

            int cantidad = this.newListas.getNewMuni().cantidad();
            municipios tmp;

            for (int i = 0; i < cantidad; i++) {
                tmp = this.newListas.getNewMuni().getMunicipio(i);
                if (tmp.getCodigoDep().equals(codDepa)) {
                    this.MuniDestinoLista.addItem(tmp.getNombre());
                }
            }
        } catch (Exception e) {
        }
            
      
    }
    
        private void llenarDireccionOrigen() {
        this.DirecOrigenLista.removeAllItems();
        
        int cantidad = this.newListas.getNewDatosFac().cantidad();
            DatosFacturacion tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.newListas.getNewDatosFac().getDatosFac(i);
            if(tmp.getCorreo().equals(correo)){

            this.DirecOrigenLista.addItem(this.newListas.getNewDatosFac().getDatosFac(i).getDireccion());
            }
        }

    }
        
        private void RealizarOperacion(){
    this.DepOrigen = DepOrigenLista.getSelectedItem().toString();
    this.DepDestino = DepDestinoLista.getSelectedItem().toString();
    this.MuniOrigen = MuniOrigenLista.getSelectedItem().toString();
    this.MuniDestino = MuniDestinoLista.getSelectedItem().toString();
    this.DirOrigen = DirecOrigenLista.getSelectedItem().toString();
    this.DirDestino = DireccionDestinoTxt.getText();
    this.numPaquetes = Integer.parseInt(CantidadPaquetesTxt.getText());
    
    
    EvaluarSeleccionPaquetes();
    BuscarValoresDeRegion();
    buscarDatosFacturacion();
    if(SeleccionPagos()){
    
    this.CVV = "";
    this.total = (numPaquetes*valorTamaño*precioRegion)+5;
    this.TotalTxt.setText(String.valueOf(total));
    }else{
        this.CVV = CvvTxt.getText();
    this.total = numPaquetes*valorTamaño*precioRegion;
    this.TotalTxt.setText(String.valueOf(total));
    }
}
        
        private void EvaluarSeleccionPaquetes(){
            if(Pequeño.isSelected()){
                this.tamaño = "Paquetes pequeños";
                this.valorTamaño = 15.0;
            }else if(Mediano.isSelected()){
                this.tamaño = "Paquetes medianos";
                this.valorTamaño = 25.0;
            }else if(Grande.isSelected()){
            
            this.tamaño = "Paquetes grandes";
            this.valorTamaño = 35.0;
                
            }
        }
        

        private void BuscarValoresDeRegion(){
        departamentos Depa = newListas.getNewDep().buscarDepa(this.DepDestinoLista.getSelectedItem().toString());
        this.numPaquetes = Integer.parseInt(CantidadPaquetesTxt.getText());
        
        precios region = newListas.getNewPrecios().buscarPrecio(Depa.getRegionDep());
        
        if(RadioEstandar.isSelected()){
            this.precioRegion = region.getEstandar();
        }else if(RadioEspecial.isSelected()){
            this.precioRegion = region.getEspecial();
        }
        
        }
        
        public void Guardar(){
            RealizarOperacion();
            comprobar();

        int result=0;
        result= this.newListas.getNewCotizacion().GuaCotizacion(CodigoFactura,correo, DepOrigen, DepDestino, MuniOrigen, MuniDestino
        ,DirOrigen, DirDestino,numPaquetes, tamaño, total, tipoDePago, efectivoOtarjeta, nombre, NIT, CVV);
        switch (result) {
            case 1:
               mensaje("Factura guardada en archivos");                
                break;
            
        }
    }
        
        private boolean camposLlenos() {
        String msj = "";

       

        if (numPaquetes == 0 || String.valueOf(numPaquetes).isEmpty())msj += "La cantidad no puede ser 0 \n";
        
        if (DirDestino.isEmpty())msj += "Direccion de destino obligatoria\n";
        
        if (DirecOrigenLista.getSelectedItem().toString().isEmpty())msj += "Direccion de origen obligatorio\n";
        
        if (!msj.equals("")) {
            mensaje(msj);
            return false;
        }
        return true;
    }
        
        private boolean BuscarSiExisteKiosco(){
        Usuarios usuario =  newListas.getNewRegis().buscarUsuario2(correo, contraseña);
       if(usuario!= null && usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)){
        String kiosco;
        kiosco = usuario.getKiosco();
        if(!kiosco.equals("Sin kiosco")){
            
            return true;
        }
       }
       return false;
        }
        
        private void BuscarKiosco(){
            
                
             Usuarios usuario =  newListas.getNewRegis().buscarUsuario2(correo, contraseña);
             String kiosco;
             kiosco = usuario.getKiosco();
             kioscos colocarK = newListas.getNewKioscos().buscarKiosco(kiosco);
             if(colocarK != null){
             departamentos Depa = newListas.getNewDep().buscarDepa2(colocarK.getCodRegion());
             
            this.DepOrigenLista.removeAllItems();
            

            this.DepOrigenLista.addItem(Depa.getNombreDep());
            System.out.println(""+Depa.getNombreDep());
            DepOrigenLista.setEnabled(false);
             }
      
             
        }
          private void llenarDatosFacturacion() {
        this.DatosLista.removeAllItems();
        
        int cantidad = this.newListas.getNewDatosFac().cantidad();
            DatosFacturacion tmp;
        for (int i = 0; i < cantidad; i++) {
            tmp = this.newListas.getNewDatosFac().getDatosFac(i);
            if(tmp.getCorreo().equals(correo)){

            this.DatosLista.addItem(this.newListas.getNewDatosFac().getDatosFac(i).getNombre());
            }
        }

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
      private boolean SeleccionPagos(){
          
          if(ContraEntregaBtn.isSelected()){
              this.tipoDePago = ContraEntregaBtn.getLabel();
              this.efectivoOtarjeta = "+5 de recargo";
              return true;
          }else if(tarjetaBtn.isSelected()){
              this.tipoDePago = tarjetaBtn.getLabel();
              tarjetasCredito tarjeta = newListas.getNewTarjetas().buscarTarjeta(correo, TarjetasLista.getSelectedItem().toString());
              this.efectivoOtarjeta = tarjeta.getNumeroTarjeta();
              return  false;
            
          }
          return false;
      }
      
      private void buscarDatosFacturacion(){
          DatosFacturacion datos = newListas.getNewDatosFac().buscarDatos(correo, DatosLista.getSelectedItem().toString());
          this.nombre = datos.getNombre();
          this.NIT = datos.getNIT();
      }
      private void GenerarCodigo(){
          Random numLetra = new Random();
          
          String res="";
          for (int i = 0; i < 4; i++) {
          byte posLetra = (byte)numLetra.nextInt(letras.length()-1);
          res = res + letras.charAt(posLetra);
          
          }
          
          this.CodigoFactura="IPC1D"+res;
      }
      private void comprobar(){
          GenerarCodigo();
          int b = newListas.getNewCotizacion().cantidad();
       
          for (int i = 0; i < b; i++) {
              int buscar = newListas.getNewCotizacion().existeUsuario(this.CodigoFactura);
              if(buscar!=-1){
                  GenerarCodigo();
              }else if(buscar==-1){
                  break;
              }
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

        GupoPesos = new javax.swing.ButtonGroup();
        DatosGrupo = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        DepOrigenLista = new javax.swing.JComboBox<>();
        MuniOrigenLista = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DirecOrigenLista = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DepDestinoLista = new javax.swing.JComboBox<>();
        MuniDestinoLista = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        CantidadPaquetesTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Grande = new javax.swing.JRadioButton();
        Mediano = new javax.swing.JRadioButton();
        Pequeño = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CotizarBtn = new javax.swing.JButton();
        ComprarBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        TotalTxt = new javax.swing.JTextField();
        DireccionDestinoTxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        tarjetaBtn = new javax.swing.JRadioButton();
        ContraEntregaBtn = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        tarjetasLabel = new javax.swing.JLabel();
        TarjetasLista = new javax.swing.JComboBox<>();
        DatosLista = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        CvvTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        RadioEstandar = new javax.swing.JRadioButton();
        RadioEspecial = new javax.swing.JRadioButton();
        DescargarGuiaBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cotización de paquetes");

        DepOrigenLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DepOrigenLista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DepOrigenListaItemStateChanged(evt);
            }
        });
        DepOrigenLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DepOrigenListaMouseClicked(evt);
            }
        });
        DepOrigenLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepOrigenListaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Departamento:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Municipio:");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Origen");

        DirecOrigenLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DirecOrigenLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirecOrigenListaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Direccion:");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Destino");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Departamento:");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Municipio:");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Direccion:");

        DepDestinoLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DepDestinoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepDestinoListaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Numero de paquetes a enviar:");

        CantidadPaquetesTxt.setBackground(new java.awt.Color(255, 255, 255));
        CantidadPaquetesTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        CantidadPaquetesTxt.setForeground(new java.awt.Color(0, 0, 0));
        CantidadPaquetesTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadPaquetesTxtActionPerformed(evt);
            }
        });
        CantidadPaquetesTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantidadPaquetesTxtKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GupoPesos.add(Grande);
        Grande.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Grande.setForeground(new java.awt.Color(0, 0, 0));
        Grande.setText("51 lb en adelante");

        GupoPesos.add(Mediano);
        Mediano.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Mediano.setForeground(new java.awt.Color(0, 0, 0));
        Mediano.setText("11-50 lb");
        Mediano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedianoActionPerformed(evt);
            }
        });

        GupoPesos.add(Pequeño);
        Pequeño.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Pequeño.setForeground(new java.awt.Color(0, 0, 0));
        Pequeño.setSelected(true);
        Pequeño.setText("1-10 lb");
        Pequeño.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PequeñoMouseClicked(evt);
            }
        });
        Pequeño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PequeñoActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/pequeño.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/mediano.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/grande.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Pesos:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(Pequeño)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Mediano)
                        .addGap(35, 35, 35)))
                .addComponent(Grande)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Grande)
                            .addComponent(Mediano)
                            .addComponent(Pequeño))))
                .addGap(16, 16, 16))
        );

        CotizarBtn.setBackground(new java.awt.Color(0, 0, 204));
        CotizarBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        CotizarBtn.setText("Cotizar");
        CotizarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CotizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CotizarBtnActionPerformed(evt);
            }
        });

        ComprarBtn.setBackground(new java.awt.Color(51, 51, 255));
        ComprarBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ComprarBtn.setText("Realizar compra");
        ComprarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ComprarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarBtnActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Total:");

        TotalTxt.setBackground(new java.awt.Color(255, 255, 255));
        TotalTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        TotalTxt.setForeground(new java.awt.Color(0, 0, 0));
        TotalTxt.setEnabled(false);
        TotalTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalTxtActionPerformed(evt);
            }
        });
        TotalTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TotalTxtKeyTyped(evt);
            }
        });

        DireccionDestinoTxt.setBackground(new java.awt.Color(255, 255, 255));
        DireccionDestinoTxt.setForeground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DatosGrupo.add(tarjetaBtn);
        tarjetaBtn.setForeground(new java.awt.Color(0, 0, 0));
        tarjetaBtn.setText("Tarjeta");
        tarjetaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaBtnActionPerformed(evt);
            }
        });

        DatosGrupo.add(ContraEntregaBtn);
        ContraEntregaBtn.setForeground(new java.awt.Color(0, 0, 0));
        ContraEntregaBtn.setSelected(true);
        ContraEntregaBtn.setText("Pago contra entrega");
        ContraEntregaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraEntregaBtnActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Tipo de pago:");

        tarjetasLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tarjetasLabel.setForeground(new java.awt.Color(0, 0, 0));
        tarjetasLabel.setText("Seleccione una tarjeta:");
        tarjetasLabel.setEnabled(false);

        TarjetasLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TarjetasLista.setEnabled(false);
        TarjetasLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TarjetasListaActionPerformed(evt);
            }
        });

        DatosLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Seleccione los datos de Facturacion:");

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("CVV:");

        CvvTxt.setBackground(new java.awt.Color(255, 255, 255));
        CvvTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        CvvTxt.setForeground(new java.awt.Color(0, 0, 0));
        CvvTxt.setEnabled(false);
        CvvTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CvvTxtActionPerformed(evt);
            }
        });
        CvvTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CvvTxtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DatosLista, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ContraEntregaBtn)
                                    .addComponent(tarjetaBtn)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CvvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tarjetasLabel)
                                .addGap(18, 18, 18)
                                .addComponent(TarjetasLista, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TarjetasLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tarjetasLabel))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel16))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(CvvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ContraEntregaBtn)
                        .addGap(29, 29, 29)
                        .addComponent(tarjetaBtn)))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DatosLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Datos:");

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Seleccione el pago:");

        buttonGroup1.add(RadioEstandar);
        RadioEstandar.setForeground(new java.awt.Color(0, 0, 0));
        RadioEstandar.setSelected(true);
        RadioEstandar.setText("Estandar");

        buttonGroup1.add(RadioEspecial);
        RadioEspecial.setForeground(new java.awt.Color(0, 0, 0));
        RadioEspecial.setText("Especial");

        DescargarGuiaBtn.setBackground(new java.awt.Color(0, 0, 0));
        DescargarGuiaBtn.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        DescargarGuiaBtn.setText("Descargar Guia");
        DescargarGuiaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DescargarGuiaBtn.setEnabled(false);
        DescargarGuiaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescargarGuiaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(CantidadPaquetesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DepOrigenLista, 0, 157, Short.MAX_VALUE)
                                            .addComponent(MuniOrigenLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(DirecOrigenLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(RadioEstandar)
                                        .addGap(28, 28, 28)
                                        .addComponent(RadioEspecial)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel9))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(DireccionDestinoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(MuniDestinoLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(35, 35, 35))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(DepDestinoLista, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(262, 262, 262)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CotizarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(DescargarGuiaBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ComprarBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepOrigenLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(DepDestinoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MuniOrigenLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(MuniDestinoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DirecOrigenLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(DireccionDestinoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(CantidadPaquetesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel20)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RadioEstandar)
                            .addComponent(RadioEspecial))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CotizarBtn)
                            .addComponent(jLabel15)
                            .addComponent(TotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(ComprarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DescargarGuiaBtn)))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MedianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedianoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedianoActionPerformed

    private void PequeñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PequeñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PequeñoActionPerformed

    private void CantidadPaquetesTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadPaquetesTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadPaquetesTxtActionPerformed

    private void CantidadPaquetesTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadPaquetesTxtKeyTyped
        // TODO add your handling code here:

        char C = evt.getKeyChar();

        if (Character.isLetter(C)) {

            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            CantidadPaquetesTxt.setCursor(null);

        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47 || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96 || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {

            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            CantidadPaquetesTxt.setCursor(null);

        }


    }//GEN-LAST:event_CantidadPaquetesTxtKeyTyped

    private void TotalTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalTxtActionPerformed

    private void TotalTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TotalTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalTxtKeyTyped

    private void PequeñoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PequeñoMouseClicked
        // TODO add your handling code here:

        System.out.println("" + Pequeño.getLabel());

    }//GEN-LAST:event_PequeñoMouseClicked

    private void DepOrigenListaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DepOrigenListaItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_DepOrigenListaItemStateChanged

    private void DepOrigenListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepOrigenListaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_DepOrigenListaMouseClicked

    private void DepOrigenListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepOrigenListaActionPerformed
        // TODO add your handling code here:
        LLenarSeleccion();
    }//GEN-LAST:event_DepOrigenListaActionPerformed

    private void DirecOrigenListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirecOrigenListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DirecOrigenListaActionPerformed

    private void DepDestinoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepDestinoListaActionPerformed
        // TODO add your handling code here:
        LLenarSeleccion2();
    }//GEN-LAST:event_DepDestinoListaActionPerformed

    private void CotizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CotizarBtnActionPerformed
        // TODO add your handling code here:
        
        try {
            
            
        RealizarOperacion();   
         CotizacionHTML reporte = new CotizacionHTML();
        reporte.CrearDoc(nombre, correo, contraseña, DepOrigen, DepDestino, MuniOrigen, MuniDestino, DirOrigen, DirDestino, numPaquetes, tamaño, total);
            mensaje("Se descargo la cotizacion en los archivos de la computadora");
        } catch (Exception e) {
            mensaje("Faltan Datos");
        }
        
    }//GEN-LAST:event_CotizarBtnActionPerformed

    private void ComprarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarBtnActionPerformed
        // TODO add your handling code here:
        try {
            if(camposLlenos()){
            Guardar();
                System.out.println(correo+""+ DepOrigen+""+ DepDestino+ MuniOrigen+ MuniDestino +DirOrigen+ DirDestino+numPaquetes+ tamaño+ total+ tipoDePago+ efectivoOtarjeta+ nombre+NIT+ CVV);
                FacturaHtml fac= new FacturaHtml();
                fac.CrearDoc(nombre+"Factura", CodigoFactura, correo, newListas);
                this.DescargarGuiaBtn.setEnabled(true);
            }
        } catch (Exception e) {
            mensaje("Faltan Datos");
        }
    }//GEN-LAST:event_ComprarBtnActionPerformed

    private void tarjetaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaBtnActionPerformed
        // TODO add your handling code here:
        TarjetasLista.setEnabled(true);
        tarjetasLabel.setEnabled(true);
        CvvTxt.setEnabled(true);
    }//GEN-LAST:event_tarjetaBtnActionPerformed

    private void ContraEntregaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraEntregaBtnActionPerformed
        // TODO add your handling code here:
        TarjetasLista.setEnabled(false);
        tarjetasLabel.setEnabled(false);
        CvvTxt.setEnabled(false);
    }//GEN-LAST:event_ContraEntregaBtnActionPerformed

    private void CvvTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CvvTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CvvTxtActionPerformed

    private void CvvTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CvvTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CvvTxtKeyTyped

    private void DescargarGuiaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescargarGuiaBtnActionPerformed
        // TODO add your handling code here:
        
        try {
            CodigoDeBarras guia = new CodigoDeBarras();
            guia.GenerarCodigo(nombre,CodigoFactura, correo, newListas);
            mensaje("La guia se guardo en los archivos");
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_DescargarGuiaBtnActionPerformed

    private void TarjetasListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TarjetasListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TarjetasListaActionPerformed
    private void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CantidadPaquetesTxt;
    private javax.swing.JButton ComprarBtn;
    private javax.swing.JRadioButton ContraEntregaBtn;
    private javax.swing.JButton CotizarBtn;
    private javax.swing.JTextField CvvTxt;
    public static javax.swing.ButtonGroup DatosGrupo;
    private javax.swing.JComboBox<String> DatosLista;
    private javax.swing.JComboBox<String> DepDestinoLista;
    private javax.swing.JComboBox<String> DepOrigenLista;
    private javax.swing.JButton DescargarGuiaBtn;
    private javax.swing.JComboBox<String> DirecOrigenLista;
    private javax.swing.JTextField DireccionDestinoTxt;
    private javax.swing.JRadioButton Grande;
    public static javax.swing.ButtonGroup GupoPesos;
    private javax.swing.JRadioButton Mediano;
    private javax.swing.JComboBox<String> MuniDestinoLista;
    private javax.swing.JComboBox<String> MuniOrigenLista;
    private javax.swing.JRadioButton Pequeño;
    private javax.swing.JRadioButton RadioEspecial;
    private javax.swing.JRadioButton RadioEstandar;
    private javax.swing.JComboBox<String> TarjetasLista;
    private javax.swing.JTextField TotalTxt;
    public static javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton tarjetaBtn;
    private javax.swing.JLabel tarjetasLabel;
    // End of variables declaration//GEN-END:variables
}
