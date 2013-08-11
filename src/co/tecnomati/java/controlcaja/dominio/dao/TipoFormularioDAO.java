/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.TipoFormulario;

/**
 *
 * @author Joel
 */
public interface TipoFormularioDAO {
      java.util.List<TipoFormulario> listarTipoFormulario();
  public void addTipoFormulario(TipoFormulario a);
  public void deleteTipoFormulario(TipoFormulario a);
  public void upDateTipoFormulario(TipoFormulario a);
  public TipoFormulario getTipoFormulario(int idTipoFormulario);
}
