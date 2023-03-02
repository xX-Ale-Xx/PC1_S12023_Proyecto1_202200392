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
public class RegistroMuni {
     private ArrayList<municipios> ListMuni;
    municipios dep1 = new municipios("01", "0101", "Guatemala");
    municipios dep2 = new municipios("01", "0102", "Santa Catarina Pinula");
    
    public RegistroMuni(){
        this.ListMuni = new ArrayList<>();
        ListMuni.add(dep1);
        ListMuni.add(dep2);
    }
    
    
    public int ReMuni(String cod, String region, String nombre)
    {
        int indice = existeMuni(region);
        if(indice!=-1) return 2;
        
        this.ListMuni.add(new municipios(cod, region, nombre));
        return 1;
    }
    
    
    public int existeMuni(String cod)
    {
        int cantidad = this.ListMuni.size();
        municipios tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListMuni.get(i);
            if(tmp.getCodigoReg().equals(cod)) return i;
        }
        return -1;
    }
       public int cantidad(){
        return this.ListMuni.size();
    }
        public municipios getCategoria(int i){
        return this.ListMuni.get(i);
    }
      
     public municipios getMunicipio(int i){
        return this.ListMuni.get(i);
    }
}
