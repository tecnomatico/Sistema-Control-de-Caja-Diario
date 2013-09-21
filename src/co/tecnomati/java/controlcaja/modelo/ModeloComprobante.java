/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.modelo;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ClienteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ProveedorDaoImp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joel
 */
public class ModeloComprobante extends AbstractTableModel {
    Comprobante comprobante = new Comprobante();
    ComprobanteDaoImp comprobanteDAO = new ComprobanteDaoImp();
    ArrayList<Comprobante> listaComprobante = new ArrayList<Comprobante>();
    
    
     private String[] cabeceras = {
        "Id", "Fecha", "Operacion", "Numero Serie", "Entidad", "Comprobante","Detalle"      
    };
    
    
      public ModeloComprobante() {            
        try {
            listaComprobante = (ArrayList<Comprobante>) comprobanteDAO.listarFormulario();
        } catch (ClassCastException ex) {
            listaComprobante= new ArrayList<Comprobante>();            
        }finally{
        }
    }
 public final void actualizar() {
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return listaComprobante.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Object objeto = new Object();       
        comprobante = (Comprobante) listaComprobante.get(rowIndex);
       
        switch (columnIndex) {
          
            case 0:objeto = comprobante.getId();break;
            case 1:objeto = comprobante.getFecha();break;
            case 2:objeto = comprobante.getTipoProceso();break;
            case 3:objeto = comprobante.getNumeroSerie();break;
            case 4:objeto = getRazonSocial();break;
            case 5:objeto = comprobante.getTipocomprobante().getFormulario();break; //ver aqui
            case 6:objeto = comprobante.getComprobanteconceptos();break; // ver aqui

            
        }      
        return objeto;
    }
    
     public Object getRazonSocial(){
        Object objeto= null;
         //  determinar de que tipo de persona es para 
        switch (comprobante.getTipoPersona()) {
             case Constantes.ASOCIADO_INT :objeto = new AsociadoDaoImp().getAsociado(comprobante.getId()).getNombre();break;
             case Constantes.PROVEEDOR_INT :objeto = new ProveedorDaoImp().getProveedor(comprobante.getId()).getRazonSocial();break;
             case Constantes.CLIENTE_INT :objeto = new ClienteDaoImp().getCliente(comprobante.getId()).getRazonSocial();break;

         }
        return objeto;
     }
}
