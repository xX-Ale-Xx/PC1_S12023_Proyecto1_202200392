/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adminClass;

import java.util.ArrayList;

/**
 *
 * @author Carol
 */
public class ControlPrecios {
      private ArrayList<precios> ListPrecios;
    precios precio1 = new precios("M", 35.00, 25.00);
    precios precio2 = new precios("NT", 68.50 , 45.55);
    precios precio3 = new precios("NO", 58.68 , 35.48);
    precios precio4 = new precios("SO", 38.68 , 32.48);
    precios precio5 = new precios("SOC", 34.00 , 29.00);
    precios precio6 = new precios("NOC", 44.50 , 40.00);
    
    public ControlPrecios(){
        this.ListPrecios = new ArrayList<>();
        ListPrecios.add(precio1);
        ListPrecios.add(precio2);
        ListPrecios.add(precio3);
        ListPrecios.add(precio4);
        ListPrecios.add(precio5);
        ListPrecios.add(precio6);
    }
    
    
    public int ControlP(String Region, double Estandar, double Especial)
    {
        int indice = existePrecio(Region);
        if(indice!=-1) return 2;
        
        this.ListPrecios.add(new precios(Region, Estandar, Especial));
        return 1;
    }
    
    
    public int existePrecio(String Region)
    {
        int cantidad = this.ListPrecios.size();
        precios tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListPrecios.get(i);
            if(tmp.getRegion().equals(Region)) return i;
        }
        return -1;
    }
     public precios obtener(int indice){
        return this.ListPrecios.get(indice);
    }
     
    
       public int cantidad(){
        return this.ListPrecios.size();
    }
        public precios getCategoria(int i){
        return this.ListPrecios.get(i);
    }
      
     public precios getPrecios(int i){
        return this.ListPrecios.get(i);
    }
     public void actualizar(String Region, double Estandar, double Especial)
    {
        int cantidad = cantidad();
        precios tmp;
        
        for (int i = 0; i < cantidad; i++) {
            tmp = obtener(i);
            if(tmp.getRegion().equals(Region)) {
                this.ListPrecios.get(i).setEstandar(Estandar);
                this.ListPrecios.get(i).setEspecial(Especial);
            }
        }
    }
     
       public precios buscarPrecio(String Region)
    {
        int cantidad = this.ListPrecios.size();
        precios tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListPrecios.get(i);
            if(tmp.getRegion().equals(Region)) {
                return  tmp;
            }
        }
        return null;
    }
}
