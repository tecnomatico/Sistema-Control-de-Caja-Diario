/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.reporte.jrdatasource;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Cliente;
import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.Proveedor;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ClienteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ProveedorDaoImp;
import co.tecnomati.java.controlcaja.util.Entidad;
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
 * @author AnahiAramayo
 */
public class RboReembolsoCuotaSocial implements JRDataSource {

    int index = -1;
    List<Comprobante> listaComprobantes = new ArrayList<Comprobante>();
    Comprobante comprobante;
    Set<Comprobanteconcepto> conjuntoConceptos;
    private Double monto = 0.00;

    @Override
    public boolean next() throws JRException {
        return ++index < listaComprobantes.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        comprobante = listaComprobantes.get(index);

        Tipocomprobante tipoComprobante = new ComprobanteDaoImp().getTipocomprobante(comprobante.getId());
        Set<Comprobanteconcepto> conjuntoConceptos = new ComprobanteDaoImp().listarConcepto(comprobante.getId());//Obtengo el conjunto de ComprobanteConceptos vinculados al Comprobante

        Cooperativa cooperativa = new CooperativaDaoImp().listarCooperativa().get(0);
        Entidad entidad = new Entidad();

        switch (comprobante.getTipoPersona()) {
            case Constantes.ASOCIADO_INT:
                Asociado a = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
                entidad.setNombre(a.getApellido() + " " + a.getNombre());
                entidad.setFechaIngreso(a.getIngreso());
                entidad.setCuit(a.getCuit());
                break;
            /*case Constantes.PROVEEDOR_INT :Proveedor p = new ProveedorDaoImp().getProveedor(comprobante.getIdEntidad());
             entidad.setNombre(p.getRazonSocial());
             entidad.setCuit(p.getCuit());
             break;
             case Constantes.CLIENTE_INT : Cliente c = new ClienteDaoImp().getCliente(comprobante.getIdEntidad());
             entidad.setNombre(c.getRazonSocial());
             entidad.setCuit(c.getCuit());
             break;   */
        }

        List<Comprobanteconcepto> listaComprobanteConcepto = new ArrayList();
        conjuntoConceptos = new ComprobanteDaoImp().listarConcepto(comprobante.getId());
        for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
            Comprobanteconcepto comprobante1 = it.next();
            listaComprobanteConcepto.add(comprobante1);
        }

        if ("nroRecibo".equals(jrf.getName())) {
            valor = comprobante.getNumeroSerie();
        } else if ("cuitCooperativa".equals(jrf.getName())) {
            valor = cooperativa.getCuit();
        } else if ("inicioActividades".equals(jrf.getName())) {
            valor = cooperativa.getInicioActividad();
        } else if ("nombreApellido".equals(jrf.getName())) {
            valor = entidad.getNombre() + " " + entidad.getApellido();
        } else if ("nroAsociado".equals(jrf.getName())) {
            valor = entidad.getId();
        } else if ("fechaIngreso".equals(jrf.getName())) {
            valor = entidad.getFechaIngreso();
        } else if ("nroDNI".equals(jrf.getName())) {
            valor = entidad.getDni();
        } else if ("cuitAsociado".equals(jrf.getName())) {
            valor = entidad.getCuit();
        } else if ("fechaPago".equals(jrf.getName())) {
            valor = comprobante.getFecha();
        } else if ("cantidadPago".equals(jrf.getName())) {
            Comprobanteconcepto comprobanteconcepto = null;
            for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
                comprobanteconcepto = it.next();
            }
            monto = comprobanteconcepto.getMonto();
            valor = NumberToLetterConverter.getConvertirPesosEnString(monto);
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
