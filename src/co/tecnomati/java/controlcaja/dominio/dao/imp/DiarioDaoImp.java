/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Diario;
import co.tecnomati.java.controlcaja.dominio.dao.DiarioDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Joel
 */
public class DiarioDaoImp extends HibernateUtil implements DiarioDAO{

    @Override
    public List<Diario> listarDiario() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Diario.class);
        
        ArrayList<Diario> diario = (ArrayList<Diario>)criteria.list();
        session.close();
        return diario;
    }

    @Override
    public void addDiario(Diario a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteDiario(Diario a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateDiario(Diario a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Diario getDiario(Date idDiario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Diario a = (Diario) session.get(Diario.class,idDiario);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
}
