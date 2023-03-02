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
public class RegistroKioscos {
    private ArrayList<kioscos> ListKioscos;
    kioscos kiosco = new kioscos("001", "El Amigo", "M");
    kioscos kiosco2 = new kioscos("002", "La Terraza", "NO");
    
    public RegistroKioscos(){
        this.ListKioscos = new ArrayList<>();
        ListKioscos.add(kiosco);
        ListKioscos.add(kiosco2);
    }
    
    
    public int ReKioscos(String codK, String nomK, String codR)
    {
        int indice = existeKiosco(codK);
        if(indice!=-1) return 2;
        
        this.ListKioscos.add(new kioscos(codK, nomK, codR));
        return 1;
    }
    
    
    public int existeKiosco(String codK)
    {
        int cantidad = this.ListKioscos.size();
        kioscos tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListKioscos.get(i);
            if(tmp.getCodKiosco().equals(codK)) return i;
        }
        return -1;
    }
     public kioscos obtener(int indice){
        return this.ListKioscos.get(indice);
    }
     
    
       public int cantidad(){
        return this.ListKioscos.size();
    }
        public kioscos getCategoria(int i){
        return this.ListKioscos.get(i);
    }
      
     public kioscos getKiosco(int i){
        return this.ListKioscos.get(i);
    }
     public void actualizar(String codK, String nomK, String codR)
    {
        int cantidad = cantidad();
        kioscos tmp;
        
        for (int i = 0; i < cantidad; i++) {
            tmp = obtener(i);
            if(tmp.getCodKiosco().equals(codK)) {
                this.ListKioscos.get(i).setNomKiosco(nomK);
                this.ListKioscos.get(i).setCodRegion(codR);
            }
        }
    }
     
        public kioscos buscarKiosco(String nombre)
    {
        int cantidad = this.ListKioscos.size();
        kioscos tmp;
        
        for (int i = 0; i <cantidad ; i++) {
            tmp = this.ListKioscos.get(i);
            if(tmp.getNomKiosco().equals(nombre)) {
                return  tmp;
               
                
            }
        }
        return null;
    }
        
        public void eliminar(String nombre)
    {
        kioscos tmp;
        
        for (int i = 0; i < cantidad(); i++) {
            tmp = obtener(i);
            if(tmp.getNomKiosco().equals(nombre)) {
                this.ListKioscos.remove(i);
            }
        }
    }
}
