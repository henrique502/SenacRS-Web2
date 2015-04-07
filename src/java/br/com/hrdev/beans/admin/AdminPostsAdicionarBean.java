package br.com.hrdev.beans.admin;

import br.com.hrdev.beans.SessionBean;
import br.com.hrdev.entidades.Post;
import br.com.hrdev.entidades.Usuario;
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
    private Usuario autorSelecionado = null;

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
    
    public Usuario getAutorSelecionado() {
        if(autorSelecionado == null){
            autorSelecionado = session.getUsuario();
        }
        return autorSelecionado;
    }

    public void setAutorSelecionado(Usuario autorSelecionado) {
        this.autorSelecionado = autorSelecionado;
    }
    
    public String adicionarPost(Post post){
        System.out.println(post.getTitulo());
        System.out.println(post.getData());
        System.out.println(post.getConteudo());
        System.out.println(getAutorSelecionado().getNome());
        return "/admin/posts/adicionar";
    }
}
