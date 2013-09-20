/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;
import co.tecnomati.java.controlcaja.dominio.Cliente;
/**
 *
 * @author AnahiAramayo
 */
public interface ClienteDAO {
java.util.List<Cliente> listarCliente();
  public void addCliente(Cliente a);
  public void deleteCliente(Cliente a);
  public void upDateCliente(Cliente a);
  public Cliente getCliente(int idCliente);
}
