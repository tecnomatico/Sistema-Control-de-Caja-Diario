/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Concepto;

/**
 *
 * @author Joel
 */
public interface ConceptoDAO {
  java.util.List<Concepto> listarConcepto();
  public void addConcepto(Concepto a);
  public void deleteConcepto(Concepto a);
  public void upDateConcepto(Concepto a);
  public Concepto getConcepto(int idConcepto);
}
