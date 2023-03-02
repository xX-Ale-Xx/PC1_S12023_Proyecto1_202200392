/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adminClass;

/**
 *
 * @author Carol
 */
public class precios {
    private String Region;
    private double Estandar;
    private double Especial;
    
    public precios(String R, double Estandar, double Esp){
        this.Region = R;
        this.Estandar = Estandar;
        this.Especial=Esp;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setEstandar(double Estandar) {
        this.Estandar = Estandar;
    }

    public void setEspecial(double Especial) {
        this.Especial = Especial;
    }

    public String getRegion() {
        return Region;
    }

    public double getEstandar() {
        return Estandar;
    }

    public double getEspecial() {
        return Especial;
    }
    
    
}
