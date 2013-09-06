/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;

import java.util.Set;
import pojo.Concepto;
import pojo.Empleado;

/**
 *
 * @author usuario
 */
public interface EmpleadoDao {
  java.util.List<Empleado> listarEmpleado();
  java.util.List<Empleado> listarEmpleadoAdministradores();
  public void addEmpleado(Empleado a);
  public void deleteEmpleado(Empleado a);
  public void upDateEmpleado(Empleado a);
  public Empleado getEmpleado(int idEmpleado);
  public Set<Concepto> getConcepto(int idConcepto);
  public Empleado getEmpleadoLegajo(int legajo);
  public Empleado getEmpleadoAdministrador(int legajo, boolean adm,String contrasenias);
}
