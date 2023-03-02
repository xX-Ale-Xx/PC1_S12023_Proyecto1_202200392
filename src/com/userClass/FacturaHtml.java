/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.userClass;
import com.login.Listas;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
/**
 *
 * @author Carol
 */
public class FacturaHtml {
    Listas newListas;
    String reporte;
    String nombre;
    public FacturaHtml(){
        this.reporte = "";
    }
        public boolean CrearDoc(String nombre, String CodigoFactura, String correo, Listas newListas){
        this.nombre = nombre;
        this.newListas = newListas;
        try {
            
            /* Se crea el archivo con el nombre que se le envia*/
            FileOutputStream archivo = new FileOutputStream(nombre+".html"); 
            /* Esta instancia de OutputStreamWriter nos permitira escribir en el archivo */
            OutputStreamWriter  osw = new OutputStreamWriter (archivo, StandardCharsets.UTF_8);
            /* Metodo para crear el reporte */
            crearReporte( CodigoFactura, correo, newListas );
            /* Se escribe la cadena para formar el contenido del archivo */
            osw.write(this.reporte);
            /* Se cierra el documento esto siempre se debe hacer para que no se presente
            ningun problema*/
            osw.close();
            archivo.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error "+e);
            return false;
        }
    }
    
    public void crearReporte( String CodigoFactura, String correo, Listas newListas){
        
        /* Estructura basica de un archivo HTML */
        this.reporte += "<!DOCTYPE html>\n";
        this.reporte += "<html>\n";
        this.reporte += "<head>\n";
        this.reporte += "\t<meta charset=\"utf-8\">\n";
        this.reporte += "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
        /* Titulo a mostrar en la pestaña del navegador */
        this.reporte += "\t<title> Factura Usac-Delivery</title>\n";
        this.reporte += "</head>\n";
        this.reporte += "<body>\n";
        /* Titulo a mostrar en la pagina */
        this.reporte += "<h1>Factura Usac-Delivery </h1>\n";
        /* Salto de linea */
        nextLine();
        /* Datos del usuario */
        datosUsuario(CodigoFactura, correo, newListas);
        /* Salto de linea */
        nextLine();
        /* Creacion de la tabla de productos*/
        nuevaTabla(CodigoFactura, correo, newListas);
        nextLine();
        
        /* Cierre del cuerpo y del archivo HTML */
        this.reporte += "</body>\n";
        this.reporte += "</html>";
    }
    
    
    private void datosUsuario(String CodigoFactura, String correo, Listas newListas){
        /*  Se crea la etiqueta que abre una lista para mostrar los datos del usuario */
        int cant = newListas.getNewCotizacion().cantidad();
        cotizacion buscar = newListas.getNewCotizacion().buscarCotizacion(CodigoFactura, correo);
        this.reporte += "\t<ul>\n";
        /* Se agregan los elemento a la lista */
        nextData("Nombre del cliente: "+ buscar.getNombre());
        nextData("Numero de Factura: "+ buscar.getPosicion() );
        nextData("Codigo del paquete : " + buscar.getCodigoFactura());
        nextData("NIT : " + buscar.getNIT());
        nextData("Fecha: " + String.valueOf(LocalDateTime.now()));
        nextLine();
        this.reporte += "<h3> Datos de origen </h3>\n";
        nextData("Departamento: "+buscar.getDepOrigen());
        nextData("Municipio: "+buscar.getMuniOrigen());
        nextData("Direccion: "+buscar.getDirOrigen());
        nextLine();
        this.reporte += "<h3> Datos de Destino </h3>\n";
         nextData("Departamento: "+buscar.getDepDestino());
        nextData("Municipio: "+buscar.getMuniDestino());
        nextData("Direccion: "+buscar.getDirDestino());
        nextLine();
        this.reporte += "<h3> Tipo de pago </h3>\n";
        nextData(buscar.getTipoDePago());
        nextData(buscar.getEfectivoOtarjeta());
        
        /*  Se crea la etiqueta que cierra la lista */
        this.reporte += "\t<ul>\n";
    }
    
