/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;

import java.util.Date;
import pojo.Concepto;
import pojo.Empleado;

/**
 *
 * @author usuario
 */
public interface ConceptoDao {
    
  java.util.List<Concepto> listarConcepto();
  public java.util.List<Concepto> listarAsistencia(Empleado e);
  public void addConcepto(Concepto a);
  public void deleteAsistencia(Concepto a);
  public void upDateAsistencia(Concepto a);
  public Concepto getAsistencia(int idAsistencia);
  public Object[] getLegajoYNombreEmpleadoDeNovedades(int idConcepto);
  public java.util.List<Concepto> listarAsistencia(Date fechaInicio ,Date fechaFin);
  public java.util.List<Concepto> listarAsistencia(Empleado e ,Date fechaInicio, Date fechaFin);
    
}
