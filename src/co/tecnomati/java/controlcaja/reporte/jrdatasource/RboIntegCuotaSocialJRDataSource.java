/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.reporte.jrdatasource;

import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.util.List;
import java.util.Iterator;
import java.util.Set;

import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.util.ComprobanteUtil;
import co.tecnomati.java.controlcaja.util.MyUtil;
import co.tecnomati.java.controlcaja.util.Numero_a_Letra;

/**
 *
 * @author AnahiAramayo
 */
public class RboIntegCuotaSocialJRDataSource implements JRDataSource {

    int index = -1;
    List<Comprobante> listaComprobantes = new ArrayList<Comprobante>();
    Comprobante comprobante;
    Set<Comprobanteconcepto> conjuntoConceptos;
    private Comprobanteconcepto comprobanteconcepto1;
    private Double monto;
    private Tipocomprobante tipoComprobante;
    private Cooperativa cooperativa;
    private Asociado a;

    private void setComprobanteConcepto1(Set<Comprobanteconcepto> conjuntoConceptos) {
        for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
            Comprobanteconcepto comprobanteconcepto = it.next();
            comprobanteconcepto1 = comprobanteconcepto;
        }
    }

    @Override
    public boolean next() throws JRException {
        boolean b = false;
        ++index;
        if (index < listaComprobantes.size()) {
            b = true;
            comprobante = listaComprobantes.get(index);

            tipoComprobante = comprobante.getTipocomprobante();
            setComprobanteConcepto1(comprobante.getComprobanteconceptos());
            monto = comprobanteconcepto1.getMonto();
            cooperativa = new CooperativaDaoImp().listarCooperativa().get(0);
            a = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
        }
        return b;
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;


        if ("nroRecibo".equals(jrf.getName())) {
            valor = ComprobanteUtil.formatearNumSerieIzq(comprobante.getNumeroSerieIzq()) + "-" + ComprobanteUtil.formatearNumSerieDer(comprobante.getNumeroSerieDer());
        } else if ("matriculaInaes".equals(jrf.getName())) {
            // Dato constante para la configuarcion
            valor = cooperativa.getMatricula();
        } else if ("cuitCooperativa".equals(jrf.getName())) {
            valor = cooperativa.getCuit();
        } else if ("inicioActividades".equals(jrf.getName())) {
            valor = MyUtil.getFechaString10DDMMAAAA(cooperativa.getInicioActividad());
        } else if ("ingresosBrutos".equals(jrf.getName())) {
            valor = cooperativa.getIngresoBruto();
        } else if ("domicilioCooperativa".equals(jrf.getName())) {
            valor = cooperativa.getDomicilio();
        } // DATOS DEL ASOCIADO
        else if ("nombreApellido".equals(jrf.getName())) {
            valor = valor = a.getApellido() + " " + a.getNombre();
        } else if ("nroAsociado".equals(jrf.getName())) {
            valor = valor = a.getLegajo();
        } else if ("fechaIngreso".equals(jrf.getName())) {
            valor = valor = MyUtil.getFechaString10DDMMAAAA(a.getIngreso());
        } else if ("nroDNI".equals(jrf.getName())) {
            valor = valor = a.getDni();
        } else if ("cuitAsociado".equals(jrf.getName())) {
            valor = a.getCuit();
        } else if ("cantidadPago".equals(jrf.getName())) {
            valor = valor = "(" + new Numero_a_Letra().Convertir(String.valueOf(monto), true) + ")";
        } else if ("lugarPago".equals(jrf.getName())) {
            valor = cooperativa.getDomicilio();
        } else if ("fechaPago".equals(jrf.getName())) {
            valor = MyUtil.getFechaString10DDMMAAAA(comprobante.getFecha());
        }


        return valor;
    }

    public void addComprobante(Comprobante c) {
        this.comprobante = c;
    }

    public void setListComprobante(List<Comprobante> c) {
        this.listaComprobantes = c;
    }
}
