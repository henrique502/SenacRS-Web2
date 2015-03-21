package br.com.hrdev.jpa;

import br.com.hrdev.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henriqueschmidt
 */
public class HomeModel extends Model {
    
    public List<Usuario> selectAllUsuarios(){
        List<Usuario> lista = new ArrayList<>();
        connect();
        
        try {
            getEntityManager().getTransaction().begin();
            
            lista = getEntityManager().createQuery("SELECT u FROM Usuario u ORDER BY u.nome ASC").getResultList();
            
            getEntityManager().getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        
        return lista;
    }
    
}
