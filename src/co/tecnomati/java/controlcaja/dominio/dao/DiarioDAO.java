/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Diario;
import java.util.Date;

/**
 *
 * @author Joel
 */
public interface DiarioDAO {
       java.util.List<Diario> listarDiario();
  public void addDiario(Diario a);
  public void deleteDiario(Diario a);
  public void upDateDiario(Diario a);
  public Diario getDiario(Date idDiario);
}
