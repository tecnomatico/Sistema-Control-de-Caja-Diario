/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import javax.swing.JTable;

/**
 *
 * @author joel
 */
public class TablaUtil {
    
 /**
  * Oculta la primer columna de la tabla
  * @param tabla nombre de la tabla
  */   
 public static void ocultarIdTabla(JTable tabla){
        // hago que la columna 0 no sea visible
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
 /**
  * Setea el tamaño de una columna determinada de una tabla
  * @param tabla nombre de la tabla
  * @param col  numero de la columna dentro de la tabla
  * @param size tamaño que se quiere setear a la  columna col 
  */
 
 public static void setSizeColumnaTabla(JTable tabla, int col, int size){
        // hago que la columna 0 no sea visible
        tabla.getColumnModel().getColumn(col).setMaxWidth(size+50);
        tabla.getColumnModel().getColumn(col).setMinWidth(size);
        tabla.getColumnModel().getColumn(col).setPreferredWidth(size);
    }
    
}
