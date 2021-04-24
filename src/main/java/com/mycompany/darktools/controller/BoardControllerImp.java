/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller;

import com.mycompany.darktools.model.br.BoardBR;
import com.mycompany.darktools.model.br.PersonageBR;
import com.mycompany.darktools.model.br.SkillBR;
import com.mycompany.darktools.model.br.TeamBR;
import com.mycompany.darktools.model.vo.Board;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.model.vo.Skill;
import com.mycompany.darktools.model.vo.Team;
import java.util.List;

/**
 *
 * @author acer
 */
public class BoardControllerImp implements BoardController{
    BoardBR boardBR;
    PersonageBR personageBR;
    SkillBR skillBR;
    TeamBR teamBR;
    
    @Override
    public void inicialize() {
        boardBR = new BoardBR();
        personageBR = new PersonageBR();
        skillBR = new SkillBR();
        teamBR = new TeamBR();
    }
    
    @Override
    public void saveGame(Board board) {

        Team t = board.getTeamPlayer();
        Personage p = t.getPersonages().get(0);
        Skill s = p.getSkills().get(0);
        skillBR.saveAll(p.getSkills());
        personageBR.SaveAll(t.getPersonages());//salva os personagens do time
        teamBR.Save(t);//ele vai salvar o TeamPlayer que tá na board
        boardBR.Save(board);
        
    }

    /**
     * Função responsável para receber todos as mesas que foram salvas
     * @return Board com os dados
     */
    @Override
    public List<Board> loadGames() { 
        return boardBR.ListAll();
    }
    
    public List<Skill> loadSkills(){
        return skillBR.ListAll();
    }

    @Override
    public void deleteSave(Board board) {
        Team t = board.getTeamPlayer();
        Personage p = t.getPersonages().get(0);
        
        boardBR.Delete(board);
        
        teamBR.Delete(t);//ele vai salvar o TeamPlayer que tá na board
        
        personageBR.DeleteAll(t.getPersonages());//deleta todos os personagens do time
    }

    @Override
    public void upgradeSave(Board board) {
        //boardBR.Upgrade(board);
        
        Team t = board.getTeamPlayer();
        Personage p = t.getPersonages().get(0);
        Skill s = p.getSkills().get(0);
        skillBR.UpgradeAll(p.getSkills());
        personageBR.UpgradeAll(t.getPersonages());
        teamBR.Upgrade(t);
        boardBR.Upgrade(board);
    }
   
}
