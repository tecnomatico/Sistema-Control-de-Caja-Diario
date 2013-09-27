/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.reporte.jrdatasource;

import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.dao.AsociadoDAO;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.util.List;
import co.tecnomati.java.controlcaja.util.*;

import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.dao.ComprobanteDAO;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;



/**
 *
 * @author AnahiAramayo
 */
public class RboIntegCuotaSocialJRDataSource implements JRDataSource
{
 private List<Comprobante> comprobante = new ArrayList<Comprobante>();
    private int index = -1;//actual
    Comprobante cc;
    Cooperativa c;
    
    public Object getFieldValue(JRField jrf) throws JRException
    {
        Object valor = null;

        if ("inicioActividad".equals(jrf.getName()))
        {
            valor = c.getInicioActividad();
        }
        else if ("nombreApellido".equals(jrf.getName()))
        {
            valor = comprobante.get(index).getUsername();
        }
        else if ("nroAsociado".equals(jrf.getName()))
        {
            valor = comprobante.get(index).getPassword();
        }
        else if ("fechaIngreso".equals(jrf.getName()))
        {
            valor = comprobante.get(index).getComentarios();
        }
        else if ("nroDNI".equals(jrf.getName()))
        {
            valor = comprobante.get(index).getComentarios();
        }else if ("cuit".equals(jrf.getName()))
        {
            valor = comprobante.get(index).getComentarios();
        }else if ("cantidadPago".equals(jrf.getName()))
        {
            valor = comprobante.get(index).getComentarios();
        }else if ("fechaPago".equals(jrf.getName()))
        {
            valor = comprobante.get(index).getComentarios();
        }
        return valor;
    }

    public boolean next() throws JRException
    {
        return ++index < comprobante.size();
    }

    public void addParticipante(Participante participante)
    {
        this.comprobante.add(participante);
    }
}