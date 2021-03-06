package br.com.hrdev.jpa.admin;

import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.jpa.Model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author 180901954
 */
public class AdminUsuariosModel extends Model {

    public AdminUsuariosModel() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Long getTotalUsuarios(String term) {
        Long total = 0L;
        try {
            db.getTransaction().begin();
            
            Query query;
            if(term.length() > 0){
                query = db.createNamedQuery(Usuario.CountByNameOrEmail);
                query.setParameter("term",  "%" + term.toLowerCase() + "%");
            } else {
                query = db.createNamedQuery(Usuario.CountAll);
            }
            total = (Long) query.getSingleResult();

            db.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            db.getTransaction().rollback();
        }
        return total;
    }
    
    public List<Usuario> getUsuarios(int page, String term, int per_page) {
        List<Usuario> lista = new ArrayList<>();
        try {
            db.getTransaction().begin();
            Query query;
            
            if(term.length() > 0){
                query = db.createNamedQuery(Usuario.FindByNameOrEmail);
                query.setParameter("term", "%" + term.toLowerCase() + "%");
            } else {
                query = db.createNamedQuery(Usuario.FindAll);
            }
            
            query.setFirstResult(page);
            query.setMaxResults(per_page);
            lista = query.getResultList();
            
            db.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            db.getTransaction().rollback();
        }
        return lista;
    }
    
    public boolean insertUsuario(Usuario usuario) {
        try {
            db.getTransaction().begin();
            db.persist(usuario);
            db.getTransaction().commit();
        } catch (Exception e){
            db.getTransaction().rollback();
            throw e;
        }
        return true;
    }

    public Usuario getUsuarioById(Integer usuarioId) {
        Usuario usuario = null;
        try {
            db.getTransaction().begin();
            Query query = db.createQuery("SELECT u FROM Usuario u WHERE u.id = :usuarioId", Usuario.class);
            query.setMaxResults(1);
            query.setParameter("usuarioId", usuarioId);
            usuario = (Usuario) query.getSingleResult();
            db.getTransaction().commit();
        } catch (Exception e){
            db.getTransaction().rollback();
            throw e;
        }
        
        return usuario;
    }

    public boolean updateUsuario(Usuario usuario) {
        try {
            db.getTransaction().begin();
            db.merge(usuario);
            db.getTransaction().commit();
        } catch (Exception e){
            db.getTransaction().rollback();
            throw e;
        }
        return true;
    }
    
    public boolean deleteUsuario(Usuario usuario) {
        try {
            db.getTransaction().begin();
            usuario = db.find(Usuario.class, usuario.getId());
            db.remove(usuario);
            db.getTransaction().commit();
        } catch (Exception e){
            db.getTransaction().rollback();
            throw e;
        }
        return true;
    }
}