/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import javax.swing.JTextField;

/**
 *
 * @author joel
 */
public class MyUtil {
    
    
     
    /**filtra cualquier caracter excepto los numeros. es decir permite solo entrada de numero.
     * 
     * @param evt  evento 
     */
    public static void consumirLetras(java.awt.event.KeyEvent evt) {
        // conusmir los caracteres del legajo excepto los numeros
        char caracter = evt.getKeyChar();
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }
     /**
      * 
      * @param evt
      * @param campo es la jtexfield que necesita que se realiza los filtros de caracteres
      * @param n   longitud maxima de numeros que permite el jtextfield
      */
     public static void consumirLetras(java.awt.event.KeyEvent evt, JTextField campo, int n) {
          consumirLetras(evt);
        if (campo.getText().length() == n) {
            evt.consume();
        }
     }
     
}
