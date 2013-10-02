/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import java.util.List;

/**
 *
 * @author joel
 */
public interface ComprobanteConceptoDAO {
    java.util.List<Comprobanteconcepto> listarCliente();
  public void addComprobanteconcepto(Comprobanteconcepto a);
  public void deleteComprobanteconcepto(Comprobanteconcepto a);
  public void upDateComprobanteconcepto(Comprobanteconcepto a);
  public Comprobanteconcepto getComprobanteconcepto(int idComprobanteconcepto);
  public List<Comprobanteconcepto> listComprobanteconceptos(int idConcepto);
//  public List<Comprobanteconcepto> listComprobanteconceptos(Comprobante c);
  
   public double getMontoTotal(int idComprobante);
}
