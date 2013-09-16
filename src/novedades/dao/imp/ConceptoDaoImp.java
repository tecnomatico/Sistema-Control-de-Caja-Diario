/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;
import static hibernateUtil.Conexion.getSessionFactory;
import java.util.Date;
import java.util.List;
import novedades.dao.ConceptoDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import pojo.Concepto;
import pojo.Empleado;

/**
 *
 * @author usuario
 */
public class ConceptoDaoImp extends Conexion implements ConceptoDao{

    @Override
    public List<Concepto> listarConcepto() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Concepto.class);
//        criteria.addOrder(Order.asc("legajo"));
        List<Concepto> lista = (List<Concepto>)criteria.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    @Override
    
    /**
     * No se muy bien como funciona este metodo
     */
    public List<Concepto> listarAsistencia(Empleado e) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Concepto.class);
//        criteria.addOrder(Order.asc("legajo"));
        List<Concepto> lista = (List<Concepto>)criteria.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    @Override
    public void addConcepto(Concepto a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteConcepto(Concepto a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateConcepto(Concepto a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(a);
//        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Concepto getConcepto(int idAsistencia) {
        Concepto e = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Concepto.class);
        criteria.add(Restrictions.eq("ID Asistencia", idAsistencia));
        List<Concepto> lista = (List<Concepto>)criteria.list();
        if (lista.size()!=0) {
            e = lista.get(0);
        }         
        session.getTransaction().commit();
        session.close();
        return e;
    }

    @Override
    public Object[] getLegajoYNombreEmpleadoDeConcepto(int idConcepto) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Concepto a = (Concepto) session.get(Concepto.class,idConcepto);
        Empleado e = a.getApellido();
        Object[] o ={e.getLegajo(),e.getNombre()};
         session.getTransaction().commit();
        session.close();
        return o;
    }

    @Override
    public List<Concepto> listarConcepto(Date fechaInicio, Date fechaFin) {
        Session session = getSessionFactory().openSession();
          Criteria criteria = session.createCriteria(Concepto.class);
//          criteria.addOrder(Order.asc("fecha"));
         criteria.addOrder(Order.asc("idAsistencia"));
          criteria.add( Restrictions.ge("Fecha Inicio", fechaInicio) );
         criteria.add( Restrictions.le("Fecha Fin", fechaFin) ); 
         List<Concepto> lista = criteria.list();
//         session.close();
         return lista;
    }

    @Override
    public List<Concepto> listarConcepto(Empleado e, Date fechaInicio, Date fechaFin) {
        Session session = getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Concepto.class);
//        criteria.addOrder(Order.asc("fecha"));
         criteria.addOrder(Order.asc("idAsistencia"));
         criteria.add(Restrictions.eq("empleado", e));
         criteria.add( Restrictions.ge("fecha", fechaInicio) );
         criteria.add( Restrictions.le("fecha", fechaFin) ); 
         List<Concepto> lista = criteria.list();
//         session.close();
          return lista;
    }
    
}
