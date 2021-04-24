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
        try {
            return skillDao.listAll();
        } catch (HibernateException he) {
            System.out.println("Erro in list all skills :"+he);
            return null;
        }
        
    }
    
    public void saveAll(List Skills){
        skillDao.saveAll(Skills);
    }
    
    public void UpgradeAll(List Skills){
        List<Skill> slist = Skills;
        try {
            for(Skill s : slist){
                Upgrade(s);
            }
        } catch (Exception e) {
            System.out.println("Error in upgrade all personages :"+e);
        }
    }
}
