/*
 * Click nbfs://nbhost/String/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/String/Templates/Classes/Class.java to edit this template
 */
package com.registro;

/**
 *
 * @author Carol
 */
public class Usuarios {
    private String foto;
    private String correo;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String Dpi;
    private String sobreNombre;
    private String fecha;
    private String generoPersona;
    private String nacion;
    private int telefono;
    private String rol;
    private String kiosco;
  
    private boolean disponible;
    
    public Usuarios(String correo, String contraseña, String nombre, String apellido, String DPI, String alias, String fechaNac, int telefono, String rol, String kiosco, String nacionalidad, String genero, String foto)
    {
    this.correo = correo;
    this.contraseña=contraseña;
    this.nombre=nombre;
    this.apellido=apellido;
    this.Dpi=DPI;
    this.sobreNombre=alias;
    this.fecha=fechaNac;
    this.generoPersona=genero;
    this.nacion=nacionalidad;
    this.telefono=telefono;
    this.rol=rol;
    this.kiosco=kiosco;
    this.foto=foto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDpi() {
        return Dpi;
    }

    public String getSobreNombre() {
        return sobreNombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getGeneroPersona() {
        return generoPersona;
    }

    public String getNacion() {
        return nacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getRol() {
        return rol;
    }

    public String getKiosco() {
        return kiosco;
    }

    public String getFoto() {
        return foto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDpi(String Dpi) {
        this.Dpi = Dpi;
    }

    public void setSobreNombre(String sobreNombre) {
        this.sobreNombre = sobreNombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setGeneroPersona(String generoPersona) {
        this.generoPersona = generoPersona;
    }

    public void setNacion(String nacion) {
        this.nacion = nacion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setKiosco(String kiosco) {
        this.kiosco = kiosco;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
   

    public boolean isDisponible() {
        return disponible;
    }

    public void noDisponible() {
        this.disponible = false;
    }
}
