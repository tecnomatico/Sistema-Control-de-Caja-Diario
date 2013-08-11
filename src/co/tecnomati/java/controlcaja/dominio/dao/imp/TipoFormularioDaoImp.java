/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.TipoFormulario;
import co.tecnomati.java.controlcaja.dominio.dao.TipoFormularioDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Joel
 */
public class TipoFormularioDaoImp implements TipoFormularioDAO{

    @Override
    public List<TipoFormulario> listarTipoFormulario() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TipoFormulario.class);
        
        ArrayList<TipoFormulario> parroquia = (ArrayList<TipoFormulario>)criteria.list();
        session.close();
        return parroquia;
    }

    @Override
    public void addTipoFormulario(TipoFormulario a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteTipoFormulario(TipoFormulario a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateTipoFormulario(TipoFormulario a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public TipoFormulario getTipoFormulario(int idTipoFormulario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       TipoFormulario a = (TipoFormulario) session.get(TipoFormulario.class,idTipoFormulario);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
}
