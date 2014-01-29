/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.reporte.jrdatasource;

import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Concepto;
import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.util.ComprobanteUtil;
import co.tecnomati.java.controlcaja.util.Entidad;
import co.tecnomati.java.controlcaja.util.MyUtil;
import co.tecnomati.java.controlcaja.util.Numero_a_Letra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author joel OK
 */
public class ModeloReciboJRDataSource implements JRDataSource {

    //indice para recorrer la lista de comprobante
    int index = -1;
    //comprobante que tendra la lista
    Comprobante comprobante;
    //lista de comprobanates que es pasado desde el guicomprobante
    List<Comprobante> listaComprobante = new ArrayList<>();
//    datos de la cooperativa
    Cooperativa coop = new CooperativaDaoImp().listarCooperativa().get(0);
    Concepto concepto;
    private Double monto = 0.0;
    Comprobanteconcepto comprobanteconcepto1;

    /**
     * Carga en comprobante concepto el contenido del conjunto de
     * comprobanteconcepto de comprobante
     *
     * @param conjuntoConceptos
     */
    private void setComprobanteConcepto1(Set<Comprobanteconcepto> conjuntoConceptos) {
        for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
            Comprobanteconcepto comprobanteconcepto = it.next();
            comprobanteconcepto1 = comprobanteconcepto;
        }

    }

    //metodo ue recorre la lista de comprobantes mientras el indice sea menor que el tamaño de la lista
    @Override
    public boolean next() throws JRException {
        return ++index < listaComprobante.size();
    }

    //metodo que conecta una variable de nuestro  reporte ireport con un valor que le pasemos 
    // este metodo va consultando por determinado field  y asignando para ese field un valor (que lo sacamos del comprobnate)
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        comprobante = listaComprobante.get(index);
        // obtengo la entida del comprobante
        Entidad entidad = new Entidad(comprobante);
        Tipocomprobante tipoComprobante = comprobante.getTipocomprobante();
        Set<Comprobanteconcepto> conjuntoConceptos = comprobante.getComprobanteconceptos();
        System.out.println("tamaño del conjunto de conceppto "+ conjuntoConceptos.size());
        setComprobanteConcepto1(conjuntoConceptos);
        monto = comprobanteconcepto1.getMonto();


        if ("nroRecibo".equals(jrf.getName())) {
            valor = ComprobanteUtil.formatearNumSerieIzq(comprobante.getNumeroSerieIzq()) + "-" + ComprobanteUtil.formatearNumSerieDer(comprobante.getNumeroSerieDer());
        } else if ("matriculaInaes".equals(jrf.getName())) {
            valor = coop.getMatricula();
        } else if ("inicioActividades".equals(jrf.getName())) {
            valor = MyUtil.getFechaString10DDMMAAAA(coop.getInicioActividad());
        } else if ("cuitCooperativa".equals(jrf.getName())) {
            valor = coop.getCuit();
        } else if ("ingresosBrutos".equals(jrf.getName())) {
            valor = coop.getIngresoBruto();
        } else if ("domicilioCooperativa".equals(jrf.getName())) {
            valor = coop.getDomicilio();
        } else if ("cantidadPago".equals(jrf.getName())) {
            valor = "(" + new Numero_a_Letra().Convertir(String.valueOf(monto), true) + ")";
//                valor = NumberToLetterConverter.getConvertirPesosEnString(monto);
        } else if ("conceptoDe".equals(jrf.getName())) {

            valor = comprobanteconcepto1.getConcepto().getDescripcion();
        } else if ("sonPesos".equals(jrf.getName())) {
            // Dato constante para la configuarcion
            valor = monto;
        } else if ("fechaPago".equals(jrf.getName())) {

            valor = MyUtil.getFechaString10DDMMAAAA(comprobante.getFecha());
        } else if ("lugarPago".equals(jrf.getName())) {

            valor = coop.getDomicilio();
        } // aqui va quien firma el recibo Tesorero o quien?
        else if ("nombreApellido".equals(jrf.getName())) {

            valor = entidad.getNombre();
        } else if ("nroDNI".equals(jrf.getName())) {

            valor = entidad.getDni();
        }


        return valor;
    }

    public void setListComprobante(List<Comprobante> l) {
        this.listaComprobante = l;
    }
}
