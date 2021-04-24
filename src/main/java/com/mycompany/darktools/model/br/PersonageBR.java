/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.br;

import com.mycompany.darktools.model.dao.PersonageDAO;
import com.mycompany.darktools.model.dao.PersonageDAOImpl;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.model.vo.Skill;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author acer
 */
public class PersonageBR {
    private PersonageDAO personageDao;
    
    public PersonageBR(){
        personageDao = new PersonageDAOImpl();
    }
    
    public void Save(Personage personage){
        try {
            personageDao.save(personage);
        } catch (HibernateException he) {
            System.out.println("Erro in to save Personage class :"+he);
        }
    }
    
    public void Upgrade(Personage personage){
        try {
            personageDao.update(personage);
        } catch (HibernateException he) {
            System.out.println("Erro in to upgrade Personage class :"+he);
        }
    }
    
    public void Delete(Personage personage){
        try {
            personageDao.delete(personage);
        } catch (HibernateException he) {
            System.out.println("Erro in to delete Personage class :"+he);
        }
    }
    
    public List<Personage> ListAll(){
        return personageDao.listAll();
    }
    
    public void SaveAll(List Personages){
        personageDao.saveAll(Personages);
    }
    
    public void DeleteAll(List Personages){
        List<Personage> plist = Personages;
        try {
            for(Personage p : plist){
                Delete(p);
            }
        } catch (Exception e) {
            System.out.println("Error in delete all personages :"+e);
        }
    }
    
    public void UpgradeAll(List Personages){
        List<Personage> plist = Personages;
        try {
            for(Personage p : plist){
                Upgrade(p);
            }
        } catch (Exception e) {
            System.out.println("Error in upgrade all personages :"+e);
        }
    }
}
