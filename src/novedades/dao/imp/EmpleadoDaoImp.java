/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import novedades.dao.EmpleadoDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Usuario;

/**
 *
 * @author joel
 */
public class EmpleadoDaoImp extends Conexion implements EmpleadoDao{

    

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
    public void upDateEmpleado(Empleado a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(a);
//        session.update(a);
        session.getTransaction().commit();
        session.close();
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
    public Set<Concepto> getConcepto(int idConcepto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public Empleado getEmpleadoAdministrador(int legajo, boolean adm, String contrasenias) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

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
    
}
