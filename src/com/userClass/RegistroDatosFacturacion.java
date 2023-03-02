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
public class RegistroDatosFacturacion {
    private ArrayList<DatosFacturacion> ListDatosFacturacion;
    
    public RegistroDatosFacturacion(){
        this.ListDatosFacturacion = new ArrayList<>();
     }
    
    
    public int ReDatosFac(String correo, String nombre, String direccion,String NIT)
    {
      
        
        this.ListDatosFacturacion.add(new DatosFacturacion(correo, nombre,direccion, NIT));
        return 1;
    }
    
    
   
     public DatosFacturacion obtener(int indice){
        return this.ListDatosFacturacion.get(indice);
    }
     
    
       public int cantidad(){
        return this.ListDatosFacturacion.size();
    }
        public DatosFacturacion getCategoria(int i){
        return this.ListDatosFacturacion.get(i);
    }
      
     public DatosFacturacion getDatosFac(int i){
        return this.ListDatosFacturacion.get(i);
    }
     
          public DatosFacturacion buscarDatos(String correo,String nombre)
    {
        int cantidad = this.ListDatosFacturacion.size();
        DatosFacturacion tmp;
        
        for (int i = 0; i <cantidad ; i++) {
             tmp = obtener(i);
            if(tmp.getNombre().equals(nombre)&&tmp.getCorreo().equals(correo)) {
                return  tmp;
            }
        }
        return null;
    }
    
}
