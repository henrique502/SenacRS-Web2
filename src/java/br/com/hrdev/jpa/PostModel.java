/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hrdev.jpa;

import br.com.hrdev.entidades.Comentario;
import br.com.hrdev.entidades.Post;
import static br.com.hrdev.jpa.Model.db;
import javax.persistence.Query;

/**
 *
 * @author henriqueschmidt
 */
public class PostModel extends Model {
    
    
    public Post getPostById(Integer postId){
        Post post = null;
        
        try {
            Query query = db.createQuery("SELECT p FROM Post p WHERE p.id = :postId", Post.class);
            query.setParameter("postId", postId);
            post = (Post) query.getSingleResult();

            if(post == null)
                return null;
            
        } catch(Exception e){
            e.printStackTrace();
        }

        return post;
    }
    
    public Comentario getComentariosByPost(Integer postId){
        Comentario comentario = null;
        
        try {
            Query query = db.createQuery("SELECT c FROM Comentario c WHERE p.id = :postId", Comentario.class);
            query.setParameter("postId", postId);
            comentario = (Comentario) query.getResultList();

            if(comentario == null)
                return null;
            
        } catch(Exception e){
            e.printStackTrace();
        }

        return comentario;
    }
    
}
