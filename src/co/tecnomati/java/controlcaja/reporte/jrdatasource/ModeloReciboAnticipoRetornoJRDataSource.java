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
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ClienteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteconceptoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ProveedorDaoImp;
import co.tecnomati.java.controlcaja.util.Entidad;
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
public class ModeloReciboAnticipoRetornoJRDataSource  implements JRDataSource{
     List<Comprobante> listaComprobante = new ArrayList<>();
     private int index=-1;
     
    Comprobante  comprobante ;
     Set<Comprobanteconcepto>  conjuntoConceptos;
    
    @Override
    public boolean next() throws JRException {
        return ++index < listaComprobante.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor=null ;
        // aqui esta el comprobante que tengo que imprimir
        comprobante = listaComprobante.get(index);
        
        Cooperativa coop = new CooperativaDaoImp().listarCooperativa().get(0);
        Entidad entidad= new Entidad();
     // buscar la persona y guardar sus datos en la clase entidad
      switch (comprobante.getTipoPersona()) {
           
             case Constantes.ASOCIADO_INT : Asociado a = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
                                            
                                            entidad.setNombre(a.getApellido() +" "+a.getNombre());
                                            entidad.setFechaIngreso(a.getIngreso());
                                            entidad.setCuit(a.getCuit());
                                            break;
             case Constantes.PROVEEDOR_INT :Proveedor p = new ProveedorDaoImp().getProveedor(comprobante.getIdEntidad());
                                            entidad.setNombre(p.getRazonSocial());

                                            entidad.setCuit(p.getCuit());
                                            break;
             case Constantes.CLIENTE_INT : Cliente c = new ClienteDaoImp().getCliente(comprobante.getIdEntidad());
                                           entidad.setNombre(c.getRazonSocial());
                                          entidad.setCuit(c.getCuit());
                                           break;

                 
                 
      }
      
        List<Comprobanteconcepto> lista= new ArrayList() ;
        conjuntoConceptos=  new ComprobanteDaoImp().listarConcepto(comprobante.getId());
        double montototal=0;
        for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
            Comprobanteconcepto comprobante1 = it.next();
            lista.add(comprobante1);
            //calculo monto total
            montototal= montototal+ comprobante1.getMonto();
        }
         // para este recibo se sabe de antemanano que son dos conceptos.
        Comprobanteconcepto comprobConcepto1= lista.get(0);
        Comprobanteconcepto comprobConcepto2 = lista.get(1);
        
        //tipo de comprobante 
        
        
        // persona 
          if ("nombreApellido".equals(jrf.getName())) {
             valor= entidad.getNombre();            
        
        } else if ("nroAsociado".equals(jrf.getName())) {
            valor = entidad.getId();
        }
         else if ("fechaIngreso".equals(jrf.getName())) {
            valor = entidad.getFechaIngreso();
        }
         else if ("nroDni".equals(jrf.getName())) {
            valor = entidad.getDni();
        }
         else if ("cuitAsociado".equals(jrf.getName())) {
            valor = entidad.getCuit();
        }
         // conceptos 
        
         
         else if ("concepto1".equals(jrf.getName())) {
             
            valor = comprobConcepto1.getConcepto().getDescripcion();
        }
         else if ("porcentaje1".equals(jrf.getName())) {
            valor = "";
        }
         else if ("importe1".equals(jrf.getName())) {
            valor = comprobConcepto1.getMonto();;
        }
         else if ("descuento1".equals(jrf.getName())) {
            valor = "";
        }
         else if ("concepto2".equals(jrf.getName())) {
             
            valor = comprobConcepto2.getConcepto().getDescripcion();
        }
         else if ("porcentaje2".equals(jrf.getName())) {
            valor = "";
        }
         else if ("importe2".equals(jrf.getName())) {
            valor = comprobConcepto2.getMonto();;
        }
         else if ("descuento2".equals(jrf.getName())) {
            valor = "";
        }
         else if ("matricula".equals(jrf.getName())) {
            valor = coop.getMatricula();
        }
         else if ("cuitCoop".equals(jrf.getName())) {
            valor = coop.getCuit();
        }
         else if ("".equals(jrf.getName())) {
            valor = "";
        }
         else if ("descuento2".equals(jrf.getName())) {
            valor = "";
        }
          
               
        
        return valor;
    }
   
    public void setListComprobante(List<Comprobante> l) {
        this.listaComprobante = l;
    }
}
