/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.reporte.jrdatasource;

import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.util.MyUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author dario
 */
public class RboDistribucionExcedentesDataSource implements JRDataSource {

    int index = -1;
    List<Comprobante> listaComprobantes = new ArrayList<Comprobante>();
    Comprobante comprobante;
    Set<Comprobanteconcepto> conjuntoConceptos;

    @Override
    public boolean next() throws JRException {
        return ++index < listaComprobantes.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        comprobante = listaComprobantes.get(index);

        Tipocomprobante tipoComprobante = comprobante.getTipocomprobante();
//        Tipocomprobante tipoComprobante = new ComprobanteDaoImp().getTipocomprobante(comprobante.getId());
        Set<Comprobanteconcepto> conjuntoConceptos = comprobante.getComprobanteconceptos();//Obtengo el conjunto de ComprobanteConceptos vinculados al Comprobante
//        Set<Comprobanteconcepto> conjuntoConceptos = new ComprobanteDaoImp().listarConcepto(comprobante.getId());//Obtengo el conjunto de ComprobanteConceptos vinculados al Comprobante

        Cooperativa cooperativa = new CooperativaDaoImp().listarCooperativa().get(0);
     
         Asociado a = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
//        Entidad entidad = new Entidad();
//
//        switch (comprobante.getTipoPersona()) {
//            case Constantes.ASOCIADO_INT:
//                Asociado a = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
//                entidad.setNombre(a.getApellido() + " " + a.getNombre());
//                entidad.setFechaIngreso(a.getIngreso());
//                entidad.setCuit(a.getCuit());
//                entidad.setDni(a.getDni());
//                entidad.setId(a.getLegajo());
//                
//                break;
//            case Constantes.PROVEEDOR_INT:
//                Proveedor p = new ProveedorDaoImp().getProveedor(comprobante.getIdEntidad());
//                entidad.setNombre(p.getRazonSocial());
//                entidad.setCuit(p.getCuit());
//                break;
//            case Constantes.CLIENTE_INT:
//                Cliente c = new ClienteDaoImp().getCliente(comprobante.getIdEntidad());
//                entidad.setNombre(c.getRazonSocial());
//                entidad.setCuit(c.getCuit());
//                break;
//        }

        List<Comprobanteconcepto> listaComprobanteConcepto = new ArrayList();
//        conjuntoConceptos = new ComprobanteDaoImp().listarConcepto(comprobante.getId());
        conjuntoConceptos = comprobante.getComprobanteconceptos();
        for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
            Comprobanteconcepto comprobante1 = it.next();
            listaComprobanteConcepto.add(comprobante1);
        }

        if ("nroRecibo".equals(jrf.getName())) {
            valor = comprobante.getNumeroSerie();
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
        } else if ("nombreApellido".equals(jrf.getName())) {
            valor = valor= a.getApellido()+" "+a.getNombre();
        } else if ("nroAsociado".equals(jrf.getName())) {
            valor = valor= a.getLegajo();
        } else if ("fechaIngreso".equals(jrf.getName())) {
            valor = valor= MyUtil.getFechaString10DDMMAAAA(a.getIngreso());
        } else if ("nroDNI".equals(jrf.getName())) {
            valor =  valor= a.getDni();
        } else if ("cuitAsociado".equals(jrf.getName())) {
            valor= a.getCuit();
        } else if ("ejercicioEconomico".equals(jrf.getName())) {
            valor = comprobante.getEjercicioEconomico();
        } //        else if("nroDNI".equals(jrf.getName())){
        //            valor = entidad.getDni();
        //        }
        //        else if("nroDNI".equals(jrf.getName())){
        //            valor = entidad.getDni();
        //        }
        else if ("lugarPago".equals(jrf.getName())) {
            valor = cooperativa.getDomicilio();
        } else if ("fechaPago".equals(jrf.getName())) {
            valor = MyUtil.getFechaString10DDMMAAAA(comprobante.getFecha());
        }
         else if ("inicioActividad".equals(jrf.getName())) {
            valor = MyUtil.getFechaString10DDMMAAAA(cooperativa.getInicioActividad());
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
