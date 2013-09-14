/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;


import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.dao.ComprobanteDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;


/**
 *
 * @author Joel
 */
public class ComprobanteDaoImp implements ComprobanteDAO{

    @Override
    public List<Comprobante> listarFormulario() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comprobante.class);
        
        ArrayList<Comprobante> parroquia = (ArrayList<Comprobante>)criteria.list();
        session.close();
        return parroquia;
    }

    @Override
    public void addFormulario(Comprobante a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteFormulario(Comprobante a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateFormulario(Comprobante a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Comprobante getFormulario(int idComprobante) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Comprobante a = (Comprobante) session.get(Comprobante.class,idComprobante);
        session.getTransaction().commit();
        session.close();
        return a;      }

    
}
