/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;


import pojo.Concepto;
import pojo.Empleado;
import pojo.Novedad;

/**
 *
 * @author usuario
 */
public interface NovedadDao {
  java.util.List<Novedad> listarNovedad(Empleado o);
  public Empleado getEmpleado(Empleado a);
  public void deleteEmpleado(Empleado a);
  public void upDateEmpleado(Empleado a);
  public Concepto getConcepto(Concepto e);
//  public Novedad getNovedad(int idConcepto);
}
