package br.com.hrdev.converters;

import br.com.hrdev.beans.admin.AdminPostsAdicionarBean;
import br.com.hrdev.entidades.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 180901954
 */
@FacesConverter(value = "AdminPostsAdicionarConverter")
public class AdminPostsAdicionarConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        if(value == null)
            return null;
        
        AdminPostsAdicionarBean bean = context.getApplication().evaluateExpressionGet(context, "#{adminPostsAdicionarBean}", AdminPostsAdicionarBean.class);
        try {
            Integer usuarioId = Integer.parseInt(value);
            // return bean.getAutorById(usuarioId);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String string = null;
        if (value instanceof Usuario){
            string = ((Usuario) value).getNome();
        }
        return string;
    }
}
