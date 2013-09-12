/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import novedades.Novedades;
import novedades.dao.EmpleadoDao;
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
public class EmpleadoDaoImp extends Conexion implements EmpleadoDao {

    @Override
    public void addEmpleado(Empleado a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteEmpleado(Empleado a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<Concepto> getConcepto(int idConcepto) {
        Set<Concepto> setConcepto = new HashSet<Concepto>();
       Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Empleado a = (Empleado) session.get(Empleado.class, idConcepto);
        if (a!=null) {
            setConcepto = a.getNovedads();
        }else{
            setConcepto= null;
        }
        
        session.getTransaction().commit();
        session.close();
        return setConcepto;
    }

    @Override
    public Empleado getEmpleado(int idEmpleado) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Empleado a = (Empleado) session.get(Empleado.class, idEmpleado);
        session.getTransaction().commit();
        session.close();
        return a;
    }

    @Override
    public Empleado getEmpleadoAdministrador(int legajo, boolean adm, String contrasenia) {
        Empleado e = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
        criteria.add(Restrictions.eq("Legajo", legajo));
        criteria.add(Restrictions.eq("administrador", adm));
        criteria.add(Restrictions.eq("clave", contrasenia));
        
        List<Empleado> lista = (List<Empleado>)criteria.list();
        if (lista.size()!=0) {
            e = lista.get(0);
        }         
        session.getTransaction().commit();
        session.close();
        return e;
    }

    @Override
    public Empleado getEmpleadoLegajo(int legajo) {
        Empleado e = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
        criteria.add(Restrictions.eq("legajo", legajo));
        List<Empleado> lista = (List<Empleado>)criteria.list();
        if (lista.size()!=0) {
            e = lista.get(0);
        }         
        session.getTransaction().commit();
        session.close();
        return e;
    }

    @Override
    public List<Empleado> listarEmpleado() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
//        criteria.addOrder(Order.asc("legajo"));
        List<Empleado> lista = (List<Empleado>)criteria.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    @Override
    public List<Empleado> listarEmpleadoAdministradores() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
        criteria.add(Restrictions.eq("administrador", true));
        criteria.addOrder(Order.asc("legajo"));
        List<Empleado> lista = (List<Empleado>)criteria.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    @Override
    public void upDateEmpleado(Empleado a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(a);
//        session.update(a);
        session.getTransaction().commit();
        session.close();
    }
    
}
