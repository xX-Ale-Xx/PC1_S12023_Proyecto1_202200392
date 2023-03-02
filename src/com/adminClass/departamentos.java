/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adminClass;

/**
 *
 * @author Carol
 */
public class departamentos {
    private String codigoDep;
    private String regionDep;
    private String nombreDep;
    public departamentos(String cod, String region, String nom){
        this.codigoDep = cod;
        this.regionDep = region;
        this.nombreDep = nom;
    }

    public void setCodigoDep(String codigoDep) {
        this.codigoDep = codigoDep;
    }

    public void setRegionDep(String regionDep) {
        this.regionDep = regionDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }

    public String getCodigoDep() {
        return codigoDep;
    }

    public String getRegionDep() {
        return regionDep;
    }

    public String getNombreDep() {
        return nombreDep;
    }
    
}
