/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.userClass;

import com.registro.Usuarios;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;



/**
 *
 * @author Carol
 */
public class CotizacionHTML {
   
         /* Varible para crear la cadena para formar el archivo HTML */
    String reporte;
    String nombre;
    String correo;
    String contraseña;
    Usuarios buscar;

    public CotizacionHTML() {
        this.reporte = "";
       
        
    }


    /* ********************************************************************************************* *
      * Funcion que recibe:
      *     - El nombre con el que se va a crea el archivo 
      *     - Factura lleva todos los datos de los productos de la compra
      *     - User que es de tipo usuario y lleva toda la información del cliente
      * ********************************************************************************************* */
    public boolean CrearDoc(String nombre, String correo, String contraseña,String DepOrigen,String DepDestino,String MuniOrigen,String MuniDestino,
            String DirOrigen,String DirDestino,int numPaquetes,String tamaño,double total){
         this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        
        try {
            
            /* Se crea el archivo con el nombre que se le envia*/
            FileOutputStream archivo = new FileOutputStream(nombre+"_Cotizacion.html"); 
            /* Esta instancia de OutputStreamWriter nos permitira escribir en el archivo */
            OutputStreamWriter  osw = new OutputStreamWriter (archivo, StandardCharsets.UTF_8);
            /* Metodo para crear el reporte */
            crearReporte( DepOrigen, DepDestino, MuniOrigen, MuniDestino,
             DirOrigen, DirDestino,numPaquetes,tamaño, total);
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
    
    public void crearReporte(String DepOrigen,String DepDestino,String MuniOrigen,String MuniDestino,
            String DirOrigen,String DirDestino,int numPaquetes,String tamaño,double total){
        /* Estructura basica de un archivo HTML */
        this.reporte += "<!DOCTYPE html>\n";
        this.reporte += "<html>\n";
        this.reporte += "<head>\n";
        this.reporte += "\t<meta charset=\"utf-8\">\n";
        this.reporte += "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
        /* Titulo a mostrar en la pestaña del navegador */
        this.reporte += "\t<title> Cotizacion </title>\n";
        this.reporte += "</head>\n";
        this.reporte += "<body>\n";
        /* Titulo a mostrar en la pagina */
        this.reporte += "<h1> Cotizacion </h1>\n";
        /* Salto de linea */
       
        /* Datos del usuario */
       
        /* Salto de linea */
        nextLine();
        /* Creacion de la tabla de productos*/
        this.reporte += "<h3> Datos de Origen </h3>\n";
        nextLine();
        nextData("Departamento: "+ DepOrigen);
                nextLine();
        nextData("Municipio: "+ MuniOrigen);
                nextLine();
        nextData("Direccion: "+ DirOrigen);
        nextLine();
        this.reporte += "<h3> Datos de Destino </h3>\n";
        nextLine();
        nextData("Departamento: "+ DepDestino);
        nextLine();
        nextData("Municipio: "+ MuniDestino);
        nextLine();
        nextData("Direccion: "+ DirDestino);
        nextLine();
        this.reporte += "<h3> Datos de los paquetes </h3>\n";
        nextLine();
        nextData("Cantidad de paquetes: "+ numPaquetes );
        nextLine();
        nextData("Tamaño de los paquetes: "+ tamaño);
        nextLine();
        nextData("Total: "+ total);
        nextLine();
        
    
        /* Cierre del cuerpo y del archivo HTML */
        this.reporte += "</body>\n";
        this.reporte += "</html>";
    }
    
    
   
    private void nextData(String dato){
        /* Se crea la etiqueta para mostrar el elemento */
        this.reporte += "\t\t<li>"+dato+"</li>\n";
    }
    
    /* **************************************************************************************************************** * 
      * **************************************************************************************************************** *
      * **************************************************************************************************************** */

    
    
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
    

