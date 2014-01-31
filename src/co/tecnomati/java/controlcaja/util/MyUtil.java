/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import java.text.SimpleDateFormat;
import java.util.Date;
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
     
     public static String getFechaString10DDMMAAAA (Date fecha){
        
         Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");     
         return sdf.format(fecha);
    }
     public static String getFechaString10AAAAMMDD (Date fecha){
        
         Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");     
         return sdf.format(fecha);
    }
   
   /**
    * Permite el ingreso de cualquier caracter y tambien
    * Consume cualquier caracter luego de haber ingresado n caracteres.
    * @param evt
    * @param campo
    * @param n 
    */
     public static void consumirAll(java.awt.event.KeyEvent evt, JTextField campo, int n){
         if (evt.getKeyChar()!='.' || countChar(".", campo.getText())>1) {
             consumirLetras(evt);
         }
         if (campo.getText().length() == n) {
            evt.consume();
        } 
    }
     
     public static int countChar(String c, String s){
        return s.split(c).length - 1;
     }
     
     /**
      * 
      * @param numero es el numero que se quiere rendondear
      * @param digitos la cantidad de cifras decimales a la que se quiere redondear el numero
      * @return numero double rendondeado a (digitos) decimales
      */
     public static double Redondear(double numero,int digitos)
{
      int cifras=(int) Math.pow(10,digitos);
      return Math.rint(numero*cifras)/cifras;
}
     /**
      * comparara el primer argumento con el segundo argumento
      * @param x primer argumento double
      * @param y segundo argumento double
      * @return  true si x<= y 
      *          false en otro caso
      */ 
     public static boolean isMenorOrIgual(double x, double y){
       
        return x<=y;
    }
     
     /**
      * 
      * @param monotributo valar con signo negativo
      * @return retorna la parte positiva del valor
      */
     public static double convertirPositivoDouble(double monotributo){
         if ((monotributo==0   || monotributo<0)) {
            monotributo= (-1)*monotributo;
         }
         return monotributo;
      }
     
}