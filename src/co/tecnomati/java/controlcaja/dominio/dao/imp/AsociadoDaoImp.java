/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.dao.AsociadoDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Joel
 */
public class AsociadoDaoImp extends HibernateUtil implements AsociadoDAO {

    @Override
    public List<Asociado> listarAsociado() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();
                
        session.beginTransaction();
        
        ArrayList<Asociado> parroquia = (ArrayList<Asociado>)session.createQuery(" from Asociado order by legajo asc").list();
        
        session.close();
        return parroquia;
    }

    @Override
    public void addAsociado(Asociado a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
          Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteAsociado(Asociado a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
          Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateAsociado(Asociado a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
             Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Asociado getAsociado(int idAsociado) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Asociado a = (Asociado) session.get(Asociado.class,idAsociado);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
    @Override
    public int getLastID(){
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        int  id = (int) session.createQuery("select MAX(legajo) from Asociado").uniqueResult();
        session.getTransaction().commit();
        session.close();
        return id;
    }
    
    
}
