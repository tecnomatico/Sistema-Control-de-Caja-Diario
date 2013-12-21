/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.modelo;

import co.tecnomati.java.controlcaja.dominio.Asociado;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import co.tecnomati.java.controlcaja.dominio.dao.imp.*;
import java.util.Iterator;


/**
 *
 * @author AnahiAramayo
 */
public class ModeloAsociado extends AbstractTableModel{
    Asociado persona = new Asociado();
    
    ArrayList<Asociado> listaPersonas = new ArrayList<Asociado>();
    
    
  
   // Asociado ahijado = new Asociado();
            public ModeloAsociado() {            
        try {
            listaPersonas = (ArrayList<Asociado>) new AsociadoDaoImp().listarAsociado();
        } catch (ClassCastException ex) {
            listaPersonas = new ArrayList<Asociado>();            
        }finally{
        }
    }

    public final void actualizar() {
        fireTableDataChanged();
    }    
    @Override
    public int getRowCount() {
        return listaPersonas.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();
        persona = (Asociado) listaPersonas.get(rowIndex);
        
        switch (columnIndex) {
            case 0:objeto = persona.getIdAsociado();break;
            
            case 1:objeto = persona.getLegajo();break;
            
            case 2:objeto = persona.getApellido()+" "+persona.getNombre();break;
            case 3:objeto = persona.getCuit();break;
            case 4:objeto = persona.getTelefono();break;
            
        }      
        return objeto;
    }
    
    private String[] cabeceras = {
         "Id","Legajo", "RazonSocial", "Cuit","Telefono",
    };
    
    public Asociado Consulta(int col) {
        return (Asociado) listaPersonas.get(col);
    }
    
    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
    public void addElement(Object nuevoElemento){
        listaPersonas.add((Asociado)nuevoElemento);        
        actualizar();
    }
    
    public Asociado getAsociado(int fila){
        return listaPersonas.get(fila);
    }
    
    public void removeElement(Object elemento)
    {
        listaPersonas.remove(elemento);
        actualizar();
    }
    
    
}
