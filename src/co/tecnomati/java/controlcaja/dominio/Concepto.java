package co.tecnomati.java.controlcaja.dominio;
// Generated 21/08/2013 18:13:09 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Concepto generated by hbm2java
 */
public class Concepto  implements java.io.Serializable {


     private Integer codigo;
     private String descripcion;
     private Set<Formulario> formularios = new HashSet<Formulario>(0);

    public Concepto() {
    }

    public Concepto(String descripcion, Set<Formulario> formularios) {
       this.descripcion = descripcion;
       this.formularios = formularios;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set<Formulario> getFormularios() {
        return this.formularios;
    }
    
    public void setFormularios(Set<Formulario> formularios) {
        this.formularios = formularios;
    }




}


