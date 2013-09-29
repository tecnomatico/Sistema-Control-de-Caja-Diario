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
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.util.MyUtil;
import co.tecnomati.java.controlcaja.util.NumberToLetterConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author joel
 */
public class ModeloReciboJRDataSource implements JRDataSource {

    //indice para recorrer la lista de comprobante
    int index = -1;
    //comprobante que tendra la lista
    Comprobante comprobante;
    //lista de comprobanates que es pasado desde el guicomprobante
    List<Comprobante> listaComprobante = new ArrayList<>();
    
//    datos de la cooperativa
//    Cooperativa coop = new CooperativaDaoImp().listarCooperativa().get(0);
    
    Concepto concepto;
    private Double monto = 0.0;


    
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
        Tipocomprobante tipoComprobante = new ComprobanteDaoImp().getTipocomprobante(comprobante.getId());
        Set<Comprobanteconcepto> conjuntoConceptos = new ComprobanteDaoImp().listarConcepto(comprobante.getId());

        if ("nrorecibo".equals(jrf.getName())) {

            valor = comprobante.getNumeroSerie();
        }

         else if ("nroRecibo".equals(jrf.getName())) {


                valor = listaComprobante.get(index).getNumeroSerie();

            } else if ("cantidadPago".equals(jrf.getName())) {
                Comprobanteconcepto comprobanteconcepto = null;
                for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
                    comprobanteconcepto = it.next();
                }
                monto = comprobanteconcepto.getMonto();
                valor = NumberToLetterConverter.getConvertirPesosEnString(monto);
            } else if ("conceptoDe".equals(jrf.getName())) {
                Comprobanteconcepto comprobanteconcepto2 = null;
                for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
                    comprobanteconcepto2 = it.next();
                }
                valor = comprobanteconcepto2.getConcepto().getDescripcion();
            } else if ("sonPesos".equals(jrf.getName())) {
                // Dato constante para la configuarcion
                valor = monto;
            } else if ("fechaPago".equals(jrf.getName())) {

                valor = MyUtil.getFechaString10DDMMAAAA(comprobante.getFecha());
            } else if ("matricula".equals(jrf.getName())) {
//            valor = coop.getMatricula();
            }

        
        return valor;
    }

    public void addCertificado(Comprobante c) {
        this.comprobante = c;
    }

    public void setListCertificado(List<Comprobante> l) {
        this.listaComprobante = l;
    }
}
