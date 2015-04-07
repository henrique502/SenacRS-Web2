package br.com.hrdev.beans.admin;

import br.com.hrdev.entidades.Post;
import br.com.hrdev.helpers.MensagensHelper;
import br.com.hrdev.jpa.admin.AdminPostsModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 180901954
 */
@ManagedBean
@RequestScoped
public class AdminPostsRemoverBean {

    private AdminPostsModel model = null;
    private Post post;

    public AdminPostsRemoverBean() {
        if (model == null) {
            setup();
        }
    }

    private void setup() {
        model = new AdminPostsModel();
        model.connect();
        try {
            post = model.getPostById(getPostId());
        } finally {
            model.close();
        }
    }

    private Integer getPostId() {
        Integer id = 0;
        try {
            String p = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("postId");
            if (p != null) {
                id = Integer.parseInt(p);
            }
        } catch (Exception e) {
        }
        return id;
    }

    public Post getPost() {
        return post;
    }

    public String removerPost() {
        boolean status = false;
        model.connect();

        try {
            status = model.deletePost(post);
        } catch (Exception e) {
            MensagensHelper.addError("Falha ao remover o post: " + e.getMessage());
        } finally {
            model.close();
        }

        if (status) {
            MensagensHelper.addInfo("Post removido com sucesso");
            return "/admin/posts/index";
        } else {
            return "/admin/posts/remover?postId=" + post.getId();
        }
    }
}