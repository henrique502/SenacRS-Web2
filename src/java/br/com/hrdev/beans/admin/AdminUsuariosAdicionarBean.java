package br.com.hrdev.beans.admin;

import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.helpers.MensagensHelper;
import br.com.hrdev.jpa.admin.AdminUsuariosModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 180901954
 */
@ManagedBean
@RequestScoped
public class AdminUsuariosAdicionarBean {
    
    private AdminUsuariosModel model = null;

    public AdminUsuariosAdicionarBean() {
        if (model == null) {
            setup();
        }
    }
    
    private void setup() {
        //model = new AdminUsuariosModel();
        model.connect();

        try {
            //listaAutores = model.getAutores();
        } finally {
            model.close();
        }
    }
    
    public String adicionarUsuario(Usuario user){
        boolean status = false;
        model.connect();
        //verificar Não é possível criar instância para·a classe: br.com.hrdev.beans.admin.AdminUsuariosAdicionarBean.
        try {
            status = model.insertUsuario(user);
        } catch(Exception e){
            MensagensHelper.addError("Falha ou inserir o Usuaário: " + e.getMessage());
        } finally {
            model.close();
        }
        
        if(status){
            MensagensHelper.addInfo("Usuário inserido com sucesso");
            return "/admin/usuarios/index";
        } else {
            return "/admin/usuarios/adicionar";
        }
    }
    
}
