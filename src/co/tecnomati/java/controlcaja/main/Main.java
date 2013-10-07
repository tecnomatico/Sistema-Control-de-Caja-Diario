/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.main;

import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CategoriaComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.TipoComprobanteDaoImp;
import co.tecnomati.java.controlcaja.util.ComprobanteUtil;
import co.tecnomati.java.controlcaja.util.Creador;
import co.tecnomati.java.controlcaja.util.NumberToLetterConverter;
import co.tecnomati.java.controlcaja.vista.GUIGestorDeCaja;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.Set;
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
           if( new CategoriaComprobanteDaoImp().listarCategoriaComprobante().isEmpty())
             Creador.CrearCategoriaComprobanteYRecibos();
            Creador.CrearCooperativayAsociado();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "LA BD NO ESTA INICIADA, POR FAVOR ACTIVE EL SERVICIO Y VUELVA ARRANCAR EL SISTEMA ", "ERROR", JOptionPane.ERROR_MESSAGE);
       }
        
        GUIGestorDeCaja gestorCaja = new GUIGestorDeCaja();
       
//       // probar num serie iq
//       long n = 1384;
//       String cadenaI= ComprobanteUtil.formatearNumSerieIzq(n);
//       String cadenaD= ComprobanteUtil.formatearNumSerieDer(n);
//       System.out.println(cadenaI);
//       System.out.println(cadenaD);
       
       
////        Double pesos = 0.29;
//      double valor=0.0;
//        for (double i = 0.1; i < 1000; i++) {
//      
//            valor = valor+i;
//      
////      System.out.println("Número : "+big);
//        }
     
//   // pueba si funca el join fech 
//       Comprobante c = new ComprobanteDaoImp().getComprobante(31);
//       System.out.println(c.getTipocomprobante().getReferencia());
//       System.out.println(c.getNumeroSerie());
//       System.out.println(c.getFecha());
//       System.out.println(c.getTipocomprobante().getFormulario());
//       System.out.println(c.getTipocomprobante().getCodigo());
//       System.out.println("----comprobantes----");
//       System.out.println("----comprobantesConcepto----");
//      
//        Set<Comprobanteconcepto>conjunto =  c.getComprobanteconceptos();
//           for (Iterator<Comprobanteconcepto> it = conjunto.iterator(); it.hasNext();) {
//            Comprobanteconcepto comprobanteconcepto = it.next();
//                   System.out.println(comprobanteconcepto.getMonto());
//                   System.out.println(comprobanteconcepto.getConcepto());
//                   System.out.println(comprobanteconcepto.getConcepto().getDescripcion());
//                   
//        }
 
        }
    
    
    
   
}
