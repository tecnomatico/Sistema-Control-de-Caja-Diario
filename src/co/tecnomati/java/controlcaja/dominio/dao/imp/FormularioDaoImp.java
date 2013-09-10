/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Formulario;
import co.tecnomati.java.controlcaja.dominio.dao.FormularioDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;


/**
 *
 * @author Joel
 */
public class FormularioDaoImp implements FormularioDAO{

    @Override
    public List<Formulario> listarFormulario() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Formulario.class);
        
        ArrayList<Formulario> parroquia = (ArrayList<Formulario>)criteria.list();
        session.close();
        return parroquia;
    }

    @Override
    public void addFormulario(Formulario a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteFormulario(Formulario a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateFormulario(Formulario a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Formulario getFormulario(int idFormulario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Formulario a = (Formulario) session.get(Formulario.class,idFormulario);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
}
