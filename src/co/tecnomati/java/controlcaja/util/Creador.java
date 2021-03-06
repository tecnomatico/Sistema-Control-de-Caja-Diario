/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Categoriacomprobante;
import co.tecnomati.java.controlcaja.dominio.Concepto;
import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CategoriaComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ConceptoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.TipoComprobanteDaoImp;
import java.util.Date;

/**
 *
 * @author joel
 */
public class Creador {

    public static void CrearCategoriaComprobanteYRecibos() {
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
    public static void CrearRecibos(Categoriacomprobante categoria) {
        // inicializo el numero de serie parte izquierda y la parte derecha
        long numI = 0000;
        long numD = 0000000000;
        
        Tipocomprobante recibo = new Tipocomprobante();
        recibo.setCodigo(Constantes.CODIGO_RECIBO_PAGO);
        recibo.setFormulario(Constantes.RECIBO_PAGO);
        recibo.setReferencia(Constantes.REF_RECIBO_PAGO);
        recibo.setOperacion(Constantes.OP_SALIDA);
        recibo.setCategoriacomprobante(categoria);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

        recibo = new Tipocomprobante();
        recibo.setCodigo(Constantes.CODIGO_RECIBO_DISTRIBUCION_EXCEDENTE);
        recibo.setFormulario(Constantes.RECIBO_DISTRIBUCION_EXCEDENTE);
        recibo.setReferencia(Constantes.REF_RECIBO_DISTRIBUCION_EXCEDENTE);
        recibo.setOperacion(Constantes.OP_SALIDA);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        recibo.setCategoriacomprobante(categoria);

        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

        recibo = new Tipocomprobante();
        recibo.setCodigo(Constantes.CODIGO_RECIBO_INTEGRACION_CUOTA);
        recibo.setFormulario(Constantes.RECIBO_INTEGRACION_CUOTA);
        recibo.setReferencia(Constantes.REF_RECIBO_INTEGRACION_CUOTA);
        recibo.setOperacion(Constantes.OP_ENTRADA);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        recibo.setCategoriacomprobante(categoria);

        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

        recibo = new Tipocomprobante();
        recibo.setCodigo(Constantes.CODIGO_RECIBO_ANTICIPO_RETORNO);
        recibo.setFormulario(Constantes.RECIBO_ANTICIPO_RETORNO);
        recibo.setReferencia(Constantes.REF_RECIBO_ANTICIPO_RETORNO);
        recibo.setOperacion(Constantes.OP_SALIDA);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        recibo.setCategoriacomprobante(categoria);

        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

        recibo = new Tipocomprobante();
        recibo.setCodigo(Constantes.CODIGO_RECIBO_REEMBOLSO_CUOTA_SOCIALES);
        recibo.setFormulario(Constantes.RECIBO_REEMBOLSO_CUOTA_SOCIAL);
        recibo.setReferencia(Constantes.REF_RECIBO_REEMBOLSO_CUOTA_SOCIAL);
        recibo.setOperacion(Constantes.OP_SALIDA);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        recibo.setCategoriacomprobante(categoria);

        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

    }
    /**
     * Crea conceptos que deben estar obligariamente en la bd
     */
    public static void crearConceptos(){
        Concepto concepto = new Concepto();
        concepto.setCodigoConcepto(Constantes.CONCEPTO_CODIGO_ANTICIPO_RETORNO);
        concepto.setDescripcion(Constantes.CONCEPTO_DESCRIPCION_ANTICIPO_RETORNO);
        new ConceptoDaoImp().addConcepto(concepto);
        
        concepto = new Concepto();
        concepto.setCodigoConcepto(Constantes.CONCEPTO_CODIGO_DISTRIBUCION_EXCEDENTE);
        concepto.setDescripcion(Constantes.CONCEPTO_DESCRIPCION_DISTRIBUCION_EXCEDENTE);
        new ConceptoDaoImp().addConcepto(concepto);
        
        concepto = new Concepto();
        concepto.setCodigoConcepto(Constantes.CONCEPTO_CODIGO_INTEGRACION_CUOTA);
        concepto.setDescripcion(Constantes.CONCEPTO_DESCRIPCION_INTEGRACION_CUOTA);
        new ConceptoDaoImp().addConcepto(concepto);
        
        concepto = new Concepto();
        concepto.setCodigoConcepto(Constantes.CONCEPTO_CODIGO_REEMBOLSO_CUOTA_SOCIAL);
        concepto.setDescripcion(Constantes.CONCEPTO_DESCRIPCION_REEMBOLSO_CUOTA_SOCIAL);
        new ConceptoDaoImp().addConcepto(concepto);
        
        concepto = new Concepto();
        concepto.setCodigoConcepto(Constantes.CONCEPTO_CODIGO_MONOTRIBUTO);
        concepto.setDescripcion(Constantes.CONCEPTO_DESCRIPCION_MONOTRIBUTO);
        new ConceptoDaoImp().addConcepto(concepto);
    }
    public static void CrearCooperativayAsociado(){
        Cooperativa coop = new Cooperativa();
        String cuit = "30-71417115-8";
        coop.setCuit(cuit);
        coop.setDomicilio("Av. Rio Bamba Nº 144 – Cnel. Arias – S.S. de Jujuy");
        coop.setIngresoBruto("A-1-51004");
        coop.setInicioActividad(new Date(2013-1900,7,1));
        coop.setInicioCaja(0.0);
        coop.setMatricula(47735);
        coop.setRazonSocial("Coop. de Trabajo Tecnomatica Lda");
        coop.setTelefono("154729680");
        new CooperativaDaoImp().addCooperativa(coop);
        
        // agregar asociadoss
        Asociado a = new Asociado();
       
        a.setApellido("Pelaez");
        a.setCooperativa(coop);
        a.setCuit("20-32369235-2");
        a.setDni(32369235);
        a.setIngreso(new Date(2012-1900,9,1));
        a.setLegajo(1);
        a.setNombre("Joel Alfredo Ismael");
        a.setTelefono("388-154729680");
        new AsociadoDaoImp().addAsociado(a);

        a.setApellido("Aramayo");
        a.setCooperativa(coop);
        a.setCuit("22-34576227-9");
        a.setDni(32369235);
        a.setIngreso(new Date());
        a.setLegajo(4);
        a.setNombre("Anahi");
        a.setTelefono("154729680");
        new AsociadoDaoImp().addAsociado(a);
        
        a.setApellido("Portal");
        a.setCooperativa(coop);
        a.setCuit("22-34576587-4");
        a.setDni(32369235);
        a.setIngreso(new Date());
        a.setLegajo(2);
        a.setNombre("Tormenta de Facha");
        a.setTelefono("154729680");
        
        new AsociadoDaoImp().addAsociado(a);
        a.setApellido("Risco");
        a.setCooperativa(coop);
        a.setCuit("22-31276487-3");
        a.setDni(32369235);
        a.setIngreso(new Date());
        a.setLegajo(3);
        a.setNombre("Carlo");
        a.setTelefono("154729680");
        new AsociadoDaoImp().addAsociado(a);
    }
}
