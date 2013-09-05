/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.dao.ProveedorDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import co.tecnomati.java.controlcaja.vista.GUIProveedor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Joel
 */
public class ProveedorDaoImp implements ProveedorDAO{

    @Override
    public List<GUIProveedor> listarProveedor() {
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GUIProveedor.class);
        
        ArrayList<GUIProveedor> parroquia = (ArrayList<GUIProveedor>)criteria.list();
        session.close();
        return parroquia;
    }

    @Override
    public void addProveedor(GUIProveedor a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteProveedor(GUIProveedor a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateProveedor(GUIProveedor a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public GUIProveedor getProveedor(int idProveedor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        GUIProveedor a = (GUIProveedor) session.get(GUIProveedor.class,idProveedor);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
}
