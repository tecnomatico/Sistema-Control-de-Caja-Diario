package co.tecnomati.java.controlcaja.dominio;
// Generated 31/01/2014 14:12:22 by Hibernate Tools 3.2.1.GA



/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private String cuit;
     private String razonSocial;
     private String domicilio;
     private boolean estado;
     private String telefono;

    public Cliente() {
    }

	
    public Cliente(String razonSocial, boolean estado) {
        this.razonSocial = razonSocial;
        this.estado = estado;
    }
    public Cliente(String cuit, String razonSocial, String domicilio, boolean estado, String telefono) {
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
    public String getCuit() {
        return this.cuit;
    }
    
    public void setCuit(String cuit) {
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
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}


