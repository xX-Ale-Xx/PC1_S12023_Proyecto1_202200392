/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adminClass;

/**
 *
 * @author Carol
 */
public class kioscos {
    private String CodKiosco;
    private String NomKiosco;
    private String CodRegion;
    public kioscos(String codK, String nomK, String CodR){
        this.CodKiosco = codK;
        this.NomKiosco = nomK;
        this.CodRegion = CodR;
    }

    public void setCodKiosco(String CodKiosco) {
        this.CodKiosco = CodKiosco;
    }

    public void setNomKiosco(String NomKiosco) {
        this.NomKiosco = NomKiosco;
    }

    public void setCodRegion(String CodRegion) {
        this.CodRegion = CodRegion;
    }

    public String getCodKiosco() {
        return CodKiosco;
    }

    public String getNomKiosco() {
        return NomKiosco;
    }

    public String getCodRegion() {
        return CodRegion;
    }
    
}
