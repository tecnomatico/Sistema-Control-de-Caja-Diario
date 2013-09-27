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

import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;

import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Concepto;

import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.util.MyUtil;
import co.tecnomati.java.controlcaja.util.NumberToLetterConverter;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author AnahiAramayo
 */
public class RboIntegCuotaSocialJRDataSource implements JRDataSource
{
List<Comprobante> listacomprobante = new ArrayList<>();
Comprobante cc;
private int index = -1;//actual
Cooperativa c = new CooperativaDaoImp().listarCooperativa().get(0);
 Concepto concepto;
    private Double monto=0.0;
@Override
public Object getFieldValue(JRField jrf) throws JRException
{
        Object valor = null;
      cc = listacomprobante.get(index);
        /*ASOCIADO_INT=0; CLIENTE_INT=1; PROVEEDOR_INT=2;*/
      Tipocomprobante tipoComprobante = new ComprobanteDaoImp().getTipocomprobante(listacomprobante.get(index).getId());
        Set<Comprobanteconcepto> conjuntoConceptos= new ComprobanteDaoImp().listarConcepto(listacomprobante.get(index).getId());

      
        if (cc.getTipoPersona().equals(0)) {
           Asociado asociado = new AsociadoDaoImp().getAsociado(cc.getIdEntidad());
           //Este corresponde al reporte y trae los datos q necesita
                switch (jrf.getName()){
                    case "inicioActividad": valor = c.getInicioActividad();
                    case "nombreApellido": valor = asociado.getApellido()+" "+ asociado.getNombre();
                    case "nro": valor = asociado.getLegajo();
                    case "fechaIngreso": valor = asociado.getIngreso();
                    case "nroDNI": valor = asociado.getDni();
                    case "cuit": valor = asociado.getCuit();
                    case "cantidadPago":    {Comprobanteconcepto comprobanteconcepto=null;
                                        for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
                                            comprobanteconcepto = it.next();
                                        }
                                         monto = comprobanteconcepto.getMonto();
                                       valor= NumberToLetterConverter.getConvertirPesosEnString(monto);}
                    case "fechaPago": MyUtil.getFechaString10DDMMAAAA(listacomprobante.get(index).getFecha());
                }
                }
        
return valor;
}

@Override
public boolean next() throws JRException
    {
        return ++index < listacomprobante.size();
    }

public void addComprobante(Comprobante listacomprobante)
    {
        this.listacomprobante.add(listacomprobante);
    }

 public void setListComprobante(List<Comprobante> l) {
        this.listacomprobante = l;
    }

}