/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Asociado;

/**
 *
 * @author Joel
 */
public interface AsociadoDAO {
  java.util.List<Asociado> listarAsociado();
  public void addAsociado(Asociado a);
  public void deleteAsociado(Asociado a);
  public void upDateAsociado(Asociado a);
  public Asociado getAsociado(int idAsociado);
}
