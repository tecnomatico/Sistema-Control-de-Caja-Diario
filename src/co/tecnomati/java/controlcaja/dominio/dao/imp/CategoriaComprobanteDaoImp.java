/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Categoriacomprobante;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.CategoriaComprobanteDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class CategoriaComprobanteDaoImp extends HibernateUtil implements CategoriaComprobanteDAO{

    @Override
    public List<Categoriacomprobante> listarCategoriaComprobante() {
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Categoriacomprobante.class);
        
        ArrayList<Categoriacomprobante> categoriacomprobante = (ArrayList<Categoriacomprobante>)criteria.list();
        session.close();
        return categoriacomprobante;    }

    @Override
    public void addCategoriacomprobante(Categoriacomprobante a) {
       Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteCategoriacomprobante(Categoriacomprobante a) {
       Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();       }

    @Override
    public void upDateCategoriacomprobante(Categoriacomprobante a) {
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    public Categoriacomprobante getCategoriaComprobanteXdescripcion(String descripcion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String sql= "from Categoriacomprobante where descripcion ='"+descripcion+"'";  
       
        Categoriacomprobante catcomp = (Categoriacomprobante)session.createQuery(sql).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return catcomp;
    }
    
}
