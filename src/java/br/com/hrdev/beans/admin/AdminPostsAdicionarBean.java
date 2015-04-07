package br.com.hrdev.beans.admin;

import br.com.hrdev.beans.SessionBean;
import br.com.hrdev.entidades.Post;
import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.helpers.MensagensHelper;
import br.com.hrdev.jpa.admin.AdminPostsModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Eduardo
 */
@ManagedBean
@RequestScoped
public class AdminPostsAdicionarBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean session;

    private List<Usuario> listaAutores;
    private AdminPostsModel model = null;
    private Integer autorSelecionado = null;

    public AdminPostsAdicionarBean() {
        if (model == null) {
            setup();
        }
    }

    private void setup() {
        model = new AdminPostsModel();
        model.connect();

        try {
            listaAutores = model.getAutores();
        } finally {
            model.close();
        }
    }
    
     public SessionBean getSession() {
        return session;
    }

    public void setSession(SessionBean session) {
        this.session = session;
    }
    
    public List<Usuario> getListaAutores() {
        return listaAutores;
    }
    
    public Integer getAutorSelecionado() {
        if(autorSelecionado == null){
            autorSelecionado = session.getId();
        }
        return autorSelecionado;
    }

    public void setAutorSelecionado(Integer autorSelecionado) {
        this.autorSelecionado = autorSelecionado;
    }
    
    public String adicionarPost(Post post){
        post.setAutor(new Usuario(autorSelecionado));
        boolean status = false;
        model.connect();

        try {
            status = model.insertPost(post);
        } catch(Exception e){
            MensagensHelper.addError("Falha ou inserir o post: " + e.getMessage());
        } finally {
            model.close();
        }
        
        if(status){
            MensagensHelper.addInfo("Post inserido com sucesso");
            return "/admin/posts/index";
        } else {
            return "/admin/posts/adicionar";
        }
    }
}
