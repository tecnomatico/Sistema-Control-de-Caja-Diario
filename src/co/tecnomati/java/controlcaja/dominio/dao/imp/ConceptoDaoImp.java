/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Concepto;
import co.tecnomati.java.controlcaja.dominio.dao.ConceptoDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Joel
 */
public class ConceptoDaoImp extends HibernateUtil implements ConceptoDAO{

    @Override
    public List<Concepto> listarConcepto() {
//       Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Concepto.class);
        
        ArrayList<Concepto> parroquia = (ArrayList<Concepto>)criteria.list();
        session.close();
        return parroquia;
    }

    @Override
    public void addConcepto(Concepto a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteConcepto(Concepto a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateConcepto(Concepto a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Concepto getConcepto(int idConcepto) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Concepto a = (Concepto) session.get(Concepto.class,idConcepto);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
    public Concepto getConceptoCod(int ref) {
        Concepto a = null;
//        Session session = getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        String sql= "from Concepto where referencia ='"+ref+"'";     
        session.getTransaction().commit();
        a =(Concepto) session.createQuery(sql).uniqueResult();
        session.close();
        return a; 
    }
    
    
}
