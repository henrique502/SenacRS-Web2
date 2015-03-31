package br.com.hrdev.jpa.admin;

import br.com.hrdev.entidades.Post;
import br.com.hrdev.jpa.Model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author 180901954
 */
public class AdminPostsModel extends Model {
    
    public Long getTotalPosts() {
        Long total = 0L;
        try {
            db.getTransaction().begin();
            
            Query query = db.createQuery("SELECT COUNT(p.id) FROM Post p");
            total = (Long) query.getSingleResult();

            db.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            db.getTransaction().rollback();
        }
        return total;
    }
    
    public List<Post> getPosts(int page, int per_page) {
        List<Post> lista = new ArrayList<>();
        try {
            db.getTransaction().begin();
            
            Query query = db.createQuery("SELECT p FROM Post p");
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
