/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;
import co.tecnomati.java.controlcaja.dominio.Cliente;
import co.tecnomati.java.controlcaja.dominio.dao.ClienteDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
/**
 *
 * @author AnahiAramayo
 */
public class ClienteDaoImp extends HibernateUtil implements ClienteDAO {

    @Override
    public List<Cliente> listarCliente() {
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Cliente.class);
        
        ArrayList<Cliente> parroquia = (ArrayList<Cliente>)criteria.list();
        session.close();
        return parroquia;
    }

    @Override
    public void addCliente(Cliente a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteCliente(Cliente a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateCliente(Cliente a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Cliente getCliente(int idCliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cliente a = (Cliente) session.get(Cliente.class,idCliente);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
}