    private void nextData(String dato){
        /* Se crea la etiqueta para mostrar el elemento */
        this.reporte += "\t\t<li>"+dato+"</li>\n";
    }
    
    /* **************************************************************************************************************** * 
      * **************************************************************************************************************** *
      * **************************************************************************************************************** */
    private void nuevaTabla(String CodigoFactura, String correo, Listas newListas){
        cotizacion buscar = newListas.getNewCotizacion().buscarCotizacion(CodigoFactura, correo);
        /* Se crea la etiqueta que abre para una tabla */
        this.reporte += "\t<table border=\"1\">\n";
        /* Se agrega el titulo de la pagina */
         addTitulosCulomns();
        
        /* Se verifica que la factura que se envia sea diferente de null  */
        if(buscar!=null){
            /* Se obtiene el numero de productos en la factura */
            /*Encabezado*/
            /* Se crea una variable de tipo Producto agregado que servira para almacenar
              * temporalmente los datos de los productos de la lista */

            /* For que recorre la lista de productos */
            
                /* Se obtiene un elemento de la listas */
                
                /* Se agraga una nueva fila con los datos del producto */
                addRow(1, buscar.getNumPaquetes(), buscar.getTamaño(), buscar.getTotal());
            
        }
        /* Se crea la etiqueta que cierra la tabla */
        this.reporte += "\t</table>\n";
    }
    
    private void addTitulosCulomns(){
        /* Se crea la etiqueta que abre la fila*/
        openRow();
        addColumn("No.");
        addColumn("Cantidad");
        addColumn("Tamaño");
        addColumn("Total a pagar");
        /* Se crea la etiqueta que cierra la fila */
        closeRow();
    }
    
    private void addRow(int No, int cantidad, String producto, double subtotal){
        openRow();
        addColumnNumber(No);
        addColumnNumber(cantidad);
        addColumn(producto);
        addColumnNumber(subtotal);
        closeRow();
    }
    
    private void addColumn(String dato){
        /* Se crea la etiqueta que abre la columna */
        openColumn();
        /* Se agraga el dato del producto */
        this.reporte += dato;
        /* Se crea la etiqueta que cierra la columna */
        closeColumn();
    }
    
    private void addColumnNumber(int dato){
        /* Se crea la etiqueta que abre la columna */
        openColumn();
        /* Se agraga el dato del producto */
        this.reporte += dato;
        /* Se crea la etiqueta que cierra la columna */
        closeColumn();
    }
    
    private void addColumnNumber(double dato){
        /* Se crea la etiqueta que abre la columna */
        openColumn();
        /* Se agraga el dato del producto */
        this.reporte += dato;
        /* Se crea la etiqueta que cierra la columna */
        closeColumn();
    } 
    
    private void openRow(){
        /* Se crea la etiqueta que abre la fila */
        this.reporte += "\t\t<tr>\n";        
    }
    
    private void closeRow(){
        /* Se crea la etiqueta que cierra la fila */
        this.reporte += "\t\t</tr>\n";
    } 
    
    private void openColumn(){
        /* Se crea la etiqueta que abre la columna */
        this.reporte += "\t\t\t<th>";        
    }
    
    private void closeColumn(){
        /* Se crea la etiqueta que cierra la columna */
        this.reporte += "</th>\n";
    } 
    
    private void nextLine(){
        /* Se crea la etiqueta para un salto de linea */
        this.reporte += "\t<br>\n";
    }
    
    public boolean AbrirArchivo(){
        try {
            /* Se obtiene el archivo a traves de File
              * al realizar la instancia se debe colocar la ruta del archivo
              * en este caso solo se coloca el nombre y la extension debido a que
              * se encuentra en la misma carpeta del proyecto */
            File path = new File(nombre+".html");
            /* Se abrira el archivo */
            Desktop.getDesktop().open(path);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
