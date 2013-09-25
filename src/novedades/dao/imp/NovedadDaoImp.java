/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;
import java.util.ArrayList;
import java.util.List;
import novedades.dao.NovedadDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Novedad;
import pojo.Usuario;

/**
 *
 * @author usuario
 */
public class NovedadDaoImp extends Conexion implements NovedadDao {

    @Override
    public List<Novedad> listarNovedad(Empleado o) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Novedad.class);
        ArrayList<Novedad> novedad = (ArrayList<Novedad>)criteria.list();
        session.close();
        return novedad;
    }

    @Override
    public Empleado getEmpleado(Empleado a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Empleado e = (Empleado) session.get(Empleado.class,a);
        session.getTransaction().commit();
        session.close();
        return e;
    }

    @Override
    public void deleteEmpleado(Empleado a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void upDateEmpleado(Empleado a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Concepto getConcepto(Concepto e) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Concepto con = (Concepto) session.get(Usuario.class,e);
        session.getTransaction().commit();
        session.close();
        return con; 
    }
    
}
