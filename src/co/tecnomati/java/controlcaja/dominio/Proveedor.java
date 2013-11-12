package co.tecnomati.java.controlcaja.dominio;
// Generated 11/11/2013 20:28:15 by Hibernate Tools 3.2.1.GA



/**
 * Proveedor generated by hbm2java
 */
public class Proveedor  implements java.io.Serializable {


     private Integer idProveedor;
     private String cuit;
     private String razonSocial;
     private String domicilio;
     private String telefono;
     private Boolean estado;

    public Proveedor() {
    }

	
    public Proveedor(String cuit) {
        this.cuit = cuit;
    }
    public Proveedor(String cuit, String razonSocial, String domicilio, String telefono, Boolean estado) {
       this.cuit = cuit;
       this.razonSocial = razonSocial;
       this.domicilio = domicilio;
       this.telefono = telefono;
       this.estado = estado;
    }
   
    public Integer getIdProveedor() {
        return this.idProveedor;
    }
    
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
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
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }




}


