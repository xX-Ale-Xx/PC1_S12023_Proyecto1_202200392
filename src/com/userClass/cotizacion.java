/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.userClass;

/**
 *
 * @author Carol
 */
public class cotizacion {
    private int posicion;
        private String CodigoFactura;
    private String correo;
    private String DepOrigen;
    private String DepDestino;
    private String MuniOrigen;
    private String MuniDestino;
    private String DirOrigen;
    private String DirDestino;
    private int numPaquetes;
    private String tamaño;
    private double total;
    private String tipoDePago;
    private String efectivoOtarjeta;
    private String nombre;

    private String NIT;
    private String CVV; 
    
    public cotizacion(String CodigoFactura,String correo,String DepOrigen,String DepDestino,String MuniOrigen,String MuniDestino,
            String DirOrigen,String DirDestino,int numPaquetes,String tamaño,double total, String tipoDePago,String efectivoOtarjeta,String nombre, String NIT, String CVV){
        this.DepOrigen = DepOrigen;
        this.DepDestino = DepDestino;
        this.MuniOrigen = MuniOrigen;
        this.MuniDestino = MuniDestino;
        this.DirOrigen = DirOrigen;
        this.DirDestino = DirDestino;
        this.numPaquetes = numPaquetes;
        this.tamaño = tamaño;
        this.total = total;
        this.correo = correo;
        this.tipoDePago = tipoDePago;
        this.efectivoOtarjeta = efectivoOtarjeta;
        this.nombre = nombre;
        this.NIT = NIT;
        this.CVV= CVV;
        this.CodigoFactura = CodigoFactura;
    }

    public String getCodigoFactura() {
        return CodigoFactura;
    }

    public void setCodigoFactura(String CodigoFactura) {
        this.CodigoFactura = CodigoFactura;
    }

    public String getDepOrigen() {
        return DepOrigen;
    }

    public String getDepDestino() {
        return DepDestino;
    }

    public String getMuniOrigen() {
        return MuniOrigen;
    }

    public String getMuniDestino() {
        return MuniDestino;
    }

    public String getDirOrigen() {
        return DirOrigen;
    }

    public String getDirDestino() {
        return DirDestino;
    }

    public int getNumPaquetes() {
        return numPaquetes;
    }

    public String getTamaño() {
        return tamaño;
    }

    public double getTotal() {
        return total;
    }

    public void setDepOrigen(String DepOrigen) {
        this.DepOrigen = DepOrigen;
    }

    public void setDepDestino(String DepDestino) {
        this.DepDestino = DepDestino;
    }

    public void setMuniOrigen(String MuniOrigen) {
        this.MuniOrigen = MuniOrigen;
    }

    public void setMuniDestino(String MuniDestino) {
        this.MuniDestino = MuniDestino;
    }

    public void setDirOrigen(String DirOrigen) {
        this.DirOrigen = DirOrigen;
    }

    public void setDirDestino(String DirDestino) {
        this.DirDestino = DirDestino;
    }

    public void setNumPaquetes(int numPaquetes) {
        this.numPaquetes = numPaquetes;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public void setEfectivoOtarjeta(String efectivoOtarjeta) {
        this.efectivoOtarjeta = efectivoOtarjeta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public String getEfectivoOtarjeta() {
        return efectivoOtarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    

    public String getNIT() {
        return NIT;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }
    
    
}
