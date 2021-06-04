/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.br;

import com.mycompany.darktools.model.dao.TeamDAO;
import com.mycompany.darktools.model.dao.TeamDAOImpl;
import com.mycompany.darktools.model.vo.Team;
import java.util.List;

/**
 *
 * @author acer
 */
public class TeamBR {
    private TeamDAO teamDao;
    
    public TeamBR(){
        teamDao = new TeamDAOImpl();
    }
    
    public void Save(Team team){
        try {
            teamDao.save(team);
        } catch (Exception he) {
            System.out.println("Erro in to save Team class :"+he);
        }
    }
    
    public void Upgrade(Team team){
        try {
            teamDao.update(team);
        } catch (Exception he) {
            System.out.println("Erro in to upgrade Team class :"+he);
        }
    }
    
    public void Delete(Team team){
        try {
            teamDao.delete(team);
        } catch (Exception he) {
            System.out.println("Erro in to delete Team class :"+he);
        }
    }
    
}
