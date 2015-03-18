package br.com.hrdev;

import br.com.hrdev.entidades.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class ConfigBean {

    private Teste teste;
 
    public ConfigBean() {
        teste = new Teste();
    }
 
    
    public List<Usuario> getUsuarios(){
        return teste.selectAllUsuarios();
    }
}
