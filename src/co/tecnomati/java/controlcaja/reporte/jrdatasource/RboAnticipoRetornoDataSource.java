/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.reporte.jrdatasource;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Concepto;
import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.util.ComprobanteUtil;
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
 * @author dario Asociado OK
 */
public class RboAnticipoRetornoDataSource implements JRDataSource {
    //indice para recorrer la lista de comprobante

    int index = -1;
    //comprobante que tendra la lista
    Comprobante comprobante;
    //lista de comprobanates que es pasado desde el guicomprobante
    List<Comprobante> listaComprobante = new ArrayList<>();
//    datos de la cooperativa
    Cooperativa coop = new CooperativaDaoImp().listarCooperativa().get(0);
    Concepto concepto;
//    private Double monto = 0.0;
    // corresponde a este comprobante
    Comprobanteconcepto comprobanteconcepto1, comprobanteconcepto2;
    Asociado asociado;
    private double neto;

    /**
     * setea comprobanteconcepto1 y comprobanteconcepto2 con los datos que tiene
     * comprobante
     *
     * @param conjuntoConceptos conjunto de comprobantes concetos que
     * representan los detalles del comprobante
     *
     */
    private void setearComprobantesConceptos(Set<Comprobanteconcepto> conjuntoConceptos) {
        for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
            Comprobanteconcepto comprobanteconcepto = it.next();
            neto = comprobanteconcepto.getMonto() + neto;
            if (comprobanteconcepto.getConcepto().getCodigoConcepto() != Constantes.CONCEPTO_CODIGO_MONOTRIBUTO) {
                //detalle 1 o concepto 1

                comprobanteconcepto1 = comprobanteconcepto;

                System.out.println("codigo monotributo concepto1");
            } else {
                // detalle o concepto 2  monotributo

                comprobanteconcepto2 = comprobanteconcepto;
                System.out.println("codigo monotributo concepto2" );

            }
        }



    }


    @Override
    public boolean next() throws JRException {
        boolean b = false;
        ++index;
        if (index < listaComprobante.size()) {
            b = true;
            comprobante = listaComprobante.get(index);
            setearComprobantesConceptos(comprobante.getComprobanteconceptos());
            Tipocomprobante tipoComprobante = comprobante.getTipocomprobante();
            asociado = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
            
        }
        return b;

    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

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
//            valor = "("+new Numero_a_Letra().Convertir(String.valueOf(monto).toLowerCase(), true)+ ")";
//                valor = NumberToLetterConverter.getConvertirPesosEnString(monto);
        } else if ("conceptoDe".equals(jrf.getName())) {
            valor = comprobanteconcepto1.getConcepto().getDescripcion();
        } else if ("sonPesos".equals(jrf.getName())) {
            // Dato constante para la configuarcion
            valor = "(" + new Numero_a_Letra().Convertir(String.valueOf(neto), true) + ")";
        } else if ("fechaPago".equals(jrf.getName())) {

            valor = MyUtil.getFechaString10DDMMAAAA(comprobante.getFecha());
        } else if ("lugarPago".equals(jrf.getName())) {

            valor = coop.getDomicilio();
        } // datos del asociado
        else if ("nombreApellido".equals(jrf.getName())) {

            valor = asociado.getApellido() + asociado.getNombre();
        } else if ("nroAsociado".equals(jrf.getName())) {

            valor = asociado.getLegajo();
        } else if ("nroDNI".equals(jrf.getName())) {

            valor = asociado.getDni();
        } else if ("cuitAsociado".equals(jrf.getName())) {

            valor = asociado.getCuit();
        } else if ("fechaIngreso".equals(jrf.getName())) {

            valor = MyUtil.getFechaString10DDMMAAAA(asociado.getIngreso());
        } // ejercicio economico que esta en comprobante
        else if ("ejercicioEconomico".equals(jrf.getName())) {

            valor = "FALTA";
        } else if ("periodoFecha".equals(jrf.getName())) {

            valor = "FALTA";
        } // concepto1
        else if ("concepto1".equals(jrf.getName())) {

            valor = comprobanteconcepto1.getConcepto().getDescripcion();
        } else if ("importe1".equals(jrf.getName())) {

            valor = comprobanteconcepto1.getMonto();
        } //conectpo monotributo
        else if ("concepto2".equals(jrf.getName()) && comprobanteconcepto2 != null) {

            valor = comprobanteconcepto2.getConcepto().getDescripcion();
        } else if ("importe2".equals(jrf.getName()) && comprobanteconcepto2 != null) {

            valor = "";
        } else if ("descuento2".equals(jrf.getName()) && comprobanteconcepto2 != null) {

            valor = ((-1)*comprobanteconcepto2.getMonto());
        } else if ("totalImporte".equals(jrf.getName())) {
            // total de los importes  que en este caso es solo es 1 , si hay mas habra que reemplazar esto
            valor = comprobanteconcepto1.getMonto();
        } else if ("neto".equals(jrf.getName())) {
            // ingreso - egreso
            valor = neto;
        }


        return valor;
    }

    public void addComprobante(Comprobante c) {
        this.comprobante = c;
    }

    public void setListComprobante(List<Comprobante> c) {
        this.listaComprobante = c;
    }
}
