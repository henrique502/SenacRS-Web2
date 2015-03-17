/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hrdev;

import br.com.hrdev.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@ManagedBean
@RequestScoped
public class ConfigBean {
    
    static EntityManagerFactory emf;
    static EntityManager em;
    static SessionFactory factory;
    
    public ConfigBean() {
        /* Temos bugs 
        try {
            
            emf = Persistence.createEntityManagerFactory("SenacRS-Web2PU");
            EntityManager em = emf.createEntityManager();
            
            Configuration configuration = new Configuration().configure();
            //StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(emf.getProperties());
            factory = configuration.buildSessionFactory();
        } catch(HibernateException e){
            e.printStackTrace();
        }
                */
    }
    
    public List<Usuario> getUsuarios(){
        
        return new ArrayList<Usuario>();
        /*
        Session session = factory.openSession();
        Transaction tx = null;
        List<Usuario> lista = null;
        
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Usuarios");
            lista = (List<Usuario>) query.list();
            tx.commit();
        } catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            emf.close(); // temp
            em.close();
        }
        
        return lista;
                
                */
    }
    
}
