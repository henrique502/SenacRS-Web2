package br.com.hrdev.beans;

import br.com.hrdev.entidades.Usuario;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author henriqueschmidt
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    private Usuario user;
    private boolean hasLogged;
    private static UsuarioBean instance;
    
    public UsuarioBean() {}
    
    public static UsuarioBean getInstance() throws Exception {
        if(instance == null){
            throw new Exception("Usuário não logado");
        }
        
        return instance;
    }

    public Usuario getUser() {
        return user;
    }

    public boolean hasLogged() {
        return hasLogged;
    }

    public void login(Usuario user){
        this.user = user;
    }
    
    public void logoff(){
        this.user = null;
    }
    
    public String redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
        return "";
    }
    
    
}
