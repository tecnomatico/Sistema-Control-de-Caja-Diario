/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.modelo;

import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.TipoComprobanteDAO;
import co.tecnomati.java.controlcaja.dominio.dao.imp.TipoComprobanteDaoImp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joel
 */
public class ModeloTipoComprobante extends AbstractTableModel {
        
    Tipocomprobante tipoComp = new Tipocomprobante();
    TipoComprobanteDAO tipoCompDAO = new TipoComprobanteDaoImp();
    ArrayList<Tipocomprobante> listaTipoComp = new ArrayList<Tipocomprobante>();

    public ModeloTipoComprobante() {
        try {
            listaTipoComp = (ArrayList<Tipocomprobante>) tipoCompDAO.listarTipoFormulario();
      } catch (ClassCastException ex) {
            listaTipoComp = new ArrayList<Tipocomprobante>();            
      }
    
    
    }
     private String[] cabeceras = {
        "codigo", "Denominacion", "Abreviatura" ,
    };
    
    @Override
    public int getColumnCount() {
        return cabeceras.length;    }

    @Override
    public int getRowCount() {
        return listaTipoComp.size();    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();
        tipoComp = (Tipocomprobante) listaTipoComp.get(rowIndex);
        
        switch (columnIndex) {
            case 0:objeto = tipoComp.getCodigo();break;
            
            case 1:objeto = tipoComp.getFormulario();break;
            
            case 2:objeto = tipoComp.getReferencia();break;
                      
        }      
        return objeto;    }
    
    public final void actualizar() {
        fireTableDataChanged();
    }    
    public Tipocomprobante Consulta(int col) {
     return (Tipocomprobante) listaTipoComp.get(col);
    }
 public Tipocomprobante getTipoComp(int fila){
        return listaTipoComp.get(fila);
        
    }
    
 public void removeElement(Object elemento)
    {
        listaTipoComp.remove(elemento);
        actualizar();
    }
}