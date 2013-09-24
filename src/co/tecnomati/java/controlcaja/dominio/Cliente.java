package co.tecnomati.java.controlcaja.dominio;
// Generated 23/09/2013 20:39:06 by Hibernate Tools 3.2.1.GA



/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private long cuit;
     private String razonSocial;
     private String domicilio;
     private Integer estado;
     private String telefono;

    public Cliente() {
    }

	
    public Cliente(long cuit) {
        this.cuit = cuit;
    }
    public Cliente(long cuit, String razonSocial, String domicilio, Integer estado, String telefono) {
       this.cuit = cuit;
       this.razonSocial = razonSocial;
       this.domicilio = domicilio;
       this.estado = estado;
       this.telefono = telefono;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public long getCuit() {
        return this.cuit;
    }
    
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getDomicilio() {
        return this.domicilio;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}


