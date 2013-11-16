/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.modelo;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ClienteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ProveedorDaoImp;
import co.tecnomati.java.controlcaja.util.ComprobanteUtil;
import co.tecnomati.java.controlcaja.util.MyUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joel
 */
public class ModeloComprobante extends AbstractTableModel {
    Comprobante comprobante = new Comprobante();
    ComprobanteDaoImp comprobanteDAO = new ComprobanteDaoImp();
    ArrayList<Comprobante> listaComprobante ;
    
    
     private String[] cabeceras = {
        "Id", "Fecha", "Operacion", "Ref", "Numero Serie", "Entidad","Detalle"      
    };
    
    
      public ModeloComprobante() {            
        try {
            listaComprobante = (ArrayList<Comprobante>) comprobanteDAO.listarFormulario();
        } catch (ClassCastException ex) {
            listaComprobante=(ArrayList<Comprobante>)comprobanteDAO.listarFormulario();          
        }finally{
        }
    }
      /**
       *  Filtra la tabla por categoria
       * @param categoria  
       */
     
      public ModeloComprobante(String where) {            
        try {
                        
            listaComprobante = (ArrayList<Comprobante>)comprobanteDAO.listarFormularioxFiltro(where);
        } catch (ClassCastException ex) {
//            listaComprobante= new ArrayList<Comprobante>();  
            listaComprobante=(ArrayList<Comprobante>)comprobanteDAO.listarFormulario();
        }finally{
        }
    }
      public ModeloComprobante(Date desde , Date hasta) {            
        try {
                        
            listaComprobante = (ArrayList<Comprobante>)comprobanteDAO.listarFormularioxFechaHQl(desde, hasta);
        } catch (ClassCastException ex) {
//            listaComprobante= new ArrayList<Comprobante>();  
            listaComprobante=(ArrayList<Comprobante>)comprobanteDAO.listarFormulario();
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
//        Set<Comprobanteconcepto> conjuntoConceptos = comprobante.getComprobanteconceptos();
       
        switch (columnIndex) {
          
            case 0:objeto = comprobante.getId();break;
            case 1:objeto = MyUtil.getFechaString10DDMMAAAA(comprobante.getFecha());break;
            case 2:objeto = getTipoOperacion();break;
            case 3:objeto =comprobante.getTipocomprobante().getReferencia();break;
//            case 3:objeto =new ComprobanteDaoImp().getTipocomprobante(comprobante.getId()).getReferencia();break;
            case 4:objeto = ComprobanteUtil.formatearNumSerieIzq(comprobante.getNumeroSerieIzq())+"-"+ComprobanteUtil.formatearNumSerieDer(comprobante.getNumeroSerieDer());break;
            case 5:objeto = getRazonSocial();break;
            case 6:objeto =  getMontoTotal();break; // ver aqui

            
        }      
        return objeto;
    }
    public double getMontoTotal(){
        double total=0;
//        Set<Comprobanteconcepto> conjuntoConceptos = new ComprobanteDaoImp().listarConcepto(idComprobante);
        for (Iterator<Comprobanteconcepto> it = comprobante.getComprobanteconceptos().iterator(); it.hasNext();) {
            Comprobanteconcepto comprobanteconcepto = it.next();
            total= total+comprobanteconcepto.getMonto();

        }
        return total;
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
//        System.out.println(comprobante.getTipoPersona());
//        System.out.println(Constantes.ASOCIADO_INT);
//        System.out.println(Constantes.PROVEEDOR_INT);
//        System.out.println(Constantes.CLIENTE_INT);
       
        switch (comprobante.getTipoPersona().intValue()) {
            
             case Constantes.ASOCIADO_INT :
                                 Asociado a =  new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
                                 objeto = a.getApellido()+" " + a.getNombre();
                                 break;
             case Constantes.PROVEEDOR_INT :objeto = new ProveedorDaoImp().getProveedor(comprobante.getIdEntidad()).getRazonSocial();break;
             case Constantes.CLIENTE_INT :objeto = new ClienteDaoImp().getCliente(comprobante.getIdEntidad()).getRazonSocial();break;

         }
        return objeto;
     }
     
}
