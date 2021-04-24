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
import com.mycompany.darktools.model.vo.Skill;
import java.util.List;

/**
 * Classe responsável pelo controle geral de game
 * @author acer
 */
public interface BoardController {
    void inicialize();
    
    void saveGame(Board board);
    
    List<Board> loadGames();
    
    List<Skill> loadSkills();
    
    void deleteSave(Board board);
    
    void upgradeSave(Board board);
}
