package br.com.hrdev.api;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author 180901954
 */
public class ApiResource {
    
    protected static final String MEDIA_TYPE = MediaType.APPLICATION_JSON + ";charset=utf-8";
    
    @Context
    protected UriInfo info;
}
