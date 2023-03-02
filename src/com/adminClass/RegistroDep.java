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
public class RegistroDep {
    private ArrayList<departamentos> ListDepartamentos;
    departamentos dep1 = new departamentos("01", "M", "Guatemala");
    departamentos dep2 = new departamentos("02", "NO", "El Progreso");
    departamentos dep3 = new departamentos("03", "M", "Sacatepequez");
     departamentos dep4 = new departamentos("12", "SOC", "San Marcos");
     departamentos dep5 = new departamentos("16", "NT", "Alta Verapaz");
    
    
    public RegistroDep(){
        this.ListDepartamentos = new ArrayList<>();
        ListDepartamentos.add(dep1);
        ListDepartamentos.add(dep2);
        ListDepartamentos.add(dep3);
        ListDepartamentos.add(dep4);
        ListDepartamentos.add(dep5);
    }
    
    
    public int ReDep(String cod, String region, String nombre)
    {
        int indice = existeDep(cod);
        if(indice!=-1) return 2;
        
        this.ListDepartamentos.add(new departamentos(cod, region, nombre));
        return 1;
    }
    
    
    public int existeDep(String cod)
    {
        int cantidad = this.ListDepartamentos.size();
        departamentos tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListDepartamentos.get(i);
            if(tmp.getCodigoDep().equals(cod)) return i;
        }
        return -1;
    }
       public int cantidad(){
        return this.ListDepartamentos.size();
    }
        public departamentos getCategoria(int i){
        return this.ListDepartamentos.get(i);
    }
      
     public departamentos getDepartamento(int i){
        return this.ListDepartamentos.get(i);
    }
      public departamentos obtener(int indice){
        return this.ListDepartamentos.get(indice);
    }
    
      public void actualizar(String cod, String region, String nom)
    {
        int cantidad = cantidad();
        departamentos tmp;
        
        for (int i = 0; i < cantidad; i++) {
            tmp = obtener(i);
            if(tmp.getCodigoDep().equals(cod)) {
                this.ListDepartamentos.get(i).setNombreDep(nom);
                this.ListDepartamentos.get(i).setRegionDep(region);
            }
        }
    }
        public departamentos buscarDepa(String nombre)
    {
        int cantidad = this.ListDepartamentos.size();
        departamentos tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListDepartamentos.get(i);
            if(tmp.getNombreDep().equals(nombre)) {
                return  tmp;
            }
        }
        return null;
    }
        
        public departamentos buscarDepa2(String nombre)
    {
        int cantidad = this.ListDepartamentos.size();
        departamentos tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListDepartamentos.get(i);
            if(tmp.getRegionDep().equals(nombre)) {
                return  tmp;
            }
        }
        return null;
    }
      public void eliminar(String nombre)
    {
        departamentos tmp;
        
        for (int i = 0; i < cantidad(); i++) {
            tmp = obtener(i);
            if(tmp.getCodigoDep().equals(nombre)) {
                this.ListDepartamentos.remove(i);
            }
        }
    }
}
