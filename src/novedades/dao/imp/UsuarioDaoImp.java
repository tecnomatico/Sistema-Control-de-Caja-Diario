/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;
import static hibernateUtil.Conexion.getSessionFactory;
import java.util.List;
import novedades.dao.UsuarioDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Empleado;
import pojo.Usuario;

/**
 *
 * @author usuario
 */
public class UsuarioDaoImp extends Conexion implements UsuarioDao{

    @Override
    public List<Usuario> listarUsuario() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
//        criteria.addOrder(Order.asc("legajo"));
        List<Usuario> lista = (List<Usuario>)criteria.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    /**
     *
     * @param a
     */
    @Override
        public void addUsuario(Usuario a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
        public void deleteUsuario(Usuario a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }
    @Override
        public void upDateUsuario(Usuario a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(a);
//        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
        public Usuario getUsuario(int legajo) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Usuario a = (Usuario) session.get(Empleado.class, legajo);
        session.getTransaction().commit();
        session.close();
        return a;
    }

    
    
}
