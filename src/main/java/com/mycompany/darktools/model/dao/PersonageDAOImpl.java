/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.dao;

import com.mycompany.darktools.model.vo.Personage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class PersonageDAOImpl implements PersonageDAO {
//    EntityManager manager;
    
    public PersonageDAOImpl(){
       //manager = (EntityManager) ConectionHibernate.getInstance();
    }
    
    @Override
    public void save(Personage personagem){
//        manager.getTransaction().begin();
//        manager.persist(personagem);
//        manager.getTransaction().commit();
    }
    
    @Override
    public void update(Personage personagem){
//        manager.getTransaction().begin();
//        manager.merge(personagem);
//        manager.getTransaction().commit();
    }
    
    @Override
    public void delete(Personage personagem){
//        manager.getTransaction().begin();
//        manager.remove(personagem);
//        manager.getTransaction().commit();
    }

    @Override
    public List<Personage> listAll() {
        List<Personage> personages = new ArrayList();
        
//        Query query = manager.createQuery("Select s FROM personage s");
//        personages = query.getResultList();
        
        return personages;
    }

    @Override
    public void saveAll(List Personages) {
        List<Personage> personagesToSave = Personages;
        for(Personage p : personagesToSave){
            save(p);
        }
    }
}
