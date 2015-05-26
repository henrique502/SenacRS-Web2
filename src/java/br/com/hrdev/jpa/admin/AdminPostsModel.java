package br.com.hrdev.jpa.admin;

import br.com.hrdev.entidades.Post;
import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.jpa.Model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author 180901954
 */
public class AdminPostsModel extends Model {
    
    public Long getTotalPosts(String term) {
        Long total = 0L;
        try {
            db.getTransaction().begin();
            
            Query query;
            if(term.length() > 0){
                query = db.createNamedQuery(Post.FindByTitulo);
                query.setParameter("term", "%" + term.toLowerCase() + "%");
            } else {
                query = db.createNamedQuery(Post.FindAll);
            }
            
            total = (Long) query.getSingleResult();

            db.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            db.getTransaction().rollback();
        }
        return total;
    }
    
    public List<Post> getPosts(int page, String term, int per_page) {
        List<Post> lista = new ArrayList<>();
        try {
            db.getTransaction().begin();
            
            Query query;
            if(term.length() > 0){
                query = db.createNamedQuery(Post.FindByTitulo);
                query.setParameter("term", "%" + term.toLowerCase() + "%");
            } else {
                query = db.createNamedQuery(Post.FindAll);
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
    
    public List<Usuario> getAutores() {
        List<Usuario> lista = new ArrayList<>();
        try {
            db.getTransaction().begin();
            
            Query query = db.createQuery("SELECT u FROM Usuario u WHERE u.acessos = :acesso ORDER BY u.nome ASC");
            query.setParameter("acesso", true);
            lista = query.getResultList();
            
            db.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            db.getTransaction().rollback();
        }
        return lista;
    }

    public boolean insertPost(Post post) {
        try {
            db.getTransaction().begin();
            db.persist(post);
            db.getTransaction().commit();
        } catch (Exception e){
            db.getTransaction().rollback();
            throw e;
        }
        return true;
    }

    public Post getPostById(Integer postId) {
        Post post = null;
        try {
            db.getTransaction().begin();
            Query query = db.createQuery("SELECT p FROM Post p WHERE p.id = :postId");
            query.setMaxResults(1);
            query.setParameter("postId", postId);
            post = (Post) query.getSingleResult();
            db.getTransaction().commit();
        } catch (Exception e){
            db.getTransaction().rollback();
            throw e;
        }
        
        return post;
    }

    public boolean updatePost(Post post) {
        try {
            db.getTransaction().begin();
            db.merge(post);
            db.getTransaction().commit();
        } catch (Exception e){
            db.getTransaction().rollback();
            throw e;
        }
        return true;
    }
    
    public boolean deletePost(Post post) {
        try {
            db.getTransaction().begin();
            post = db.find(Post.class, post.getId());
            db.remove(post);
            db.getTransaction().commit();
        } catch (Exception e){
            db.getTransaction().rollback();
            throw e;
        }
        return true;
    }
}