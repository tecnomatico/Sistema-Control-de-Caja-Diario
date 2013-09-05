/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.modelo;

import co.tecnomati.java.controlcaja.dominio.TipoFormulario;
import co.tecnomati.java.controlcaja.dominio.dao.TipoFormularioDAO;
import co.tecnomati.java.controlcaja.dominio.dao.imp.TipoFormularioDaoImp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

/**
 *
 * @author joel
 */
public class ModeloTipoFormulario extends AbstractTableModel {
        
    TipoFormulario tipoComp = new TipoFormulario();
    TipoFormularioDAO tipoCompDAO = new TipoFormularioDaoImp();
    ArrayList<TipoFormulario> listaTipoComp = new ArrayList<TipoFormulario>();

    public ModeloTipoFormulario() {
        try {
            listaTipoComp = (ArrayList<TipoFormulario>) tipoCompDAO.listarTipoFormulario();
      } catch (ClassCastException ex) {
            listaTipoComp = new ArrayList<TipoFormulario>();            
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
        tipoComp = (TipoFormulario) listaTipoComp.get(rowIndex);
        
        switch (columnIndex) {
            case 0:objeto = tipoComp.getCodigo();break;
            
            case 1:objeto = tipoComp.getFormulario();break;
            
            case 2:objeto = tipoComp.getAtajo();break;
                      
        }      
        return objeto;    }
    
    public final void actualizar() {
        fireTableDataChanged();
    }    
    public TipoFormulario Consulta(int col) {
     return (TipoFormulario) listaTipoComp.get(col);
    }
 public TipoFormulario getTipoComp(int fila){
        return listaTipoComp.get(fila);
        
    }
    
 public void removeElement(Object elemento)
    {
        listaTipoComp.remove(elemento);
        actualizar();
    }
}
