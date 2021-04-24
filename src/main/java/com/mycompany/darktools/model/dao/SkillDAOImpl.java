/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.dao;

import com.mycompany.darktools.model.vo.Board;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.model.vo.Skill;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author acer
 */
public class SkillDAOImpl implements SkillDAO{
    EntityManager manager;
    
    public SkillDAOImpl(){
       manager = (EntityManager) ConectionHibernate.getInstance();
    }

    @Override
    public void save(Skill skill) {
        manager.getTransaction().begin();
        manager.persist(skill);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Skill skill) {
        manager.getTransaction().begin();
        manager.merge(skill);
        manager.getTransaction().commit();
    }
    
    @Override
    public void delete(Skill skill) {
        manager.getTransaction().begin();
        manager.remove(skill);
        manager.getTransaction().commit();
    }

    @Override
    public List<Skill> listAll() {
        List<Skill> skills;
        
        Query query = manager.createQuery("Select s FROM Skill s");
        skills = query.getResultList();
        
        return skills;
    }

    @Override
    public void saveAll(List Skills) {
        List<Skill> skillsToSave = Skills;
        for(Skill s : skillsToSave){
            save(s);
        }
    }
 
}
