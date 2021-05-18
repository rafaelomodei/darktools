/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller;

import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.model.vo.Skill;
import com.mycompany.darktools.model.vo.TeamTurn;
import java.util.List;

/**
 * Classe responsável por controlar as batalhas no jogo
 */
public class BattleController {
    
    List<Personage> TeamEnemy;
    List<Personage> TeamPlayer;
    
    int whoIsAttackTeamPlayer, whoIsAttackTeamEnemy;
    
    TeamTurn teamTurn;

    public BattleController(List<Personage> TeamEnemy, List<Personage> TeamPlayer) {
        this.TeamEnemy = TeamEnemy;
        this.TeamPlayer = TeamPlayer;
        this.teamTurn = TeamTurn.Player;
        this.whoIsAttackTeamEnemy = 0;
        this.whoIsAttackTeamPlayer = 0;
    }
    
    /**
     * Função que fará o controle dos acontecimentos no turno do usuário
     */
    public void battleTurn(Personage personageAttacker ,Skill skill, Personage personageDefensive){
        
        if(teamTurn == TeamTurn.Player){
            
            
            if(whoIsAttackTeamPlayer == TeamPlayer.size()-1){
                whoIsAttackTeamEnemy = 0;
            } else {
                whoIsAttackTeamPlayer++;
            }
            
            teamTurn = TeamTurn.Enemy;
        } else {
            System.out.println("Não é sua vez de joga. Espere.");
        }
    }
    
    /**
     * Função de turno do inimigo
     */
    public void battleTurn(){
        
        if(teamTurn == TeamTurn.Enemy){
            attack(TeamEnemy.get(whoIsAttackTeamEnemy), TeamEnemy.get(whoIsAttackTeamEnemy).getSkills().get(0), EnemyBasicIA());
            
            if(whoIsAttackTeamEnemy == TeamEnemy.size()-1){
                whoIsAttackTeamEnemy = 0;
            } else {
                whoIsAttackTeamEnemy++;
            }
            
            teamTurn = TeamTurn.Player;
            System.out.println("Vez do jogador atacar!");
            
        }
    }
    
    /**
     * Função que desconta a vida do personagem
     * @param personageAttacker Personagem que atacou
     * @param skill Habilidade usada
     * @param personageDefensive Personagem que levou o dano
     */
    private void attack(Personage personageAttacker ,Skill skill, Personage personageDefensive){
        personageDefensive.setLife(personageDefensive.getLife()-skill.getDamage());
        System.out.println("Personagem :"+personageDefensive.getName()+" recebeu dano "+skill.getDamage()+" da habilidade "+skill.getName()+" de "+personageAttacker.getName());
    }
    
    /**
     * Função que fará a verificação e atualização do estado de vida dos personagens do time do inimigo
     */
    private void verifyLifeTeamEnemy(){
        for(int i = 0; i<TeamEnemy.size(); i++){
            Personage personage = TeamEnemy.get(i);
            if(personage.getLife() <= 0){
                killPersonage(personage);
            }
        }
    }
    
    /**
     * Função que fará a verificação e atualização do estado de vida dos personagens do time do jogador
     */
    private void verifyLifeTeamPlayer(){
        for(int i = 0; i<TeamPlayer.size(); i++){
            Personage personage = TeamPlayer.get(i);
            if(personage.getLife() <= 0){
                killPersonage(personage);
            }
        }
    }
    
    /**
     * Função responsável por mudar o estado de vida do Personage se a vida chegar a 0 durante a batalha
     */
    private void killPersonage(Personage personage){
        personage.setIsActiveToBattle(false);
        personage.setIsAlive(false);
        System.out.println("Personagem "+personage.getName()+" morreu!");
    }
    
    /**
     * Função que seleciona o melhor personagem para ser atacado pelo time inimigo. Usa algoritmo guloso, sendo a divisão do dano pela vida.
     * @return Retorna o personagem do TeamPlayer que será atacado
     */
    private Personage EnemyBasicIA(){
        Personage selectedPersonage = null;
        int betterdeterministicValue = 0;
        
        for(int i = 0; i < TeamPlayer.size(); i++){
         
            if(TeamPlayer.get(i).isIsActiveToBattle() || TeamPlayer.get(i).isIsAlive()){
                
                if(selectedPersonage == null){
                    selectedPersonage = TeamPlayer.get(i);
                }
                
                Float deterministicValue = (TeamPlayer.get(i).getSkills().get(0).getDamage()/TeamPlayer.get(i).getLife());
                
                if(betterdeterministicValue < deterministicValue){
                    selectedPersonage = TeamPlayer.get(i);
                }
            }
            
        }
        
        return selectedPersonage;
    }
}
