package br.com.hrdev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Model {
    
    public Model(){}
    
    private static EntityManagerFactory factory = null;
    protected static EntityManager db = null;

    public void connect(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("SenacRS-Web2PU");
            db = factory.createEntityManager();
        }
    }
    
    public void close(){
        if(db != null){
            db.close();
            db = null;
        }
        if(factory != null){
            factory.close();
            factory = null;
        }
    }
}

