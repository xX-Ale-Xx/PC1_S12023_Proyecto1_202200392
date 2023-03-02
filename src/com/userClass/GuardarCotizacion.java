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
public class GuardarCotizacion {
     private ArrayList<cotizacion> ListCotizar;
    
    public GuardarCotizacion(){
        this.ListCotizar = new ArrayList<>();
    }
    
    
    public int GuaCotizacion(String CodigoFactura,String correo,String DepOrigen,String DepDestino,String MuniOrigen,String MuniDestino,
            String DirOrigen,String DirDestino,int numPaquetes,String tamaño,double total, String tipoDePago,String efectivoOtarjeta,String nombre, String NIT, String CVV)
    {

        
        this.ListCotizar.add(new cotizacion(CodigoFactura,correo, DepOrigen,DepDestino,MuniOrigen, MuniDestino,
             DirOrigen,DirDestino, numPaquetes,tamaño,total, tipoDePago, efectivoOtarjeta, nombre ,NIT, CVV));
        return 1;
    }
    
     public int existeUsuario(String cod)
    {
        int cantidad = this.ListCotizar.size();
        cotizacion tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListCotizar.get(i);
            if(tmp.getCodigoFactura().equals(cod)) return i;
        }
        return -1;
    }

     public cotizacion obtener(int indice){
        return this.ListCotizar.get(indice);
    }
     
    
       public int cantidad(){
        return this.ListCotizar.size();
    }
        public cotizacion getCategoria(int i){
        return this.ListCotizar.get(i);
    }
      
     public cotizacion getCotizacion(int i){
        return this.ListCotizar.get(i);
    }
    
     
            public cotizacion buscarCotizacion(String CodigoFactura,String correo)
    {
        int cantidad = this.ListCotizar.size();
        cotizacion tmp;
        
        for (int i = 0; i <cantidad ; i++) {
             tmp = obtener(i);
            if(tmp.getCorreo().equals(correo) && tmp.getCodigoFactura().equals(CodigoFactura) ) 
            {
                tmp.setPosicion(i+1);
                return  tmp;
            }
        }
        return null;
    }
            
            public double TotalIngresos(){
                int cantidad = this.ListCotizar.size();
                cotizacion tmp;
             double total= 0;
                for (int i = 0; i <cantidad ; i++) {
             tmp = obtener(i);
             total += tmp.getTotal();
           
        }
                return total;
            }
            
             public int TotalPaquetes(){
                int cantidad = this.ListCotizar.size();
                cotizacion tmp;
             int total= 0;
                for (int i = 0; i <cantidad ; i++) {
             tmp = obtener(i);
             total += tmp.getNumPaquetes();
           
        }
                return total;
            }
            
}
