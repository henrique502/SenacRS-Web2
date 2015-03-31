package br.com.hrdev.helpers;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author henriqueschmidt
 */
public class MensagensHelper {

    public static void addError(String erro) {
        addError(erro, null);
    }
    
    public static void addError(String erro, String detalhes) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, detalhes));
    }
    
    public static void addInfo(String info) {
        addInfo(info, null);
    }
    
    public static void addInfo(String info, String detalhes) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, info, detalhes));
    }
    
    public static String get(String key) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ResourceBundle bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle());
            return bundle.getString(key);
        } catch(Exception e){
            System.err.println(e.getMessage());
            return key;
        }
    }
}
