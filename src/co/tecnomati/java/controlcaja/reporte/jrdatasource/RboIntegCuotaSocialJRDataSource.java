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

import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.dao.imp.CooperativaDaoImp;
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

@Override
public Object getFieldValue(JRField jrf) throws JRException
{
        Object valor = null;
      cc = listacomprobante.get(index);
        /*ASOCIADO_INT=0; CLIENTE_INT=1; PROVEEDOR_INT=2;*/
        if (cc.getTipoPersona().equals(0)) {
           Asociado asociado = new AsociadoDaoImp().getAsociado(cc.getIdEntidad());
                switch (jrf.getName()){
                    case "inicioActividad": valor = c.getInicioActividad();
                    case "nombreApellido": valor = asociado.getApellido()+" "+ asociado.getNombre();
                    case "nro": valor = asociado.getLegajo();
                    case "fechaIngreso": valor = asociado.getIngreso();
                    case "nroDNI": valor = asociado.getDni();
                    case "cuit": valor = asociado.getCuit();
                    case "cantidadPago": valor = cc.hashCode();
                    case "fechaPago": valor = cc.getFecha();
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

}