package br.com.hrdev.beans;

import br.com.hrdev.entidades.Comentario;
import br.com.hrdev.entidades.Post;
import br.com.hrdev.jpa.PostModel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author henriqueschmidt
 */
@ManagedBean
@RequestScoped
public class PostBean {
    
    private PostModel model;
    private Post post = null;
    
    public PostBean() {
        model = new PostModel();
        setup();
    }
    
    private void setup() {
        if(post == null){
            try {
                model.connect();
                post = model.getPostById(getPostId());
            } finally {
                model.close();
            }
            
        }
    }
    
    private Integer getPostId(){
        Integer id = 0;
        try {
            String p = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("postId");
            if(p != null)
                id = Integer.parseInt(p);
        } catch(Exception e) {}

        return id;
    }
    
    public Post getPost(){
        return post;
    }
    
    public List<Comentario> getComentarios(){
        return new ArrayList<Comentario>();
    }
}
