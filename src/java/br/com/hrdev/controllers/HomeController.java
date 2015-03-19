/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hrdev.controllers;

import br.com.hrdev.jpa.HomeModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author henriqueschmidt
 */
@ManagedBean
@RequestScoped
public class HomeController {
    
    private HomeModel model;
    
    /**
     * Creates a new instance of HomeController
     */
    public HomeController(){
        model = new HomeModel();
    }
    
}
