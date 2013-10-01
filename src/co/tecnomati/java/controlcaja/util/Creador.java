/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.TipoComprobanteDaoImp;

/**
 *
 * @author joel
 */
public class Creador {
    public static void CrearRecibos(){
       Tipocomprobante recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_PAGO);
       recibo.setFormulario(Constantes.RECIBO_PAGO);
       recibo.setReferencia(Constantes.REF_RECIBO_PAGO);
       new TipoComprobanteDaoImp().addTipoFormulario(recibo);

       recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_DISTRIBUCION_EXCEDENTE);
       recibo.setFormulario(Constantes.RECIBO_DISTRIBUCION_EXCEDENTE);
       recibo.setReferencia(Constantes.REF_RECIBO_DISTRIBUCION_EXCEDENTE);
       new TipoComprobanteDaoImp().addTipoFormulario(recibo);
       
       recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_INTEGRACION_CUOTA);
       recibo.setFormulario(Constantes.RECIBO_INTEGRACION_CUOTA);
       recibo.setReferencia(Constantes.REF_RECIBO_INTEGRACION_CUOTA);
       new TipoComprobanteDaoImp().addTipoFormulario(recibo);
       
       recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_ANTICIPO_RETORNO);
       recibo.setFormulario(Constantes.RECIBO_ANTICIPO_RETORNO);
       recibo.setReferencia(Constantes.REF_RECIBO_ANTICIPO_RETORNO);
       new TipoComprobanteDaoImp().addTipoFormulario(recibo);
       
       recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_REEMBOLSO_CUOTA_SOCIALES);
       recibo.setFormulario(Constantes.RECIBO_REEMBOLSO_CUOTA_SOCIAL);
       recibo.setReferencia(Constantes.REF_RECIBO_REEMBOLSO_CUOTA_SOCIAL);
       new TipoComprobanteDaoImp().addTipoFormulario(recibo);
       
    }
}
