/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adminClass;

/**
 *
 * @author Carol
 */
public class municipios {
    
      private String codigoReg;
    private String CodigoDep;
    private String nombre;
    public municipios(String cod, String Codreg, String nom){
        this.CodigoDep = cod;
        this.codigoReg = Codreg;
        this.nombre = nom;
    }

    public void setCodigoReg(String codigoReg) {
        this.codigoReg = codigoReg;
    }

    public void setCodigoDep(String CodigoDep) {
        this.CodigoDep = CodigoDep;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoReg() {
        return codigoReg;
    }

    public String getCodigoDep() {
        return CodigoDep;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
