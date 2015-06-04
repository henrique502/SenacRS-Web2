/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hrdev.jpa;

import br.com.hrdev.entidades.Comentario;
import br.com.hrdev.entidades.Post;
import br.com.hrdev.entidades.Usuario;
import static br.com.hrdev.jpa.Model.db;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author henriqueschmidt
 */
public class PostModel extends Model {
    
    
    public Post getPostById(Integer postId){
        Post post = null;
        
        try {
            Query query = db.createNamedQuery(Post.GetPostById);
            query.setParameter("postId", postId);
            post = (Post) query.getSingleResult();
        } catch(Exception e){
            e.printStackTrace();
        }

        return post;
    }
    
    public List<Comentario> getComentariosByPost(Integer postId) {
        List<Comentario> lista = new ArrayList<>();
        try {
            db.getTransaction().begin();
            
            Query query = db.createNamedQuery(Comentario.GetAllByPost);
            query.setParameter("postId", postId);
            lista = query.getResultList();
            
            db.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            db.getTransaction().rollback();
        }
        return lista;
    }

    public void saveComentario(Comentario comentario) {
        try {
            db.getTransaction().begin();
            db.persist(comentario);
            db.getTransaction().commit();
        } catch (Exception e){
            db.getTransaction().rollback();
            throw e;
        }
    }
    
}
