package br.com.hrdev.beans;

import br.com.hrdev.entidades.viwes.ViewPost;
import br.com.hrdev.helpers.PaginationHelper;
import br.com.hrdev.helpers.PaginationHelper.Pagination;
import br.com.hrdev.jpa.HomeModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
    
    private List<ViewPost> posts = null;
    private Pagination pagination = null;
    
    public HomeBean(){
        model = new HomeModel();
        
        setup();
    }
    
    private void setup(){
        if(posts == null){
            model.connect();
            try {
                Integer page = getPage();
                posts = model.getPosts((page - 1) * PER_PAGE, PER_PAGE);
                
                Long total = model.getTotalPosts();
                pagination = new PaginationHelper().get(PER_PAGE, page, total);
            } finally {
                model.close();
            }
        }
        System.out.println(pagination);
    }
    
    private Integer getPage(){
        Integer page = 1;
        try {
            String p = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page");
            if(p != null)
                page = Integer.parseInt(p);
        } catch(Exception e) {}
        if(page >= 1)
            return page;
        return 1;
    }
    
    public List<ViewPost> getPosts(){
        return posts;
    }

    public Pagination getPagination() {
        return pagination;
    }   
}