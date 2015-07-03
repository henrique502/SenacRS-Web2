/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hrdev.api;

import static br.com.hrdev.api.ApiResource.MEDIA_TYPE;
import br.com.hrdev.entidades.Post;
import br.com.hrdev.entidades.views.ViewPost;
import br.com.hrdev.jpa.HomeModel;
import br.com.hrdev.jpa.PostModel;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author 180901954
 */

@Path("/posts")
public class PostsResource extends ApiResource{
    
    private static final int PER_PAGE = 5;

    @GET
    @Path("/")
    @Produces(MEDIA_TYPE)
    public List<ViewPost> getPostsList(@QueryParam("page") @DefaultValue("0") String pageString){
        int page = 0;
        try {
            page = Integer.parseInt(pageString);
            if(page > 0){
                page = page * PER_PAGE;
            } else {
                page = 0;
            }
        } catch(Exception ex){}
        
        HomeModel model = new HomeModel();
        try {
            model.connect();
            return model.getPosts(page, PER_PAGE);
        } finally {
            model.close();
        }
    }
    
    @GET
    @Produces(MEDIA_TYPE)
    @Path("/get/{postId}")
    public Post getPost(@PathParam("postId") String postId){
        PostModel model = new PostModel();
        Post post = null;
        
        try {
            Integer id = Integer.parseInt(postId);
            model.connect();
            post = model.getPostById(id);
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            model.close();
        }

        return post;
    }
}
