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
}
