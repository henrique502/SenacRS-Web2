package br.com.hrdev.beans.admin;

import br.com.hrdev.entidades.Post;
import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.helpers.MensagensHelper;
import br.com.hrdev.jpa.admin.AdminPostsModel;
import br.com.hrdev.jpa.admin.AdminUsuariosModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 180901954
 */
@ManagedBean
@RequestScoped
public class AdminUsuariosRemoverBean {
    
    private AdminUsuariosModel model = null;
    private Usuario usuario;
    
    public AdminUsuariosRemoverBean() {
        if(model == null){
            setup();
        }
    }
    
    private void setup() {
        model = new AdminUsuariosModel();
        model.connect();
        try {
            usuario = model.getUsuarioById(getUsuarioId());
        } finally {
            model.close();
        }
    }
    
    private Integer getUsuarioId(){
        Integer id = 0;
        try {
            String p = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("usuarioId");
            if (p != null) {
                id = Integer.parseInt(p);
            }
        } catch (Exception e) {}
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public String removerUsuario(){
        boolean status = false;
        model.connect();

        try {
            status = model.deleteUsuario(usuario);
        } catch(Exception e){
            MensagensHelper.addError("Falha ao remover o usuário: " + e.getMessage());
        } finally {
            model.close();
        }
        
        if(status){
            MensagensHelper.addInfo("Usuário removido com sucesso");
            return "/admin/usuarios/index";
        } else {
            return "/admin/usuarios/remover?usuarioId=" + usuario.getId();
        }
    }
}
