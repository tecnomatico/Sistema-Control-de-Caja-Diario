/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.vista.Proveedor;

/**
 *
 * @author Joel
 */
public interface ProveedorDAO {
     java.util.List<Proveedor> listarProveedor();
  public void addProveedor(Proveedor a);
  public void deleteProveedor(Proveedor a);
  public void upDateProveedor(Proveedor a);
  public Proveedor getProveedor(int idProveedor);
}
