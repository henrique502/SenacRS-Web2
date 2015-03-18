package br.com.hrdev;

import br.com.hrdev.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
    
    private EntityManagerFactory factory;
    private EntityManager manager;
    
    public void connect(){
        factory = Persistence.createEntityManagerFactory("SenacRS-Web2PU");
        manager = factory.createEntityManager();
    }
    
    public void close(){
        manager.close();
        factory.close();
    }
    
    public void insertUsuario(Usuario usuario){
        connect();
        
        try {
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
    }
    
    public Usuario selectUsuarioById(int usuarioId){
        connect();
        Usuario usuario = null;
        
        try {
            manager.getTransaction().begin();
            usuario = manager.find(Usuario.class, usuarioId);
            manager.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        
        return usuario;
    }
    
    public List<Usuario> selectAllUsuarios(){
        connect();
        List<Usuario> lista = new ArrayList<Usuario>();
        
        try {
            manager.getTransaction().begin();
            
            lista = manager.createQuery("SELECT u FROM Usuario u ORDER BY u.nome ASC").getResultList();
            
            manager.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        
        return lista;
    }
}
