/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Cooperativa;
import co.tecnomati.java.controlcaja.dominio.dao.CooperativaDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Joel
 */
public class CooperativaDaoImp  extends  HibernateUtil implements CooperativaDAO{

    @Override
    public List<Cooperativa> listarCooperativa() {
//       Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Cooperativa.class);
        
        ArrayList<Cooperativa> parroquia = (ArrayList<Cooperativa>)criteria.list();
        session.close();
        return parroquia;
    }

    @Override
    public void addCooperativa(Cooperativa a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteCooperativa(Cooperativa a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateCooperativa(Cooperativa a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Cooperativa getCooperativa(int idCooperativa) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Cooperativa a = (Cooperativa) session.get(Cooperativa.class,idCooperativa);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
}
