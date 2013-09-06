/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;

import pojo.Empresa;

/**
 *
 * @author usuario
 */
public interface EmpresaDao {
  java.util.List<Empresa> listarEmpresa();
  public void addEmpresa(Empresa a);
  public void deleteEmpresa(Empresa a);
  public void upDateEmpresa(Empresa a);
  public Empresa getEmpresa(int cod_emp);
}
