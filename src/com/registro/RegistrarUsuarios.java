/*
 * Click nbfs://nbhost/Syste StringSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/Syste StringSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro;
import com.admin.inicioAdmin;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class RegistrarUsuarios {
     private ArrayList<Usuarios> listUsuarios;
     
     Usuarios admin = new Usuarios("j", "202200392","javi","avila" ,"3017077070101","javi", "", 12, "admin", "", "", "", "" );
     
     public RegistrarUsuarios(){
         this.listUsuarios = new ArrayList<>();
     }
     
     public int ReUsuarios(String correo, String contraseña, String nombre, String apellido, String DPI, String alias, String fechaNac, int telefono, String rol, String kiosco, String nacionalidad, String genero, String foto)
    {
        int indice = existeUsuario(correo);
        if(indice!=-1) return 2;
        
        this.listUsuarios.add(new Usuarios(correo, contraseña, nombre, apellido, DPI, alias, fechaNac, telefono, rol, kiosco, nacionalidad, genero, foto));
        
        return 1;
    }
      public int existeUsuario(String correo)
    {
        int cantidad = this.listUsuarios.size();
        Usuarios tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.listUsuarios.get(i);
            if(tmp.getCorreo().equals(correo)) return i;
        }
        return -1;
    }
      
      
      public int buscarUsuario(String correo, String contraseña)
    {
        int cantidad = this.listUsuarios.size();
        Usuarios tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.listUsuarios.get(i);
            if(tmp.getCorreo().equals(correo) && tmp.getContraseña().equals(contraseña)) return i;
        }
        return -1;
    }
       
       private void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
