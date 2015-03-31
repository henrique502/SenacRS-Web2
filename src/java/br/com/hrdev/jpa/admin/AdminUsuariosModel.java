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
    
    public Long getTotalUsuarios() {
        Long total = 0L;
        try {
            db.getTransaction().begin();
            
            Query query = db.createQuery("SELECT COUNT(u.id) FROM Usuario u");
            total = (Long) query.getSingleResult();

            db.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            db.getTransaction().rollback();
        }
        return total;
    }
    
    public List<Usuario> getUsuarios(int page, int per_page) {
        List<Usuario> lista = new ArrayList<>();
        try {
            db.getTransaction().begin();
            
            Query query = db.createQuery("SELECT u FROM Usuario u");
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
}
