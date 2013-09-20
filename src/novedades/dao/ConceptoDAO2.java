/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;

import pojo.Concepto;


/**
 *
 * @author Joel
 */
public interface ConceptoDAO2 {
  java.util.List<Concepto> listarConcepto();
  public void addConcepto(Concepto a);
  public void deleteConcepto(Concepto a);
  public void upDateConcepto(Concepto a);
  public Concepto getConcepto(int idConcepto);
}
