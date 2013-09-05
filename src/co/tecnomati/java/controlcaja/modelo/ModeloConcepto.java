/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.modelo;

import co.tecnomati.java.controlcaja.dominio.Concepto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ConceptoDaoImp;

/**
 *
 * @author AnahiAramayo
 */
public class ModeloConcepto extends AbstractTableModel{
    Concepto concepto = new Concepto();
    ConceptoDaoImp conceptoDAO = new ConceptoDaoImp();
    ArrayList<Concepto> listaConcepto = new ArrayList<Concepto>();
   
    
    public ModeloConcepto() {            
        try {
            listaConcepto = (ArrayList<Concepto>) conceptoDAO.listarConcepto();
        } catch (ClassCastException ex) {
            listaConcepto = new ArrayList<Concepto>();            
        }finally{
        }
    }

    public final void actualizar() {
        fireTableDataChanged();
    }    
    @Override
    public int getRowCount() {
        return listaConcepto.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();       
        concepto = (Concepto) listaConcepto.get(rowIndex);
        
        switch (columnIndex) {
          
            case 0:objeto = concepto.getCodigo();break;
            case 1:objeto = concepto.getDescripcion();break;

            
        }      
        return objeto;
    }
    
    private String[] cabeceras = {
        "Codigo", "Descrpcion"      
    };
    
    public Concepto Consulta(int col) {
        return (Concepto) listaConcepto.get(col);
    }
    
    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
    public void addElement(Object nuevoElemento){
        listaConcepto.add((Concepto)nuevoElemento);        
        actualizar();
    }
    
    public Concepto getConcepto(int fila){
        return listaConcepto.get(fila);
    }
    
    public void removeElement(Object elemento)
    {
        listaConcepto.remove(elemento);
        actualizar();
    }
    
    
}
