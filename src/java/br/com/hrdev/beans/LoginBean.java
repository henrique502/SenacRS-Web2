package br.com.hrdev.beans;

import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.helpers.HashHelper;
import br.com.hrdev.helpers.MensagensHelper;
import br.com.hrdev.jpa.LoginModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author henriqueschmidt
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    
    LoginModel model;
    
    @ManagedProperty(value="#{sessionBean}")
    private SessionBean session;
    
    public LoginBean() {
        model = new LoginModel();
    }

    public String validaLogin(Usuario u) {
        Usuario usuario = null;
        try {
            model.connect();
            usuario = model.getUsuarioByLogin(u.getEmail(), HashHelper.md5(u.getSenha()));
        } finally {
            model.close();
        }

        if (usuario != null){
            
            session.setUsuario(usuario);
            
            if(usuario.getAcessos()){
                return "admin/index";
            } else {
                return "index";
            }
        } else {
            MensagensHelper.addError(MensagensHelper.get("login_invalid"));
        }

        return "login";
    }

    public SessionBean getSession() {
        return session;
    }

    public void setSession(SessionBean session) {
        this.session = session;
    }
}
