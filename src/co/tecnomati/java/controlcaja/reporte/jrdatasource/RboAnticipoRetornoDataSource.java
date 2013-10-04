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
import co.tecnomati.java.controlcaja.util.MyUtil;
import co.tecnomati.java.controlcaja.util.NumberToLetterConverter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author dario
 * Asociado
 */
public class RboAnticipoRetornoDataSource implements JRDataSource{
    int index = -1;
    Comprobante comprobante;
        
    List<Comprobante> listaComprobantes = new ArrayList<Comprobante>();    
    Cooperativa cooperativa = new CooperativaDaoImp().listarCooperativa().get(0);
    @Override
    public boolean next() throws JRException {
        return ++index < listaComprobantes.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor=null;
       
        comprobante = listaComprobantes.get(index);
        
        Tipocomprobante tipoComprobante = new ComprobanteDaoImp().getTipocomprobante(comprobante.getId());
        Set<Comprobanteconcepto> conjuntoConceptos= new ComprobanteDaoImp().listarConcepto(comprobante.getId());//Obtengo el conjunto de ComprobanteConceptos vinculados al Comprobante
        
        Cooperativa cooperativa = new CooperativaDaoImp().listarCooperativa().get(0);
        
        Asociado a = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
//        Entidad entidad= new Entidad();
//
//        switch (comprobante.getTipoPersona()) {           
//             case Constantes.ASOCIADO_INT : Asociado a = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());                                            
//                                            entidad.setNombre(a.getApellido() +" "+a.getNombre());
//                                            entidad.setFechaIngreso(a.getIngreso());
//                                            entidad.setCuit(a.getCuit());
//                                            break;
//             case Constantes.PROVEEDOR_INT :Proveedor p = new ProveedorDaoImp().getProveedor(comprobante.getIdEntidad());
//                                            entidad.setNombre(p.getRazonSocial());
//                                            entidad.setCuit(p.getCuit());
//                                            break;
//             case Constantes.CLIENTE_INT : Cliente c = new ClienteDaoImp().getCliente(comprobante.getIdEntidad());
//                                           entidad.setNombre(c.getRazonSocial());
//                                           entidad.setCuit(c.getCuit());
//                                           break;                                 
//      }
      
        List<Comprobanteconcepto> listaComprobanteConcepto= new ArrayList() ;        
        conjuntoConceptos=  new ComprobanteDaoImp().listarConcepto(comprobante.getId());
        for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
            Comprobanteconcepto comprobante1 = it.next();
            listaComprobanteConcepto.add(comprobante1);
        }
                  
        if ("nroRecibo".equals(jrf.getName())) {
            valor = comprobante.getNumeroSerie();
        }else if("matriculaInaes".equals(jrf.getName())){
            // Dato constante para la configuarcion
            valor = cooperativa.getMatricula();
        }else if("cuitCooperativa".equals(jrf.getName())){                                    
            valor = cooperativa.getCuit();
        }
        else if("inicioActividades".equals(jrf.getName())){
            valor = cooperativa.getInicioActividad();
        }
        else if("ingresosBrutos".equals(jrf.getName())){
            valor = cooperativa.getIngresoBruto();
        }
        else if("domicilioCooperativa".equals(jrf.getName())){
            valor = cooperativa.getDomicilio();
        }                       
        else if("nombreApellido".equals(jrf.getName())){
//            valor = entidad.getNombre();
           valor= a.getApellido()+" "+a.getNombre();
        }
        else if("nroAsociado".equals(jrf.getName())){
//            valor = entidad.getId();
            valor= a.getLegajo();
        }
        else if("fechaIngreso".equals(jrf.getName())){
//            valor = entidad.getFechaIngreso();
            valor= MyUtil.getFechaString10DDMMAAAA(a.getIngreso());
        }
        else if("nroDNI".equals(jrf.getName())){
//            valor = entidad.getDni();
            valor= a.getDni();
        }
        else if("cuitAsociado".equals(jrf.getName())){
//            valor = entidad.getCuit();
            valor= a.getCuit();
        }
        else if("concepto1".equals(jrf.getName())){
            //valor = entidad.getNombre();
        }
        else if("porcentaje1".equals(jrf.getName())){
            //valor = entidad.getId();
        }
        else if("importe1".equals(jrf.getName())){
            //valor = entidad.getFechaIngreso();
        }
        else if("descuento1".equals(jrf.getName())){
            //valor = entidad.getDni();
        }
        else if("concepto2".equals(jrf.getName())){
            //valor = entidad.getNombre();
        }
        else if("porcentaje2".equals(jrf.getName())){
//            valor = entidad.getId();
        }
        else if("importe2".equals(jrf.getName())){
            //valor = entidad.getFechaIngreso();
        }
        else if("descuento2".equals(jrf.getName())){
            //valor = entidad.getDni();
        }
        else if("concepto3".equals(jrf.getName())){
            //valor = entidad.getNombre();
        }
        else if("porcentaje3".equals(jrf.getName())){
            //valor = entidad.getId();
        }
        else if("importe3".equals(jrf.getName())){
            //valor = entidad.getFechaIngreso();
        }
        else if("descuento3".equals(jrf.getName())){
            //valor = entidad.getDni();
        }
        else if("concepto4".equals(jrf.getName())){
            //valor = entidad.getNombre();
        }
        else if("porcentaje4".equals(jrf.getName())){
            //valor = entidad.getId();
        }
        else if("importe4".equals(jrf.getName())){
            //valor = entidad.getFechaIngreso();
        }
        else if("descuento4".equals(jrf.getName())){
            //valor = entidad.getDni();
        }
        else if("concepto5".equals(jrf.getName())){
            //valor = entidad.getNombre();
        }
        else if("porcentaje5".equals(jrf.getName())){
            //valor = entidad.getId();
        }
        else if("importe5".equals(jrf.getName())){
            //valor = entidad.getFechaIngreso();
        }
        else if("descuento5".equals(jrf.getName())){
            //valor = entidad.getDni();
        }
        else if("concepto6".equals(jrf.getName())){
            //valor = entidad.getNombre();
        }
        else if("porcentaje6".equals(jrf.getName())){
            //valor = entidad.getId();
        }
        else if("importe6".equals(jrf.getName())){
            //valor = entidad.getFechaIngreso();
        }
        else if("descuento6".equals(jrf.getName())){
            //valor = entidad.getDni();
        }
        else if("totalImporte".equals(jrf.getName())){
            valor = "Importe";
        }
        else if("totalDescuento".equals(jrf.getName())){
            valor = "Descuento";
        }
        else if("neto".equals(jrf.getName())){
            valor = "neto";
        }
        else if("sonPesos".equals(jrf.getName())){
            valor = "pesoso";
        }
        else if("ano".equals(jrf.getName())){
            valor = Calendar.YEAR;
        }
        else if("lugarPago".equals(jrf.getName())){
            valor = cooperativa.getDomicilio();
        }
        else if("fechaPago".equals(jrf.getName())){
            valor = MyUtil.getFechaString10DDMMAAAA(comprobante.getFecha());
        }
        else if("inicioActividad".equals(jrf.getName())){
            valor = MyUtil.getFechaString10DDMMAAAA(cooperativa.getInicioActividad());
        }
                
        return valor;
    }
    
     public void addComprobante(Comprobante c)
    {
        this.comprobante=c;
    }
    
     public void setListComprobante(List<Comprobante> c){
         this.listaComprobantes = c;
     }
    
}
