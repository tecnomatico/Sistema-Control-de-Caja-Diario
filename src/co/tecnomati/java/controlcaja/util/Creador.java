/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Categoriacomprobante;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CategoriaComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.TipoComprobanteDaoImp;

/**
 *
 * @author joel
 */
public class Creador {
    
    
    public static void CrearCategoriaComprobanteYRecibos(){
        Categoriacomprobante categoria = new Categoriacomprobante();
        categoria.setDescripcion(Constantes.CATEGORIA_BOLETA);
        new CategoriaComprobanteDaoImp().addCategoriacomprobante(categoria);
        
        categoria = new Categoriacomprobante();
        categoria.setDescripcion(Constantes.CATEGORIA_CHEQUE);
        new CategoriaComprobanteDaoImp().addCategoriacomprobante(categoria);
        
        categoria = new Categoriacomprobante();
        categoria.setDescripcion(Constantes.CATEGORIA_FACTURA);
        new CategoriaComprobanteDaoImp().addCategoriacomprobante(categoria);

        categoria = new Categoriacomprobante();
        categoria.setDescripcion(Constantes.CATEGORIA_RECIBO);
        new CategoriaComprobanteDaoImp().addCategoriacomprobante(categoria);
        CrearRecibos(categoria);
        
    }
    
    /**
     * Crea los tipos de recibos que se tienen que imprimir de forma automatica
     */
      public static void CrearRecibos(Categoriacomprobante categoria){
       Tipocomprobante recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_PAGO);
       recibo.setFormulario(Constantes.RECIBO_PAGO);
       recibo.setReferencia(Constantes.REF_RECIBO_PAGO);
       recibo.setCategoriacomprobante(categoria);
       
       new TipoComprobanteDaoImp().addTipoFormulario(recibo);

       recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_DISTRIBUCION_EXCEDENTE);
       recibo.setFormulario(Constantes.RECIBO_DISTRIBUCION_EXCEDENTE);
       recibo.setReferencia(Constantes.REF_RECIBO_DISTRIBUCION_EXCEDENTE);
              recibo.setCategoriacomprobante(categoria);

       new TipoComprobanteDaoImp().addTipoFormulario(recibo);
       
       recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_INTEGRACION_CUOTA);
       recibo.setFormulario(Constantes.RECIBO_INTEGRACION_CUOTA);
       recibo.setReferencia(Constantes.REF_RECIBO_INTEGRACION_CUOTA);
              recibo.setCategoriacomprobante(categoria);

       new TipoComprobanteDaoImp().addTipoFormulario(recibo);
       
       recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_ANTICIPO_RETORNO);
       recibo.setFormulario(Constantes.RECIBO_ANTICIPO_RETORNO);
       recibo.setReferencia(Constantes.REF_RECIBO_ANTICIPO_RETORNO);
              recibo.setCategoriacomprobante(categoria);

       new TipoComprobanteDaoImp().addTipoFormulario(recibo);
       
       recibo = new Tipocomprobante();
       recibo.setCodigo(Constantes.CODIGO_RECIBO_REEMBOLSO_CUOTA_SOCIALES);
       recibo.setFormulario(Constantes.RECIBO_REEMBOLSO_CUOTA_SOCIAL);
       recibo.setReferencia(Constantes.REF_RECIBO_REEMBOLSO_CUOTA_SOCIAL);
              recibo.setCategoriacomprobante(categoria);

       new TipoComprobanteDaoImp().addTipoFormulario(recibo);
       
    }
    
    
}
