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
import co.tecnomati.java.controlcaja.dominio.Concepto;
import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.util.MyUtil;
import co.tecnomati.java.controlcaja.util.NumberToLetterConverter;


/**
 *
 * @author AnahiAramayo
 */
public class RboIntegCuotaSocialJRDataSource implements JRDataSource
{
//List<Comprobante> listacomprobante = new ArrayList<>();
int index = -1;//actual
Comprobante comprobante;
List<Comprobante> listaComprobante = new ComprobanteDaoImp().listarFormulario();

Cooperativa c = new CooperativaDaoImp().listarCooperativa().get(0);
 Concepto concepto;
 private Double monto=0.0;

 @Override
public boolean next() throws JRException
    {
        return ++index < listaComprobante.size();
    }

@Override
public Object getFieldValue(JRField jrf) throws JRException{
    Object valor = null;

      Tipocomprobante tipoComprobante = new ComprobanteDaoImp().getTipocomprobante(listaComprobante.get(index).getId());
      Set<Comprobanteconcepto> conjuntoConceptos= new ComprobanteDaoImp().listarConcepto(listaComprobante.get(index).getId());

      if ("inicioActividad".equals(jrf.getName())) {
       valor = c.getInicioActividad();
      } else if ("nombreApellido".equals(jrf.getName())) {
             valor = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad()).getApellido();
      } else if("nro".equals(jrf.getName())){
            // Dato constante para la configuarcion
            valor = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad()).getLegajo();
        }else if("fechaIngreso".equals(jrf.getName())){
            // Dato constante para la configuarcion
            valor = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad()).getIngreso();
        }else if("nroDNI".equals(jrf.getName())){
            // Dato constante para la configuarcion
            valor = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad()).getDni();
        }else if("cuit".equals(jrf.getName())){
            // Dato constante para la configuarcion
            valor = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad()).getCuit();
        }else if("cuit".equals(jrf.getName())){
            // Dato constante para la configuarcion
            valor = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad()).getCuit();
        }else if("cantidadPago".equals(jrf.getName())){
              Comprobanteconcepto comprobanteconcepto=null;
              for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
              comprobanteconcepto = it.next();
        }
         monto = comprobanteconcepto.getMonto();
         valor= NumberToLetterConverter.getConvertirPesosEnString(monto);
        }else if("fechaPago".equals(jrf.getName())){
            valor=MyUtil.getFechaString10DDMMAAAA(listaComprobante.get(index).getFecha());
        }
return valor;
}
public void addComprobante(Comprobante listacomprobante)
    {
        this.listaComprobante.add(listacomprobante);
    }

 public void setListComprobante(List<Comprobante> l) {
        this.listaComprobante = l;
    }

}