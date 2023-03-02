
package com.login;
import com.admin.inicioAdmin;
import com.adminClass.RegistroDep;
import com.adminClass.RegistroKioscos;
import com.adminClass.RegistroMuni;
import java.awt.Color;
import javax.swing.JOptionPane;
import com.registro.panelRegistro;

import  com.registro.RegistrarUsuarios;
import com.user.inicioUser;

public class login extends javax.swing.JFrame {
    Listas newListas = new Listas();
    private String usuario;
    private String contraseña;

    int xMouse, yMouse;
  
    public login() {
        initComponents();
       
    }
 public void setListas(Listas newListas){
        this.newListas = newListas;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        bg1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        registroBtn = new javax.swing.JPanel();
        registroLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("                    INICIAR SESIÓN");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 400, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/img login.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 490));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Logo_1.jpg"))); // NOI18N
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitLabel.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitLabel.setForeground(new java.awt.Color(0, 0, 0));
        exitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitLabel.setText("x");
        exitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitBtnLayout.createSequentialGroup()
                .addComponent(exitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 760, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        bg1.setBackground(new java.awt.Color(255, 255, 255));
        bg1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("                    INICIAR SESIÓN");
        bg1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 400, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/img login.jpg"))); // NOI18N
        jLabel8.setText("jLabel1");
        bg1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 490));

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setText("CORREO");
        bg1.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 70, -1));

        userTxt.setBackground(new java.awt.Color(255, 255, 255));
        userTxt.setForeground(new java.awt.Color(153, 153, 153));
        userTxt.setText("Ingrese su correo electronico");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        bg1.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 360, 30));

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(0, 0, 0));
        passLabel.setText("CONTRASEÑA");
        bg1.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 100, -1));

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordField1.setText("**********");
        jPasswordField1.setBorder(null);
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordField1MousePressed(evt);
            }
        });
        bg1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 350, 30));

        loginBtn.setBackground(new java.awt.Color(0, 51, 153));

        loginBtnTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("ENTRAR");
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg1.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 100, 30));

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("USAC-Delivery");
        bg1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 240, -1));

        registroBtn.setBackground(new java.awt.Color(153, 153, 153));
        registroBtn.setForeground(new java.awt.Color(0, 0, 0));

        registroLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        registroLabel.setForeground(new java.awt.Color(0, 0, 0));
        registroLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registroLabel.setText("Registrarse");
        registroLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registroLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registroLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registroLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registroLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registroBtnLayout = new javax.swing.GroupLayout(registroBtn);
        registroBtn.setLayout(registroBtnLayout);
        registroBtnLayout.setHorizontalGroup(
            registroBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registroLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        registroBtnLayout.setVerticalGroup(
            registroBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registroLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg1.add(registroBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 100, 30));
        bg1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 350, 10));
        bg1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 350, 10));

        bg.add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 350, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
       xMouse = evt.getX();
       yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitLabelMouseClicked

    private void exitLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseEntered
     exitBtn.setBackground(Color.red);
     exitLabel.setForeground(Color.WHITE);
    }//GEN-LAST:event_exitLabelMouseEntered

    private void exitLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseExited
       exitBtn.setBackground(Color.WHITE);
       exitLabel.setForeground(Color.BLACK);
    }//GEN-LAST:event_exitLabelMouseExited

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
      loginBtn.setBackground(new Color(0,128,255)); 
      
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(new Color(0,51,153));
    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void registroLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroLabelMouseEntered
       registroBtn.setBackground(Color.black);
       registroLabel.setForeground(Color.white);
    }//GEN-LAST:event_registroLabelMouseEntered

    private void registroLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroLabelMouseExited
        registroBtn.setBackground(new Color(153,153,153));
       registroLabel.setForeground(Color.black);
    }//GEN-LAST:event_registroLabelMouseExited

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed

        if(userTxt.getText().equals("Ingrese su correo electronico")){
            
        userTxt.setText("");
        userTxt.setForeground(Color.black);
        }
        if(String.valueOf(jPasswordField1.getPassword()).isEmpty()){
            
        jPasswordField1.setText("**********");
        jPasswordField1.setForeground(new Color(153,153,153));
        
        
        }
    }//GEN-LAST:event_userTxtMousePressed

    private void jPasswordField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MousePressed
         if(String.valueOf(jPasswordField1.getPassword()).equals("**********")){
             
             jPasswordField1.setText("");
             jPasswordField1.setForeground(Color.black);
        
         }
         if(userTxt.getText().isEmpty()){
             
             userTxt.setText("Ingrese su correo electronico");
             userTxt.setForeground(new Color(153,153,153));
        

         }
    }//GEN-LAST:event_jPasswordField1MousePressed

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
 if(camposLlenos())
        { 

            this.usuario=userTxt.getText();
            this.contraseña=String.valueOf(jPasswordField1.getPassword());
            
           if(usuario.equals("ipc1_202200392@ipc1delivery.com") && contraseña.equals("202200392")){
               
        inicioAdmin newAdmin = new inicioAdmin();
        newAdmin.setListas(newListas);

        newAdmin.setUsuarios(usuario, contraseña);
        newAdmin.setVisible(true);
        newAdmin.setLocation(50,50);
        
        this.dispose();
           }else if(newListas.newRegis.buscarUsuario(usuario, contraseña)!=-1){
               mensaje("bienvenido");
                inicioUser newUser = new inicioUser();
        
        newUser.setListas(newListas);
        newUser.setUsuarios(usuario, contraseña);

        newUser.setVisible(true);
        newUser.setLocation(50,50);
        this.dispose();
           }else{
               mensaje("Usuario/contraseña incorrectos");
           }
        }
                     
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void registroLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroLabelMouseClicked
        // TODO add your handling code here:
        panelRegistro newRegistro = new panelRegistro();
        newRegistro.setListas(newListas);
        newRegistro.setVisible(true);
        newRegistro.setLocation(50,50);

        this.dispose();
        
    }//GEN-LAST:event_registroLabelMouseClicked

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    private void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
     private boolean camposLlenos()
    {
        String msj = "";
        this.usuario = this.userTxt.getText();
        this.contraseña = String.valueOf(this.jPasswordField1.getPassword());
        
        if(usuario.equals("Ingrese su correo electronico") || usuario.isEmpty()) msj += "Usuario obligatorio\n";
        if(contraseña.equals("**********") || contraseña.isEmpty()) msj += "Contraseña obligatoria";
        if(!msj.equals("")){
            mensaje(msj);
            return false;
        }
        return true;
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bg1;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPanel registroBtn;
    private javax.swing.JLabel registroLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
