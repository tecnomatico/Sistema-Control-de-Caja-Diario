/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Joel
 */
public interface ComprobanteDAO {
  java.util.List<Comprobante> listarFormulario();
  java.util.List<Comprobante> listarFormularioActivo();
  java.util.List<Comprobante> listarFormularioxCategoria(String categoria);
  java.util.List<Comprobante> listarFormularioxFiltro(String where);
  /**
   * 
   * @param desde fecha de inicio
   * @param hasta fecha fin
   * @return una lista con los comprobantes que se registraron entre esas fechas 
   * Esta hecho con consultas criteria
   */
  java.util.List<Comprobante> listarFormularioxFecha(Date desde, Date hasta);
   public List<Comprobante> listarFormularioxFechaHQl(Date desde, Date hasta) ;
  public void addFormulario(Comprobante a);
  public void deleteFormulario(Comprobante a);
  public void upDateFormulario(Comprobante a);
  public Comprobante getFormulario(int idFormulario);
  public Tipocomprobante getTipocomprobante(int idComprobante);
  public Set<Comprobanteconcepto> listarConcepto(int idComprobante);   
//  public Comprobante getComprobante(int idComprobante);
  }