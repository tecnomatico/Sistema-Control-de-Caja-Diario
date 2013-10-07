/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Categoriacomprobante;
import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CategoriaComprobanteDaoImp;
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
        recibo.setCategoriacomprobante(categoria);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

        recibo = new Tipocomprobante();
        recibo.setCodigo(Constantes.CODIGO_RECIBO_DISTRIBUCION_EXCEDENTE);
        recibo.setFormulario(Constantes.RECIBO_DISTRIBUCION_EXCEDENTE);
        recibo.setReferencia(Constantes.REF_RECIBO_DISTRIBUCION_EXCEDENTE);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        recibo.setCategoriacomprobante(categoria);

        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

        recibo = new Tipocomprobante();
        recibo.setCodigo(Constantes.CODIGO_RECIBO_INTEGRACION_CUOTA);
        recibo.setFormulario(Constantes.RECIBO_INTEGRACION_CUOTA);
        recibo.setReferencia(Constantes.REF_RECIBO_INTEGRACION_CUOTA);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        recibo.setCategoriacomprobante(categoria);

        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

        recibo = new Tipocomprobante();
        recibo.setCodigo(Constantes.CODIGO_RECIBO_ANTICIPO_RETORNO);
        recibo.setFormulario(Constantes.RECIBO_ANTICIPO_RETORNO);
        recibo.setReferencia(Constantes.REF_RECIBO_ANTICIPO_RETORNO);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        recibo.setCategoriacomprobante(categoria);

        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

        recibo = new Tipocomprobante();
        recibo.setCodigo(Constantes.CODIGO_RECIBO_REEMBOLSO_CUOTA_SOCIALES);
        recibo.setFormulario(Constantes.RECIBO_REEMBOLSO_CUOTA_SOCIAL);
        recibo.setReferencia(Constantes.REF_RECIBO_REEMBOLSO_CUOTA_SOCIAL);
        recibo.setNumeroSerieIzq(numI);
        recibo.setNumeroSerieDer(numD);
        recibo.setCategoriacomprobante(categoria);

        new TipoComprobanteDaoImp().addTipoFormulario(recibo);

    }
    
    public static void CrearCooperativayAsociado(){
        Cooperativa coop = new Cooperativa();
        long cuit = 12345;
        coop.setCuit(cuit);
        coop.setDomicilio("Pandora Inc");
        coop.setIngresoBruto("aaa");
        coop.setInicioActividad(new Date());
        coop.setInicioCaja(0.0);
        coop.setMatricula(345);
        coop.setRazonSocial("Tecnomatica Lda");
        coop.setTelefono("154729680");
        new CooperativaDaoImp().addCooperativa(coop);
        
        // agregar asociadoss
        Asociado a = new Asociado();
       
        a.setApellido("Pelaez");
        a.setCooperativa(coop);
        a.setCuit(cuit+76);
        a.setDni(32369235);
        a.setIngreso(new Date());
        a.setLegajo(1);
        a.setNombre("Joel Alfredo Ismael");
        a.setTelefono("154729680");
        new AsociadoDaoImp().addAsociado(a);

        a.setApellido("Aramayo");
        a.setCooperativa(coop);
        a.setCuit(cuit+87);
        a.setDni(32369235);
        a.setIngreso(new Date());
        a.setLegajo(4);
        a.setNombre("Anahi");
        a.setTelefono("154729680");
        new AsociadoDaoImp().addAsociado(a);
        
        a.setApellido("Portal");
        a.setCooperativa(coop);
        a.setCuit(cuit+9);
        a.setDni(32369235);
        a.setIngreso(new Date());
        a.setLegajo(2);
        a.setNombre("Tormenta de Facha");
        a.setTelefono("154729680");
        
        new AsociadoDaoImp().addAsociado(a);
        a.setApellido("Risco");
        a.setCooperativa(coop);
        a.setCuit(cuit+1);
        a.setDni(32369235);
        a.setIngreso(new Date());
        a.setLegajo(3);
        a.setNombre("Carlo");
        a.setTelefono("154729680");
        new AsociadoDaoImp().addAsociado(a);
    }
}
