package br.com.hrdev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Model {
    
    private static EntityManagerFactory factory = null;
    private static EntityManager manager = null;
    
    public EntityManager getEntityManager(){
        return manager;
    }

    public void connect(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("SenacRS-Web2PU");
            manager = factory.createEntityManager();
        }
    }
    
    public void close(){
        if(manager != null) manager.close();
        if(factory != null) factory.close();
    }
}

