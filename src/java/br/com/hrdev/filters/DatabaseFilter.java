package br.com.hrdev.filters;

import br.com.hrdev.jpa.Model;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author henriqueschmidt
 */
public class DatabaseFilter implements Filter {

    private Model connection = null;
    
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        connection = new Model();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
    }

    @Override
    public void destroy() {
        connection.close();
    }
    
}
