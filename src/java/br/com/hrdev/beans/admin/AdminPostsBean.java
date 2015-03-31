package br.com.hrdev.beans.admin;

import br.com.hrdev.entidades.Post;
import br.com.hrdev.helpers.PaginationHelper;
import br.com.hrdev.jpa.admin.AdminPostsModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 180901954
 */
@ManagedBean
@RequestScoped
public class AdminPostsBean {
    
    public final static int PER_PAGE = 3;
    
    private AdminPostsModel model;
    private List<Post> postLista;
    private Long postTotal;
    private PaginationHelper.Pagination pagination;

    public AdminPostsBean() {
        if (model == null) {
            setup();
        }
    }

    public List<Post> getPostsLista() {
        return postLista;
    }

    public Long getPostsTotal() {
        return postTotal;
    }

    public PaginationHelper.Pagination getPagination() {
        return pagination;
    }

    private Integer getPage() {
        Integer page = 1;
        try {
            String p = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page");
            if (p != null) {
                page = Integer.parseInt(p);
            }
        } catch (Exception e) {}
        if (page >= 1) {
            return page;
        }
        return 1;
    }

    private void setup() {
        model = new AdminPostsModel();
        model.connect();
        try {
            Integer page = getPage();
            postLista = model.getPosts((page - 1) * PER_PAGE, PER_PAGE);

            postTotal = model.getTotalPosts();
            pagination = new PaginationHelper().get(PER_PAGE, page, postTotal);
        } finally {
            model.close();
        }
    }
    
}
