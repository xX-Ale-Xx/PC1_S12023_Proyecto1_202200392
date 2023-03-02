/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login;

import com.adminClass.ControlPrecios;
import com.adminClass.RegistroDep;
import com.adminClass.RegistroKioscos;
import com.adminClass.RegistroMuni;
import com.registro.RegistrarUsuarios;
import com.userClass.GuardarCotizacion;
import com.userClass.RegistroDatosFacturacion;
import com.userClass.RegistroTarjetasCredito;


/**
 *
 * @author Carol
 */
public class Listas {
    RegistrarUsuarios newRegis = new RegistrarUsuarios();
    RegistroDep newDep = new RegistroDep();
    RegistroKioscos newKioscos = new RegistroKioscos();
    RegistroMuni newMuni = new RegistroMuni();
    ControlPrecios newPrecios = new ControlPrecios();
    RegistroTarjetasCredito newTarjetas = new RegistroTarjetasCredito();
    RegistroDatosFacturacion newDatosFac = new RegistroDatosFacturacion();
    GuardarCotizacion newCotizacion = new GuardarCotizacion();
   
    private String usuario;

    public Listas() {

    }

    public void setNewRegis(RegistrarUsuarios newRegis) {
        this.newRegis = newRegis;
    }

    public void setNewDep(RegistroDep newDep) {
        this.newDep = newDep;
    }

    public void setNewKioscos(RegistroKioscos newKioscos) {
        this.newKioscos = newKioscos;
    }

    public void setNewMuni(RegistroMuni newMuni) {
        this.newMuni = newMuni;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public RegistrarUsuarios getNewRegis() {
        return newRegis;
    }

    public RegistroDep getNewDep() {
        return newDep;
    }

    public RegistroKioscos getNewKioscos() {
        return newKioscos;
    }

    public RegistroMuni getNewMuni() {
        return newMuni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setNewPrecios(ControlPrecios newPrecios) {
        this.newPrecios = newPrecios;
    }

    public ControlPrecios getNewPrecios() {
        return newPrecios;
    }

    public RegistroTarjetasCredito getNewTarjetas() {
        return newTarjetas;
    }

    public void setNewTarjetas(RegistroTarjetasCredito newTarjetas) {
        this.newTarjetas = newTarjetas;
    }

    public RegistroDatosFacturacion getNewDatosFac() {
        return newDatosFac;
    }

    public void setNewDatosFac(RegistroDatosFacturacion newDatosFac) {
        this.newDatosFac = newDatosFac;
    }

    public GuardarCotizacion getNewCotizacion() {
        return newCotizacion;
    }

    public void setNewCotizacion(GuardarCotizacion newCotizacion) {
        this.newCotizacion = newCotizacion;
    }

   
    

}
