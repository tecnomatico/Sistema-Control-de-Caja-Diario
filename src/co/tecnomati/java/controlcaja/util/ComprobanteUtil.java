/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import co.tecnomati.java.controlcaja.cons.Constantes;

/**
 *
 * @author joel
 */
public class ComprobanteUtil {

   /**
    * 
    * @param codTipoCompr codigo del tipo de comprobante 
    * @return true si el recibo se usa para asociado exclusivamente
    */
    public static boolean isReciboParaAsociado(int codTipoCompr) {
        boolean b = false;
        if (codTipoCompr == Constantes.CODIGO_RECIBO_ANTICIPO_RETORNO || codTipoCompr == Constantes.CODIGO_RECIBO_DISTRIBUCION_EXCEDENTE || codTipoCompr == Constantes.CODIGO_RECIBO_REEMBOLSO_CUOTA_SOCIALES) {
            b = true;

        }
        return b;
    }
    
    public static long incrementarNumSerieIzq(long numI){
        if (numI==9999) {
            // error no hay mas lugar 
            numI=0000;
        } else {
            numI =numI+1;
        }
        return numI;
    }
    /**
     * Incrementa el numero de seriie  de un recibo automatico 
     * @param numI  numeracion izquierda del numero de serie
     * @param numD  numeracion derecha del numero de serie
     * @return 
     */
    public static boolean isLLenoPosicionDer(long numD){
        boolean b = false;
        if(numD==999999999){
                b= true;
        }
        return b;
    }
    public static long incrementarNumSerieDer(long numD){
        
        if(isLLenoPosicionDer(numD)){
            numD= 00000000;
            
        }else{
            numD = numD + 1;
        }   
        return numD;
    }
}
