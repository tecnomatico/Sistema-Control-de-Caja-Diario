/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;

/**
 *
 * @author Joel
 */
public interface ComprobanteDAO {
  java.util.List<Comprobante> listarFormulario();
  public void addFormulario(Comprobante a);
  public void deleteFormulario(Comprobante a);
  public void upDateFormulario(Comprobante a);
  public Comprobante getFormulario(int idFormulario);
  public Tipocomprobante getTipocomprobante(int idComprobante);
          
  }