/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.userClass;

/**
 *
 * @author Carol
 */
public class DatosFacturacion {
    private String correo;
    private String nombre;
    private String direccion;
    private String NIT;
    
    public DatosFacturacion(String correo, String nombre, String direccion,String NIT){
        this.correo = correo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.NIT = NIT;
        
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNIT() {
        return NIT;
    }
    
    
    
}
