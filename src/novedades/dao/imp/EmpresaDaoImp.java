/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;
import java.util.List;
import novedades.dao.EmpresaDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Empresa;

/**
 *
 * @author usuario
 */
public class EmpresaDaoImp extends Conexion implements EmpresaDao{

    @Override
    public List<Empresa> listarEmpresa() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empresa.class);
        List<Empresa> lista = (List<Empresa>)criteria.list();
        session.getTransaction().commit();        
        session.close();
        return lista;
    }

    @Override
    public void addEmpresa(Empresa a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteEmpresa(Empresa a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upDateEmpresa(Empresa a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Empresa getEmpresa(int cod_emp) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Empresa a = (Empresa) session.get(Empresa.class,cod_emp);
        session.getTransaction().commit();
        session.close();
        return a;
    }
    
}
