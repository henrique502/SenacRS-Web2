package br.com.hrdev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Model {
    
    public Model(){
        connect();
    }
    
    private static EntityManagerFactory factory = null;
    protected static EntityManager db = null;

    private void connect(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("SenacRS-Web2PU");
            db = factory.createEntityManager();
        }
    }
    
    public void close(){
        if(db != null) db.close();
        if(factory != null) factory.close();
    }
}

