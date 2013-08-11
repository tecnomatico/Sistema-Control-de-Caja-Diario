/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Cooperativa;

/**
 *
 * @author Joel
 */
public interface CooperativaDAO {
     java.util.List<Cooperativa> listarCooperativa();
  public void addCooperativa(Cooperativa a);
  public void deleteCooperativa(Cooperativa a);
  public void upDateCooperativa(Cooperativa a);
  public Cooperativa getCooperativa(int idCooperativa);
}
