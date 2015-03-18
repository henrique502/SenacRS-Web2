package br.com.hrdev;

import br.com.hrdev.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class ConfigBean {

 
    public ConfigBean() {
        try {
            Teste teste = new Teste();
            teste.insertUsuario(new Usuario(Integer.SIZE, "Henrique", "henrique@conjunto.com.br", "teste", false));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
 
    
    public List<Usuario> getUsuarios(){
        return new ArrayList<Usuario>();

    }
}
