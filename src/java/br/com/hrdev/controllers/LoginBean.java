/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hrdev.controllers;

import br.com.hrdev.beans.UsuarioBean;
import br.com.hrdev.entidades.Usuario;
import br.com.hrdev.helpers.HashHelper;
import br.com.hrdev.jpa.LoginModel;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author henriqueschmidt
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private String email;
    private String senha;
    private boolean hasError = false;
    
    LoginModel model;
    
    public LoginBean() {
        model = new LoginModel();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean hasError() {
        return hasError;
    }
    
    private void setMessage(String summary) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null));
    }
    
    public String validaLogin(){
        String emailParam = getEmail().toLowerCase().trim();
        String senhaParam = HashHelper.md5(getSenha());

        Usuario usuario = model.getUsuarioByLogin(emailParam, senhaParam);
        
        if(usuario != null){
            UsuarioBean bean = new UsuarioBean();
            bean.login(usuario);
            return "index";
        } else {
            setMessage("Login ou senha inválida. Tente novamente!");
        }
        
        return "login";
    }
}
