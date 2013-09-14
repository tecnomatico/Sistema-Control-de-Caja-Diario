/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.TipoComprobanteDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Joel
 */
public class TipoComprobanteDaoImp extends  HibernateUtil implements TipoComprobanteDAO{

    @Override
    public List<Tipocomprobante> listarTipoFormulario() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Tipocomprobante.class);
        
        ArrayList<Tipocomprobante> tipocomprobante = (ArrayList<Tipocomprobante>)criteria.list();
        session.close();
        return tipocomprobante;
    }

    @Override
    public void addTipoFormulario(Tipocomprobante a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();   }

    @Override
    public void deleteTipoFormulario(Tipocomprobante a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void upDateTipoFormulario(Tipocomprobante a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Tipocomprobante getTipoFormulario(int idTipoFormulario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       Tipocomprobante a = (Tipocomprobante) session.get(Tipocomprobante.class,idTipoFormulario);
        session.getTransaction().commit();
        session.close();
        return a;      }
    
}
