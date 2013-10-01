/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.main;

import co.tecnomati.java.controlcaja.dominio.dao.imp.TipoComprobanteDaoImp;
import co.tecnomati.java.controlcaja.util.Creador;
import co.tecnomati.java.controlcaja.util.NumberToLetterConverter;
import co.tecnomati.java.controlcaja.vista.GUIGestorDeCaja;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
           if( new TipoComprobanteDaoImp().listarTipoFormulario().isEmpty())
              Creador.CrearRecibos();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "LA BD NO ESTA INICIADA, POR FAVOR ACTIVE EL SERVICIO Y VUELVA ARRANCAR EL SISTEMA ", "ERROR", JOptionPane.ERROR_MESSAGE);
       }
        
        GUIGestorDeCaja gestorCaja = new GUIGestorDeCaja();
////        Double pesos = 0.29;
//      double valor=0.0;
//        for (double i = 0.1; i < 1000; i++) {
//      
//            valor = valor+i;
//      
////      System.out.println("Número : "+big);
//        }
     
    }
   
}
