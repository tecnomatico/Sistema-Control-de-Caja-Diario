package co.tecnomati.java.controlcaja.dominio;
// Generated 31/01/2014 14:12:22 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Asociado generated by hbm2java
 */
public class Asociado  implements java.io.Serializable {


     private Integer idAsociado;
     private Cooperativa cooperativa;
     private int legajo;
     private String cuit;
     private Integer dni;
     private String apellido;
     private String nombre;
     private Date ingreso;
     private String telefono;
     private Boolean estado;

    public Asociado() {
    }

	
    public Asociado(int legajo, String cuit) {
        this.legajo = legajo;
        this.cuit = cuit;
    }
    public Asociado(Cooperativa cooperativa, int legajo, String cuit, Integer dni, String apellido, String nombre, Date ingreso, String telefono, Boolean estado) {
       this.cooperativa = cooperativa;
       this.legajo = legajo;
       this.cuit = cuit;
       this.dni = dni;
       this.apellido = apellido;
       this.nombre = nombre;
       this.ingreso = ingreso;
       this.telefono = telefono;
       this.estado = estado;
    }
   
    public Integer getIdAsociado() {
        return this.idAsociado;
    }
    
    public void setIdAsociado(Integer idAsociado) {
        this.idAsociado = idAsociado;
    }
    public Cooperativa getCooperativa() {
        return this.cooperativa;
    }
    
    public void setCooperativa(Cooperativa cooperativa) {
        this.cooperativa = cooperativa;
    }
    public int getLegajo() {
        return this.legajo;
    }
    
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public String getCuit() {
        return this.cuit;
    }
    
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public Integer getDni() {
        return this.dni;
    }
    
    public void setDni(Integer dni) {
        this.dni = dni;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getIngreso() {
        return this.ingreso;
    }
    
    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
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


