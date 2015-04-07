package br.com.hrdev.beans.admin;

import br.com.hrdev.entidades.Post;
import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.helpers.MensagensHelper;
import br.com.hrdev.jpa.admin.AdminPostsModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 180901954
 */
@ManagedBean
@RequestScoped
public class AdminPostsEditarBean {

    private List<Usuario> listaAutores;
    private AdminPostsModel model = null;
    private Integer autorSelecionado = null;
    private Post post;
    
    public AdminPostsEditarBean() {
        if(model == null){
            setup();
        }
    }

    private void setup() {
        model = new AdminPostsModel();
        model.connect();
        try {
            post = model.getPostById(getPostId());
            autorSelecionado = post.getAutor().getId();
            listaAutores = model.getAutores();
        } finally {
            model.close();
        }
    }
    
    private Integer getPostId(){
        Integer id = 0;
        try {
            String p = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("postId");
            if (p != null) {
                id = Integer.parseInt(p);
            }
        } catch (Exception e) {}
        return id;
    }

    public List<Usuario> getListaAutores() {
        return listaAutores;
    }

    public Integer getAutorSelecionado() {
        return autorSelecionado;
    }

    public void setAutorSelecionado(Integer autorSelecionado) {
        this.autorSelecionado = autorSelecionado;
    }

    public Post getPost() {
        return post;
    }
    
    public String salvarPost(){
        boolean status = false;
        model.connect();

        try {
            status = model.updatePost(post);
        } catch(Exception e){
            MensagensHelper.addError("Falha ao atualizar o post: " + e.getMessage());
        } finally {
            model.close();
        }
        
        if(status){
            MensagensHelper.addInfo("Post atualizado com sucesso");
            return "/admin/posts/index";
        } else {
            return "/admin/posts/editar?postId=" + post.getId();
        }
    }
}
