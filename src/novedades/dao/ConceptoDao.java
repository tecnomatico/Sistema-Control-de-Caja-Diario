/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;

import pojo.Concepto;
import pojo.Empleado;


/**
 *
 * @author Joel
 */
public interface ConceptoDao {
  java.util.List<Concepto> listarConcepto(Empleado o);
  public void addConcepto(Concepto a);
  public void deleteConcepto(Concepto a);
  public void upDateConcepto(Concepto a);
  public Concepto getConcepto(int idConcepto);
}
