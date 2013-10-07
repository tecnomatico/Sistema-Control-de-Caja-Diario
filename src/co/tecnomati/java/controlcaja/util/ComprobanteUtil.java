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

    public static long incrementarNumSerieIzq(long numI) {
        if (numI == 9999) {
            // error no hay mas lugar 
            numI = 0000;
        } else {
            numI = numI + 1;
        }
        return numI;
    }

    /**
     * Incrementa el numero de seriie de un recibo automatico
     *
     * @param numI numeracion izquierda del numero de serie
     * @param numD numeracion derecha del numero de serie
     * @return
     */
    public static boolean isLLenoPosicionDer(long numD) {
        boolean b = false;
        if (numD == 999999999) {
            b = true;
        }
        return b;
    }

    public static long incrementarNumSerieDer(long numD) {

        if (isLLenoPosicionDer(numD)) {
            numD = 00000000;

        } else {
            numD = numD + 1;
        }
        return numD;
    }

    /**
     * 
     * @param numI numero de serie  en formato long
     * @param cantDig cantidad de digitos que debe tener el formato 
     * @param caracter  caracter de relleno para completar la cantidad que debe tner el formtato
     * @return Rellena  a la izquierda con caracteres caracter  para completar la cantidad de digitos cantDig  para el formtato en particular
     */
    public static String RellenarConCaracteresAlaIzquierda(long numI,int cantDig,char caracter){
        String numero = String.valueOf(numI);
        int cont= numero.length()+1;
        for (int i = cont; i <= cantDig; i++) {
            numero = caracter+numero ;
        }
               return numero;
    }
    
    /**
     * 
     * @param numI numero de serie de la parte izquierda 
     * @return 
     */
    public static String formatearNumSerieIzq(long numI) {
        
      String numero =  RellenarConCaracteresAlaIzquierda(numI,4, '0');
        
               return numero;

    }

    /**
     * 
     * @param numD numero de serie de la columna Derecha 
     * 
     * @return el numero de serie en formato XXXXXXXX de 8 digitos en String
     */
    
    public static String formatearNumSerieDer(long numD) {
        
      String numero =  RellenarConCaracteresAlaIzquierda(numD,8, '0');
        
               return numero;
    }
}
