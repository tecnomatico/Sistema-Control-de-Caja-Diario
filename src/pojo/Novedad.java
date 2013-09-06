package pojo;
// Generated 03/09/2013 17:08:28 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Novedad generated by hbm2java
 */
public class Novedad  implements java.io.Serializable {


     private Date fecha;
     private Empleados empleados;
     private Concepto concepto;
     private int cantidad;
     private String observacion;

    public Novedad() {
    }

    public Novedad(Date fecha, Empleados empleados, Concepto concepto, int cantidad, String observacion) {
       this.fecha = fecha;
       this.empleados = empleados;
       this.concepto = concepto;
       this.cantidad = cantidad;
       this.observacion = observacion;
    }
   
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Empleados getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }
    public Concepto getConcepto() {
        return this.concepto;
    }
    
    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }




}


