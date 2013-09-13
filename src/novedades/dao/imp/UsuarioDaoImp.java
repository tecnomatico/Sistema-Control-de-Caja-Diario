/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;
import static hibernateUtil.Conexion.getSessionFactory;
import java.util.List;
import novedades.dao.UsuarioDao;
import org.hibernate.Session;
import pojo.Usuario;

/**
 *
 * @author usuario
 */
public class UsuarioDaoImp extends Conexion implements UsuarioDao{

    @Override
    public List<UsuarioDao> listarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        public void deleteUsuario(UsuarioDao a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

        public void upDateUsuario(UsuarioDao a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDao getUsuario(int legajo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
