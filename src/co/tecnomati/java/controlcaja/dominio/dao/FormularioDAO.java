/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao;

import co.tecnomati.java.controlcaja.dominio.Formulario;

/**
 *
 * @author Joel
 */
public interface FormularioDAO {
  java.util.List<Formulario> listarFormulario();
  public void addFormulario(Formulario a);
  public void deleteFormulario(Formulario a);
  public void upDateFormulario(Formulario a);
  public Formulario getFormulario(int idFormulario);
          
  }