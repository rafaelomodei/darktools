/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.br;

import com.mycompany.darktools.model.dao.SkillDAO;
import com.mycompany.darktools.model.dao.SkillDAOImpl;
import com.mycompany.darktools.model.vo.Skill;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author acer
 */
public class SkillBR {
    private SkillDAO skillDao;
    
    public SkillBR(){
        skillDao = new SkillDAOImpl();
    }
    
    public void Save(Skill skill){
        try {
            skillDao.save(skill);
        } catch (HibernateException he) {
            System.out.println("Erro in to save Skill class :"+he);
        }
    }
    
    public void Upgrade(Skill skill){
        try {
            skillDao.update(skill);
        } catch (HibernateException he) {
            System.out.println("Erro in to upgrade Skill class :"+he);
        }
    }
    
    public void Delete(Skill skill){
        try {
            skillDao.delete(skill);
        } catch (HibernateException he) {
            System.out.println("Erro in to delete Skill class :"+he);
        }
    }
    
    public List<Skill> ListAll(){
        return skillDao.listAll();
    }
    
    public void saveAll(List<Skill> skills){
        skillDao.saveAll(skills);
    }
    
    public void UpgradeAll(List<Skill> skills){
        List<Skill> slist = skills;
        try {
            for(Skill s : slist){
                Upgrade(s);
            }
        } catch (Exception e) {
            System.out.println("Error in upgrade all personages :"+e);
        }
    }
}
