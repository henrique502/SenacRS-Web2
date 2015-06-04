package br.com.hrdev.beans;

import br.com.hrdev.entidades.Comentario;
import br.com.hrdev.entidades.Post;
import br.com.hrdev.helpers.MensagensHelper;
import br.com.hrdev.jpa.PostModel;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    private List<Comentario> listaComentario;
    
    @ManagedProperty(value="#{sessionBean}")
    private SessionBean session;
    
    public PostBean() {
        model = new PostModel();
        setup();
    }
    
    private void setup() {
        if(post == null){
            try {
                model.connect();
                post = model.getPostById(getPostId());
                listaComentario = model.getComentariosByPost(post.getId());
                System.err.println(post.getId());
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
        return listaComentario;
    }
    
    public String setComentario(Comentario comentario){
        Integer postId = getPostId();
        if(postId <= 0) return null;
        
        if(session.isLogged()){
            System.out.println(comentario.getComentario());
            
            comentario.setData(new Date());
            comentario.setPost(getPost());
            comentario.setUsuario(session.getUsuario());
            
            try {
                model.connect();
                model.saveComentario(comentario);
                MensagensHelper.addInfo("Comentário feito com sucesso");
            } finally {
                model.close();
            }
        } else {
            MensagensHelper.addError("Você não esta logado!");
        }

        return "/post?faces-redirect=true&postId=" + getPostId();
    }
    
    public SessionBean getSession() {
        return session;
    }

    public void setSession(SessionBean session) {
        this.session = session;
    }
}
