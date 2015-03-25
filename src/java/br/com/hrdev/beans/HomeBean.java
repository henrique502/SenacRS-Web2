package br.com.hrdev.beans;

import br.com.hrdev.entidades.viwes.ViewPost;
import br.com.hrdev.helpers.PaginationHelper;
import br.com.hrdev.helpers.PaginationHelper.Pagination;
import br.com.hrdev.jpa.HomeModel;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author henriqueschmidt
 */
@ManagedBean
@RequestScoped
public class HomeBean {
    
    public static final int PER_PAGE = 3;
    
    private HomeModel model;
    private Map<String, String> params;
    private static FacesContext context;
    
    public HomeBean(){
        context = FacesContext.getCurrentInstance();
        model = new HomeModel();
        params = context.getExternalContext().getRequestParameterMap();
    }
    
    private int getIndex(int page){
        return (page - 1) * PER_PAGE;
    }
    
    private Integer getPage(){
        try {
            String p = params.get("page");
            if(p != null)
                return Integer.parseInt(p);
        } catch(Exception e) {}
        return 0;
    }
    
    public List<ViewPost> getPosts() {
        return model.getPosts((getPage() - 1) * PER_PAGE, PER_PAGE);
    }

    public Pagination getPagination() {
        Long total = model.getTotalPosts();
        return new PaginationHelper().get(3, PER_PAGE, getPage(), total);
    }   
}