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
 public static void ocultarIdTabla(JTable tabla){
        // hago que la columna 0 no sea visible
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
}
