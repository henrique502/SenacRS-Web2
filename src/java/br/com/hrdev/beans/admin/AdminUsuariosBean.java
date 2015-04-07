package br.com.hrdev.beans.admin;

import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.helpers.PaginationHelper;
import br.com.hrdev.jpa.admin.AdminUsuariosModel;
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
public class AdminUsuariosBean {
    
    public final static int PER_PAGE = 10;
    
    private AdminUsuariosModel model;
    private List<Usuario> usuariosLista;
    private Long usuariosTotal;
    private PaginationHelper.Pagination pagination;

    public AdminUsuariosBean() {
        if (model == null) {
            setup();
        }
    }

    public List<Usuario> getUsuariosLista() {
        return usuariosLista;
    }

    public Long getUsuariosTotal() {
        return usuariosTotal;
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
        model = new AdminUsuariosModel();
        model.connect();
        try {
            Integer page = getPage();
            usuariosLista = model.getUsuarios((page - 1) * PER_PAGE, PER_PAGE);

            usuariosTotal = model.getTotalUsuarios();
            pagination = new PaginationHelper().get(PER_PAGE, page, usuariosTotal);
        } finally {
            model.close();
        }
    }
}
