/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Cliente;
import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Proveedor;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ClienteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ProveedorDaoImp;
import java.util.Date;

/**
 *
 * @author joel
 */
public class Entidad {
    private int id ;
    private int tipoEntidad;
    private String nombre;
    

    private Date fechaIngreso;
    private String cuit;
    private String dni;

    public Entidad() {
    }

    
    public Entidad( Comprobante comprobante) {
          switch (comprobante.getTipoPersona()) {
            case Constantes.ASOCIADO_INT:
                Asociado a = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
                this.setNombre(a.getApellido() + " " + a.getNombre());
                this.setFechaIngreso(a.getIngreso());
                this.setCuit(a.getCuit());
                this.setDni(a.getDni().toString());
                break;
            case Constantes.PROVEEDOR_INT:
                Proveedor p = new ProveedorDaoImp().getProveedor(comprobante.getIdEntidad());
                this.setNombre(p.getRazonSocial());
                this.setCuit(p.getCuit());
                this.setDni(p.getCuit());
                break;
            case Constantes.CLIENTE_INT:
                Cliente c = new ClienteDaoImp().getCliente(comprobante.getIdEntidad());
                this.setNombre(c.getRazonSocial());
                this.setCuit(c.getCuit());
                this.setDni(c.getCuit());
                break;
        }
    }
    

  
    
    
    
    public int getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(int tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the cuit
     */
    public String getCuit() {
        return cuit;
    }

    /**
     * @param cuit the cuit to set
     */
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

  
    
    
}
