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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Joel
 */
public class TipoComprobanteDaoImp extends HibernateUtil implements TipoComprobanteDAO {

    @Override
    public List<Tipocomprobante> listarTipoFormulario() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Tipocomprobante.class);

        ArrayList<Tipocomprobante> tipocomprobante = (ArrayList<Tipocomprobante>) criteria.list();
        session.close();
        return tipocomprobante;
    }

    @Override
    public void addTipoFormulario(Tipocomprobante a) {
//        Session session = getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteTipoFormulario(Tipocomprobante a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateTipoFormulario(Tipocomprobante a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Tipocomprobante getTipoFormulario(int idTipoFormulario) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Tipocomprobante a = (Tipocomprobante) session.get(Tipocomprobante.class, idTipoFormulario);
        session.getTransaction().commit();
        session.close();
        return a;
    }

    public Tipocomprobante getTipoFormularioRef(String ref) {
        Tipocomprobante a = null;
//        Session session = getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        String sql = "from Tipocomprobante where referencia ='" + ref + "'";
        session.getTransaction().commit();
        a = (Tipocomprobante) session.createQuery(sql).uniqueResult();
        session.close();
        return a;
    }

    public Tipocomprobante getTipoComprobanteRef(String ref) {
        Tipocomprobante a = null;
//        Session session = getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
           
        String sql = "from Tipocomprobante tc \n"
                + "join fetch tc.categoriacomprobante as cc\n"
                + "where tc.referencia ='" + ref + "'";

        session.getTransaction().commit();
        a = (Tipocomprobante) session.createQuery(sql).uniqueResult();
        session.close();
        return a;
    }

    @Override
    public List<Tipocomprobante> listarTipoComprobante() {
        List<Tipocomprobante> a = new ArrayList<>();
//        Session session = getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String sql = "from Tipocomprobante tc \n"
                + "join fetch tc.categoriacomprobante as cc"
                ;

        session.getTransaction().commit();
        a =   (ArrayList<Tipocomprobante>) session.createQuery(sql).list();
        session.close();
        return a;    }
    
    
    @Override
    public List<Tipocomprobante> listarTipoComprobantexCategoria(String categoria) {
        List<Tipocomprobante> a = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String sql = "from Tipocomprobante tc \n"
                + "join fetch tc.categoriacomprobante as cc "
                + " where cc.descripcion = '"+categoria+"'"
                ;

        session.getTransaction().commit();
        a =   (ArrayList<Tipocomprobante>) session.createQuery(sql).list();
        session.close();
        return a;    }
}
