/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Categoriacomprobante;

/**
 *
 * @author joel
 */
public interface CategoriaComprobanteDAO {
     java.util.List<Categoriacomprobante> listarCategoriaComprobante();
  public void addCategoriacomprobante(Categoriacomprobante a);
  public void deleteCategoriacomprobante(Categoriacomprobante a);
  public void upDateCategoriacomprobante(Categoriacomprobante a);
  public Categoriacomprobante getCategoriaComprobanteXdescripcion(String descripcion);
   
}
