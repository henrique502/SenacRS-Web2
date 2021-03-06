package br.com.hrdev.beans;

import br.com.hrdev.entidades.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author henriqueschmidt
 */
@ManagedBean
@SessionScoped
public class SessionBean {
    
    private Usuario usuario;
    private boolean logged = false;

    public SessionBean() {
    
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.logged = true;
    }
        
    public String getNome(){
        if(usuario == null) return "";
        return usuario.getNome();
    }
    
    public Integer getId(){
        if(usuario == null) return null;
        return usuario.getId();
    }
    
    public boolean isLogged(){
        return this.logged;
    }
    
    public boolean isAdmin(){
        if(usuario == null) return false;
        return usuario.getAcessos();
    }
    
    public void logoff(){
        usuario = null;
        logged = false;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
}
