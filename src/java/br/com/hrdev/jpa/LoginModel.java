package br.com.hrdev.jpa;

import br.com.hrdev.entidades.Usuario;
import javax.persistence.Query;

/**
 *
 * @author henriqueschmidt
 */
public class LoginModel extends Model {
    
    public Usuario getUsuarioByLogin(String email, String senha){
        Usuario usuario = null;
        
        try {
            
            Query query = db.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class);
            
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            
            usuario = (Usuario) query.getSingleResult();

            if(usuario == null)
                return null;
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return usuario;
    }
}
