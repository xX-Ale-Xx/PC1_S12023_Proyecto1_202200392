/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.userClass;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import com.login.Listas;

import java.io.FileOutputStream;
/**
 *
 * @author Carol
 */
public class CodigoDeBarras {
   

    
    public CodigoDeBarras(){
        
    }
    
    public void GenerarCodigo(String nombre, String CodigoFactura, String correo, Listas newListas){
        try {
    cotizacion buscar = newListas.getNewCotizacion().buscarCotizacion(CodigoFactura, correo);
    Document doc = new Document();
    PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(nombre+"_Guia.pdf"));
       
    doc.open();
    
    doc.add(new Paragraph("Origen: "+ buscar.getDepOrigen()+"/"+buscar.getMuniOrigen()));
    doc.add(new Paragraph("Destino: "+ buscar.getDepDestino()+"/"+buscar.getMuniDestino()));
    doc.add(new Paragraph("Nombre del remitente: "+buscar.getNombre()));
    doc.add(new Paragraph("Direccion del destinatario: "+ buscar.getDirDestino()));
    
    
    doc.add(new Paragraph(""));
    
            Barcode128 code = new Barcode128();
            code.setCode(CodigoFactura);
            com.itextpdf.text.Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.YELLOW);
        img.scalePercent(200);
            doc.add(img);
            doc.add(new Paragraph(""));
            doc.add(new Paragraph("Cantidad de paquetes: "+buscar.getNumPaquetes()));
            doc.add(new Paragraph("Tamaño del paquete: "+ buscar.getTamaño()));
        doc.close();
        } catch (Exception e) {
        }
        
        
    }
    
}
