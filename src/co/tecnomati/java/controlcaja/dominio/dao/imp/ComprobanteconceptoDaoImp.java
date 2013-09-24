/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.dao.ComprobanteConceptoDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author joel
 */
public class ComprobanteconceptoDaoImp extends HibernateUtil implements ComprobanteConceptoDAO{

    @Override
    public List<Comprobanteconcepto> listarCliente() {
  Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Asociado.class);
        
        ArrayList<Comprobanteconcepto> comprobanteConcepto = (ArrayList<Comprobanteconcepto>)criteria.list();
        session.close();
        return comprobanteConcepto;    }

    @Override
    public void addComprobanteconcepto(Comprobanteconcepto a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();      }

    @Override
    public void deleteComprobanteconcepto(Comprobanteconcepto a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public void upDateComprobanteconcepto(Comprobanteconcepto a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();       }

    @Override
    public Comprobanteconcepto getComprobanteconcepto(int idComprobanteconcepto) {
Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Comprobanteconcepto a = (Comprobanteconcepto) session.get(Asociado.class,idComprobanteconcepto);
        session.getTransaction().commit();
        session.close();
        return a;      }

    @Override
    public List<Comprobanteconcepto> listComprobanteconceptos(int idComprobante) {
        Session session = getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Comprobanteconcepto.class);
         criteria.addOrder(Order.asc("id"));
         List<Comprobanteconcepto> lista = criteria.list();
         
//         session.close();
          return lista;
    }
    @Override
    public double getMontoTotal(int idComprobante) {
        Session session = getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Comprobanteconcepto.class);
         criteria.addOrder(Order.asc("id"));
         List<Comprobanteconcepto> lista = criteria.list();
         double total = 0;
         for (Comprobanteconcepto comprobanteconcepto : lista) {
            total =total + comprobanteconcepto.getMonto();
        }
//         session.close();
          return total;
    }

    
}
