/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.dao;

import com.mycompany.darktools.model.vo.Skill;
import com.mycompany.darktools.model.vo.Team;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author acer
 */
public class TeamDAOImpl implements TeamDAO{
    EntityManager manager;
    
    public TeamDAOImpl(){
       manager = (EntityManager) ConectionHibernate.getInstance();
    }
    
    @Override
    public void save(Team team) {
        manager.getTransaction().begin();
        manager.persist(team);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Team team) {
        manager.getTransaction().begin();
        manager.merge(team);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Team team) {
        manager.getTransaction().begin();
        manager.remove(team);
        manager.getTransaction().commit();
    }

}
