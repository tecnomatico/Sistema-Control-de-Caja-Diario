/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;


import hibernateUtil.Conexion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import novedades.dao.ConceptoDAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Concepto;
import pojo.Empleado;

/**
 *
 * @author Joel
 */
public class ConceptoDaoImp extends Conexion implements ConceptoDAO{

    @Override
    public List<Concepto> listarConcepto() {
       Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Concepto.class);
        
        ArrayList<Concepto> concepto = (ArrayList<Concepto>)criteria.list();
        session.close();
        return concepto;
    }

    @Override
    public void addConcepto(Concepto a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteConcepto(Concepto a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateConcepto(Concepto a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Concepto getConcepto(int idConcepto) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Concepto a = (Concepto) session.get(Concepto.class,idConcepto);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
   
  

}
