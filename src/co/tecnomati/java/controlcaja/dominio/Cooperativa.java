package co.tecnomati.java.controlcaja.dominio;
// Generated 11/11/2013 20:28:15 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cooperativa generated by hbm2java
 */
public class Cooperativa  implements java.io.Serializable {


     private Integer idCoop;
     private int matricula;
     private String cuit;
     private String razonSocial;
     private Date inicioActividad;
     private String telefono;
     private String domicilio;
     private Double inicioCaja;
     private String ingresoBruto;
     private Boolean estado;
     private Set<Asociado> asociados = new HashSet<Asociado>(0);

    public Cooperativa() {
    }

	
    public Cooperativa(int matricula, String cuit) {
        this.matricula = matricula;
        this.cuit = cuit;
    }
    public Cooperativa(int matricula, String cuit, String razonSocial, Date inicioActividad, String telefono, String domicilio, Double inicioCaja, String ingresoBruto, Boolean estado, Set<Asociado> asociados) {
       this.matricula = matricula;
       this.cuit = cuit;
       this.razonSocial = razonSocial;
       this.inicioActividad = inicioActividad;
       this.telefono = telefono;
       this.domicilio = domicilio;
       this.inicioCaja = inicioCaja;
       this.ingresoBruto = ingresoBruto;
       this.estado = estado;
       this.asociados = asociados;
    }
   
    public Integer getIdCoop() {
        return this.idCoop;
    }
    
    public void setIdCoop(Integer idCoop) {
        this.idCoop = idCoop;
    }
    public int getMatricula() {
        return this.matricula;
    }
    
    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
    public Date getInicioActividad() {
        return this.inicioActividad;
    }
    
    public void setInicioActividad(Date inicioActividad) {
        this.inicioActividad = inicioActividad;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDomicilio() {
        return this.domicilio;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public Double getInicioCaja() {
        return this.inicioCaja;
    }
    
    public void setInicioCaja(Double inicioCaja) {
        this.inicioCaja = inicioCaja;
    }
    public String getIngresoBruto() {
        return this.ingresoBruto;
    }
    
    public void setIngresoBruto(String ingresoBruto) {
        this.ingresoBruto = ingresoBruto;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set<Asociado> getAsociados() {
        return this.asociados;
    }
    
    public void setAsociados(Set<Asociado> asociados) {
        this.asociados = asociados;
    }




}


