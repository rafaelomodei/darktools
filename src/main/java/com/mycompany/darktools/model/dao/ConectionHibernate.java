/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;

public class ConectionHibernate {
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    
    public static EntityManager getInstance() {
        if (manager == null)
        {
            synchronized (ConectionHibernate.class) {
                if (manager == null)
                {
                    try {
                        try {
                            factory = Persistence.createEntityManagerFactory("com.mycompany_darktools_jar_1.0-SNAPSHOTPU");
                            manager = factory.createEntityManager();
                        } catch (Exception e) {
                            System.out.println("Erro do getInstance "+e);
                        }
                        
                        //
                    } catch(HibernateException he) {
                        System.err.println(he.getMessage());
                    }
                }
            }
            
        }
        
        return manager;
    }
    
    public static void close() {
        manager.close();
        factory.close();
    }
}
