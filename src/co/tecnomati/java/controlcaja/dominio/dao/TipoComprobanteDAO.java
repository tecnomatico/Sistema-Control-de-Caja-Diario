/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;

/**
 *
 * @author Joel
 */
public interface TipoComprobanteDAO {
      java.util.List<Tipocomprobante> listarTipoFormulario();
      java.util.List<Tipocomprobante> listarTipoComprobantexCategoria(String categoria);
      java.util.List<Tipocomprobante> listarTipoComprobante();
  public void addTipoFormulario(Tipocomprobante a);
  public void deleteTipoFormulario(Tipocomprobante a);
  public void upDateTipoFormulario(Tipocomprobante a);
  public Tipocomprobante getTipoFormulario(int idTipoFormulario);
  public Tipocomprobante getTipoComprobanteRef(String ref);
}
