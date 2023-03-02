/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.userClass;

import java.util.ArrayList;

/**
 *
 * @author Carol
 */
public class RegistroTarjetasCredito {
       private ArrayList<tarjetasCredito> ListTarjetas;
    
    public RegistroTarjetasCredito(){
        this.ListTarjetas = new ArrayList<>();
     }
    
    
    public int ReTarjeta(String correo,String nombreTarjeta,String numeroTarjeta, String fechaVencimiento)
    {
        int indice = existeTarjeta(nombreTarjeta);
        if(indice!=-1) return 2;
        
        this.ListTarjetas.add(new tarjetasCredito(correo, nombreTarjeta, numeroTarjeta, fechaVencimiento));
        return 1;
    }
    
    
    public int existeTarjeta(String numeroTarjeta)
    {
        int cantidad = this.ListTarjetas.size();
        tarjetasCredito tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListTarjetas.get(i);
            if(tmp.getNombreTarjeta().equals(numeroTarjeta)) return i;
        }
        return -1;
    }
     public tarjetasCredito obtener(int indice){
        return this.ListTarjetas.get(indice);
    }
     
    
       public int cantidad(){
        return this.ListTarjetas.size();
    }
        public tarjetasCredito getCategoria(int i){
        return this.ListTarjetas.get(i);
    }
      
     public tarjetasCredito getTarCredito(int i){
        return this.ListTarjetas.get(i);
    }
     public tarjetasCredito buscarTarjeta(String correo,String nombre)
    {
        int cantidad = this.ListTarjetas.size();
        tarjetasCredito tmp;
        
        for (int i = 0; i <cantidad ; i++) {
             tmp = obtener(i);
            if(tmp.getNombreTarjeta().equals(nombre)&& tmp.getCorreo().equals(correo)) {
                return  tmp;
            }
        }
        return null;
    }
       public void eliminar(String nombre)
    {
        tarjetasCredito tmp;
        
        for (int i = 0; i < cantidad(); i++) {
            tmp = obtener(i);
            if(tmp.getNombreTarjeta().equals(nombre) ) {
                this.ListTarjetas.remove(i);
            }
        }
    }
       
        public void actualizar(String nombre, String numero, String fecha)
    {
        int cantidad = cantidad();
        tarjetasCredito tmp;
        
        for (int i = 0; i < cantidad; i++) {
            tmp = obtener(i);
            if(tmp.getNombreTarjeta().equals(nombre)) {
                this.ListTarjetas.get(i).setNumeroTarjeta(numero);
                this.ListTarjetas.get(i).setFechaVencimiento(fecha);
            }
        }
    }
}
    
    

