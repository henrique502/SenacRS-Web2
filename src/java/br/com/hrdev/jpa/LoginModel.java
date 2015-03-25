package br.com.hrdev.jpa;

import br.com.hrdev.entidades.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author henriqueschmidt
 */
public class LoginModel extends Model {
    
    public LoginModel(){
        super();
    }
    
    public Usuario getUsuarioByLogin(String email, String senha){
        Usuario usuario = null;
        
        try {
            
            Query query = db.createNamedQuery(Usuario.FIND_BY_EMAIL_SENHA);
            
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            
            List result = query.getResultList();

            if(result.size() == 1)
                usuario = (Usuario) result.get(0);
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return usuario;
    }
}
