package br.com.hrdev.jpa;

import br.com.hrdev.entidades.viwes.ViewPost;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author henriqueschmidt
 */
public class HomeModel extends Model {
    
    public HomeModel(){
        super();
    }
    
    public Long getTotalPosts(){
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
    
    public List<ViewPost> getPosts(int page, int per_page){
        List<ViewPost> lista = new ArrayList<>();
        try {
            db.getTransaction().begin();
            
            Query query = db.createQuery("SELECT v FROM ViewPost v");
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
