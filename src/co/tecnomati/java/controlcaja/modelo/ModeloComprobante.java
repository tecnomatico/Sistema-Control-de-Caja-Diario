/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.modelo;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ClienteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteconceptoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ProveedorDaoImp;
import java.util.ArrayList;
import java.util.List;
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
        List<Comprobanteconcepto> listConceptos = new ComprobanteconceptoDaoImp().listComprobanteconceptos(comprobante.getId());
       
        switch (columnIndex) {
          
            case 0:objeto = comprobante.getId();break;
            case 1:objeto = comprobante.getFecha();break;
            case 2:objeto = getTipoOperacion();break;
            case 3:objeto = comprobante.getNumeroSerie();break;
            case 4:objeto = getRazonSocial();break;
            case 5:objeto = new ComprobanteDaoImp().getTipocomprobante(comprobante.getId()).getFormulario();break; //ver aqui
           case 6:objeto = new ComprobanteconceptoDaoImp().getMontoTotal(comprobante.getId());break; // ver aqui

            
        }      
        return objeto;
    }
    
     public Comprobante Consulta(int col) {
        return (Comprobante) listaComprobante.get(col);
    }
    
    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
    public void addElement(Object nuevoElemento){
        listaComprobante.add((Comprobante)nuevoElemento);        
        actualizar();
    }
    
    public Comprobante getAsociado(int fila){
        return listaComprobante.get(fila);
    }
    
    public void removeElement(Object elemento)
    {
        listaComprobante.remove(elemento);
        actualizar();
    }

    public Object getTipoOperacion(){
        Object objeto=null;
        switch (comprobante.getTipoProceso()) {
            case Constantes.OP_ENTRADA:objeto = "ENTRADA";break;
            case Constantes.OP_SALIDA:objeto = "SALIDA";break;
        }
        
        return objeto;
    }
     public Object getRazonSocial(){
        Object objeto= null;
         //  determinar de que tipo de persona es para 
        System.out.println(comprobante.getTipoPersona());
        System.out.println(Constantes.ASOCIADO_INT);
        System.out.println(Constantes.PROVEEDOR_INT);
        System.out.println(Constantes.CLIENTE_INT);
       
        switch (comprobante.getTipoPersona().intValue()) {
            
             case Constantes.ASOCIADO_INT :objeto = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad()).getNombre();break;
             case Constantes.PROVEEDOR_INT :objeto = new ProveedorDaoImp().getProveedor(comprobante.getIdEntidad()).getRazonSocial();break;
             case Constantes.CLIENTE_INT :objeto = new ClienteDaoImp().getCliente(comprobante.getIdEntidad()).getRazonSocial();break;

         }
        return objeto;
     }
     
}
