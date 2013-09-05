/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.vista.GUIProveedor;

/**
 *
 * @author Joel
 */
public interface ProveedorDAO {
     java.util.List<GUIProveedor> listarProveedor();
  public void addProveedor(GUIProveedor a);
  public void deleteProveedor(GUIProveedor a);
  public void upDateProveedor(GUIProveedor a);
  public GUIProveedor getProveedor(int idProveedor);
}
