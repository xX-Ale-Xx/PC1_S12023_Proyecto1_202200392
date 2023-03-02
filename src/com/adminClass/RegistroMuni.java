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
    municipios dep3 = new municipios("02", "0201", "Guastatoya");
        municipios dep4 = new municipios("03", "0301", "Antigua");
            municipios dep5 = new municipios("12", "1201", "San Marcos");
                municipios dep6 = new municipios("16", "1601", "Coban");
    
    public RegistroMuni(){
        this.ListMuni = new ArrayList<>();
        ListMuni.add(dep1);
        ListMuni.add(dep2);
        ListMuni.add(dep3);
        ListMuni.add(dep4);
        ListMuni.add(dep5);
        ListMuni.add(dep6);
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
     public municipios obtener(int indice){
        return this.ListMuni.get(indice);
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
     public void actualizar(String cod, String region, String nom)
    {
        int cantidad = cantidad();
        municipios tmp;
        
        for (int i = 0; i < cantidad; i++) {
            tmp = obtener(i);
            if(tmp.getCodigoReg().equals(region)) {
                this.ListMuni.get(i).setCodigoDep(cod);
                this.ListMuni.get(i).setNombre(region);
            }
        }
    }
     
            public municipios buscarMuni(String nombre)
    {
        int cantidad = this.ListMuni.size();
        municipios tmp;
        
        for (int i = 0; i <cantidad ; i++) {
             tmp = obtener(i);
            if(tmp.getCodigoDep().equals(nombre)) {
                return  tmp;
            }
        }
        return null;
    }
             public void eliminar(String nombre)
    {
        municipios tmp;
        
        for (int i = 0; i < cantidad(); i++) {
            tmp = obtener(i);
            if(tmp.getCodigoReg().equals(nombre)) {
                this.ListMuni.remove(i);
            }
        }
    }
}
