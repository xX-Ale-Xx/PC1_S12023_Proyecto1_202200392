/*
 * Click nbfs://nbhost/Syste StringSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/Syste StringSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class RegistrarUsuarios {
     private ArrayList<Usuarios> listUsuarios;
     
     Usuarios admin = new Usuarios("ipc1_202200392@ipc1delivery.com", "202200392","Javier","Avila" ,"3017077070101","javi", "04/09/2003", 12121212, "admin", "", "Guatemalteco", "Masculino", ".\\src\\com\\img\\perfilRegistro.png" );
     Usuarios user = new Usuarios("j", "j","Javier","Avila" ,"3017077070101","javi", "04/09/2003", 12121212, "admin", "Sin kiosco", "Guatemalteco", "Masculino", ".\\src\\com\\img\\perfilRegistro.png" );
     Usuarios kiosco = new Usuarios("k", "k","Javier","Avila" ,"3017077070101","javi", "04/09/2003", 12121212, "admin", "La Terraza", "Guatemalteco", "Masculino", ".\\src\\com\\img\\perfilRegistro.png" );
     public RegistrarUsuarios(){
         this.listUsuarios = new ArrayList<>();
         listUsuarios.add(admin);
         listUsuarios.add(user);
         listUsuarios.add(kiosco);
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
      
       public Usuarios buscarUsuario2(String correo, String contraseña)
    {
        int cantidad = this.listUsuarios.size();
        Usuarios tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.listUsuarios.get(i);
            if(tmp.getCorreo().equals(correo) && tmp.getContraseña().equals(contraseña)) {
                return  tmp;
            }
        }
        return null;
    }
        public int cantidad(){
        return this.listUsuarios.size();
    }
        public Usuarios obtener(int indice){
        return this.listUsuarios.get(indice);
    }
      public void actualizar(String correo, String contraseña, String nombre, String apellido, String DPI, String alias, String fechaNac, int telefono, String rol, String kiosco, String nacionalidad, String genero, String foto)
    {
        int cantidad = cantidad();
        Usuarios tmp;
        
        for (int i = 0; i < cantidad; i++) {
            tmp = obtener(i);
            if(tmp.getCorreo().equals(correo)) {
                this.listUsuarios.get(i).setContraseña(contraseña);
                this.listUsuarios.get(i).setNombre(nombre);
                this.listUsuarios.get(i).setApellido(apellido);
                this.listUsuarios.get(i).setDpi(DPI);
                this.listUsuarios.get(i).setSobreNombre(alias);
                this.listUsuarios.get(i).setFecha(fechaNac);
                this.listUsuarios.get(i).setTelefono(telefono);
                this.listUsuarios.get(i).setRol(rol);
                this.listUsuarios.get(i).setKiosco(kiosco);
                this.listUsuarios.get(i).setNacion(nacionalidad);
                this.listUsuarios.get(i).setGeneroPersona(genero);
                this.listUsuarios.get(i).setFoto(foto);
                System.out.println("Actualizado");
            }
        }
    }
       
       private void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
       
        public void eliminar(String nombre, String contra)
    {
        Usuarios tmp;
        
        for (int i = 0; i < cantidad(); i++) {
            tmp = obtener(i);
            if(tmp.getCorreo().equals(nombre) && tmp.getContraseña().equals(contra)) {
                this.listUsuarios.remove(i);
            }
        }
    }
}
//    this.productos.get(i).setColor(color);
              //  this.productos.get(i).setFoto(foto);
               // this.productos.get(i).setPrecio(precio);