package br.com.hrdev.beans.admin;

import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.helpers.MensagensHelper;
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
public class AdminUsuariosEditarBean {
    
    private Usuario usuario;
    private AdminUsuariosModel model;
    
    
    public AdminUsuariosEditarBean() {
        if(model == null){
            setup();
        }
    }
    
    private void setup(){
        model = new AdminUsuariosModel();
        model.connect();
        
        try{
            usuario = model.getUsuarioById(getUserId());
        } finally{
            model.close();
        }
    }
    
     public Usuario getUsuario(){
        return this.usuario;
    }
    
    private Integer getUserId(){
        Integer id = 0;
        try {
            String p = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("usuarioId");
            if (p != null) {
                id = Integer.parseInt(p);
            }
        } catch (Exception e) {}
        return id;
    }
    
    public String salvarUser(){
        boolean status = false;
        model.connect();

        try {
            status = model.updateUsuario(usuario);
        } catch(Exception e){
            MensagensHelper.addError("Falha ao atualizar o usuário: " + e.getMessage());
        } finally {
            model.close();
        }
        
        if(status){
            MensagensHelper.addInfo("Usuário atualizado com sucesso");
            return "/admin/usuarios/index";
        } else {
            return "/admin/usuarios/editar?usuarioId=" + usuario.getId();
        }
    }
    
}
