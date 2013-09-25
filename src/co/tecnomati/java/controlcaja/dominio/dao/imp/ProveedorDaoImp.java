/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Proveedor;
import co.tecnomati.java.controlcaja.dominio.dao.ProveedorDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Joel
 */
public class ProveedorDaoImp extends HibernateUtil implements ProveedorDAO {

    @Override
    public List<Proveedor> listarProveedor() {
//       Session session = HibernateUtil.getSessionFactory().openSession();
            Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Proveedor.class);
        
        ArrayList<Proveedor> parroquia = (ArrayList<Proveedor>)criteria.list();
        session.close();
        return parroquia;
    }

    @Override
    public void addProveedor(Proveedor a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteProveedor(Proveedor a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
          Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateProveedor(Proveedor a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Proveedor getProveedor(int idProveedor) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
               Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Proveedor a = (Proveedor) session.get(Proveedor.class,idProveedor);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
}
