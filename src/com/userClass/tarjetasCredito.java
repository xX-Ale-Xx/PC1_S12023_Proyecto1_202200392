/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.userClass;

/**
 *
 * @author Carol
 */
public class tarjetasCredito {
    private String correo;
    private String nombreTarjeta;
    private String numeroTarjeta;
    private String fechaVencimiento;

    public tarjetasCredito(String correo,String nombreTarjeta,String numeroTarjeta, String fechaVencimiento) {
        this.correo = correo;
        this.nombreTarjeta = nombreTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
    
}
