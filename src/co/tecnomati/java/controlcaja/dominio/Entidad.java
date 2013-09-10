/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio;

/**
 *
 * @author joel
 */

/**
 * 
 * @author joel
 * Esta entidad lo hice con los fines de centralizar las personas fisicas o juridicas que se utilizara en el recibo
 */

public class Entidad {
   private int  id;
   private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
}
