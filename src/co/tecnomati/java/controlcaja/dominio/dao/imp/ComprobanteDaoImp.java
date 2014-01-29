/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;

import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.ComprobanteDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import co.tecnomati.java.controlcaja.util.MyUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Joel
 */
public class ComprobanteDaoImp extends HibernateUtil implements ComprobanteDAO {

    @Override
    public List<Comprobante> listarFormulario() {

        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comprobante.class);

        ArrayList<Comprobante> comprobante = (ArrayList<Comprobante>) session.createQuery("FROM Comprobante c\n"
                + "join fetch c.tipocomprobante  as tipo\n"
                + "join fetch c.comprobanteconceptos as cc\n"
                + "join fetch cc.concepto as concep\n"
                + "order by c.id asc and c.fecha asc\n"
                ).list();
        session.close();
        return comprobante;
    }
    @Override
    public List<Comprobante> listarFormularioActivo() {

        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comprobante.class);

        ArrayList<Comprobante> comprobante = (ArrayList<Comprobante>) session.createQuery("FROM Comprobante c\n"
                + "join fetch c.tipocomprobante  as tipo\n"
                + "join fetch c.comprobanteconceptos as cc\n"
                + "join fetch cc.concepto as concep\n"
                +" where c.estado=1 \n"
                + "order by c.id asc and c.fecha asc\n"
              ).list();
        session.close();
        return comprobante;
    }

    @Override
    public void addFormulario(Comprobante a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
//        session.flush();
        session.close();
    }

    @Override
    public void deleteFormulario(Comprobante a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateFormulario(Comprobante a) {
//       Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    /**
     *
     * @param idComprobante
     * @return trae el comprobante pero no sus atributos que son objetos
     * persisntentes. ej: no trae la coleccion de comprobanteconcepto ni el
     * atributo tipocomporbante
     */
    @Override
    public Comprobante getFormulario(int idComprobante) {
 Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comprobante.class);

        Comprobante comprobante = (Comprobante) session.createQuery("FROM Comprobante c\n"
                + "join fetch c.tipocomprobante  as tipo\n"
                + "join fetch c.comprobanteconceptos as cc\n"
                + "join fetch cc.concepto as concep\n"
                + "where c.id = '"+idComprobante+"' \n"
                ).uniqueResult();
        session.close();
        return comprobante;
    }

    @Override
    public Tipocomprobante getTipocomprobante(int idComprobante) {
//       Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Comprobante a = (Comprobante) session.get(Comprobante.class, idComprobante);
        Tipocomprobante tipoCom = a.getTipocomprobante();
        session.getTransaction().commit();
        session.close();
        return tipoCom;
    }

    @Override
    public Set<Comprobanteconcepto> listarConcepto(int idComprobante) {

//     Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Comprobante a = (Comprobante) session.get(Comprobante.class, idComprobante);
        Set<Comprobanteconcepto> conjuntoConceptos = a.getComprobanteconceptos();
        session.getTransaction().commit();
        session.close();

        return conjuntoConceptos;

    }

    @Override
    public List<Comprobante> listarFormularioxCategoria(String categoria) {

        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comprobante.class);

        ArrayList<Comprobante> comprobante = (ArrayList<Comprobante>) session.createQuery("FROM Comprobante c\n"
                + "join fetch c.tipocomprobante  as tipocomprobante\n"
                + "join fetch c.comprobanteconceptos as comprobanteconcepto\n"
                + "join fetch comprobanteconcepto.concepto as concepto\n"
                + "join fetch tipocomprobante.categoriacomprobante as categoria\n"
                + "where categoria.descripcion='" + categoria + "'"
              ).list();
        session.close();
        return comprobante;
    }

    @Override
    public List<Comprobante> listarFormularioxFechaHQl(Date desde, Date hasta) {
        Session session = HibernateUtil.getSession();

        String desdeS = MyUtil.getFechaString10AAAAMMDD(desde);
        String hastaS = MyUtil.getFechaString10AAAAMMDD(hasta);
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comprobante.class);

        ArrayList<Comprobante> comprobante = (ArrayList<Comprobante>) session.createQuery("FROM Comprobante c\n"
                + "join fetch c.tipocomprobante  as tipo\n"
                + "join fetch c.comprobanteconceptos as cc\n"
                + "join fetch cc.concepto as conce\n"
                + "join fetch tipo.categoriacomprobante as categ\n"
                + "where c.fecha<='" + hastaS + "' and c.fecha>='" + desdeS + "'"
                ).list();
        session.close();
        return comprobante;
    }

    @Override
    public List<Comprobante> listarFormularioxFecha(Date desde, Date hasta) {
//        Session session = HibernateUtil.getSession();
//
//        session.beginTransaction();
//        Criteria criteria = session.createCriteria(Comprobante.class);
//
//        ArrayList<Comprobante> comprobante = (ArrayList<Comprobante>) session.createQuery("FROM Comprobante c\n"
//                + "join fetch c.tipocomprobante  as tipo\n"
//                + "join fetch c.comprobanteconceptos as cc\n"
//                + "join fetch cc.concepto as conce\n"
//                + "join fetch tipo.categoriacomprobante as categ\n"
//                + "where c.fecha<'" + hasta + "' and c.fecha>'" + desde + "'").list();
//        session.close();
//        return comprobante;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Comprobante.class);
//        criteria.addOrder(Order.asc("fecha"));

        criteria.addOrder(Order.asc("id"));
        criteria.add(Restrictions.ge("fecha", desde));
        criteria.add(Restrictions.le("fecha", hasta));
        criteria.setFetchMode("tipocomprobante", FetchMode.JOIN);
        criteria.setFetchMode("comprobanteconceptos", FetchMode.JOIN);
        criteria.setFetchMode("comprobanteconceptos.concepto", FetchMode.JOIN);
        List<Comprobante> lista = criteria.list();

        session.close();
        return lista;
    }

    @Override
    public List<Comprobante> listarFormularioxFiltro(String where) {
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comprobante.class);

        ArrayList<Comprobante> comprobante = (ArrayList<Comprobante>) session.createQuery("FROM Comprobante c\n"
                + "join fetch c.tipocomprobante  as tipocomprobante\n"
                + "join fetch c.comprobanteconceptos as comprobanteconcepto\n"
                + "join fetch comprobanteconcepto.concepto as concepto\n"
                + "join fetch tipocomprobante.categoriacomprobante as categoria\n"
                + where
               ).list();
        session.close();
        return comprobante;
    }
    /**
     *
     * @param idComprobante identificador unico del comprobante
     * @return el comprobante con todos los datos y objetos persistentes, es
     * decir sus coleecciones y objetos individuales a la que este referencie
     * esto es gracias a join fetch
     */
//    public Comprobante getComprobante(int idComprobante) {
////        Session session = HibernateUtil.getSessionFactory().openSession();
//        Session session = HibernateUtil.getSession();
//        session.beginTransaction();
//        Comprobante c = (Comprobante) session.createQuery("FROM Comprobante c\n"
//                + "join fetch c.tipocomprobante  as tipo\n"
//                + "join fetch c.comprobanteconceptos as cc\n"
//                + "join fetch cc.concepto as concep\n"
//                + "where c.id=31 ").uniqueResult();
//
//
//        session.getTransaction().commit();
//        session.close();
//        return c;
//    }
}

// si coloco este filtro en un list entonces solo se mostrarara un solo elelmento del conjunto que tenga un comprobante
// + " group by c.numeroSerie"