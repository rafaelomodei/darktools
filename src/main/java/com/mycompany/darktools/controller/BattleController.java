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
import java.util.Observable;

/**
 * Classe responsável por controlar as batalhas no jogo
 */
public class BattleController extends Observable{
    
    List<Personage> TeamEnemy;
    List<Personage> TeamPlayer;
    
    int whoIsAttackTeamPlayer, whoIsAttackTeamEnemy;
    
    TeamTurn teamTurn;

    /**
     * Contrutor do BattleController
     * @param TeamEnemy Time inimigo
     * @param TeamPlayer Time do jogador
     */
    public BattleController(List<Personage> TeamEnemy, List<Personage> TeamPlayer) {
        this.TeamEnemy = TeamEnemy;
        this.TeamPlayer = TeamPlayer;
        this.teamTurn = TeamTurn.Player;
        this.whoIsAttackTeamEnemy = 0;
        this.whoIsAttackTeamPlayer = 0;
    }
    
    /**
     * Função que realizará as acoes do turno do jogador
     * @param personageGoToAttack Personage do time do jogador que irá atacar
     * @param skillUsed Habilidade usada
     * @param personageToBeAttacked Personagem que será atacado
     */
    public void battleTurn(int personageGoToAttack, int skillUsed, int personageToBeAttacked){
        
        if(teamTurn == TeamTurn.Player){
            
            boolean attacked;
            
            attacked = attack(TeamPlayer.get(personageGoToAttack), TeamPlayer.get(personageGoToAttack).getSkills().get(skillUsed), TeamEnemy.get(personageToBeAttacked));
            
            if(!attacked){
                return;
            }
            
            setChanged();
            notifyObservers("updateTurn");
            
            if(whoIsAttackTeamPlayer == TeamPlayer.size()-1){
                whoIsAttackTeamPlayer = 0;
            } else {
                whoIsAttackTeamPlayer++;
            }
            
            if(isTeamAlive(TeamEnemy) == false){
                
                System.out.println("Time inimigo morto!");
                setChanged();
                notifyObservers("endbattle");
                teamTurn = TeamTurn.Neutral;
                
            } else {

                teamTurn = TeamTurn.Enemy;
                battleTurn();
            }
            
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
            
            updateIsAliveTeam(TeamPlayer);
            setChanged();
            notifyObservers("updateTurn");
            
            if(isTeamAlive(TeamPlayer) == true){
                teamTurn = TeamTurn.Player;
                System.out.println("Vez do jogador atacar!");
            } else {
                System.out.println("Time do jogador morto!");
                setChanged();
                notifyObservers("losegame");
            }
            
            
        }
    }
    
    /**
     * Função que desconta a vida do personagem
     * @param personageAttacker Personagem que atacou
     * @param skill Habilidade usada
     * @param personageDefensive Personagem que levou o dano
     * @return True = Ataque realizado com sucesso. False = Não foi possível realizar o ataque.
     */
    private boolean attack(Personage personageAttacker ,Skill skill, Personage personageDefensive){  
        
        if(personageDefensive.isIsActiveToBattle()){
            
            if(personageDefensive.getLife()-skill.getDamage() < 0){
                personageDefensive.setLife(0);
            } else {
                personageDefensive.setLife(personageDefensive.getLife()-skill.getDamage());
            }
        
            System.out.println("Personagem :"+personageDefensive.getName()+" recebeu dano "+skill.getDamage()+" da habilidade "+skill.getName()+" de "+personageAttacker.getName());
            System.out.println("A vida atual de "+personageDefensive.getName()+" e "+personageDefensive.getLife());

            updateIsAliveTeam(TeamEnemy);
            return true;
        } else {
            System.out.println("Esse inimigo esta morto, selecione outro!");
            return false;
        }
    }
    
    /**
     * Função que retorna se o time está vivo ou morto
     * @return True = vivo. False = Morto.
     */
    private boolean isTeamAlive(List<Personage> team){
        for(int i = 0; i<team.size(); i++){
            Personage personage = team.get(i);
            if(personage.isIsAlive() == true){
                return true;
            }
        }
        return false; 
    }
    
    
    /**
     * Função que fará a atualização do estado de vida dos personagens
     * @param team Time que será atualizado
     */
    private void updateIsAliveTeam(List<Personage> team){
        for(int i = 0; i<team.size(); i++){
            Personage personage = team.get(i);
            System.out.println("Personagem "+team.get(i).getName()+" contem "+team.get(i).getLife()+" de vida -----");
            if(personage.getLife() <= 0 && personage.isIsAlive() == true){
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
        float betterdeterministicValue = 0;
        
        for(int i = 0; i < TeamPlayer.size(); i++){
         
            if(TeamPlayer.get(i).isIsActiveToBattle() && TeamPlayer.get(i).isIsAlive()){
                
                if(selectedPersonage == null){
                    selectedPersonage = TeamPlayer.get(i);
                }
                
                Float deterministicValue = (TeamPlayer.get(i).getSkills().get(0).getDamage()/TeamPlayer.get(i).getLife());
                //System.out.println("Fator deterministico de "+TeamPlayer.get(i).getName()+" = "+deterministicValue);
                
                if(betterdeterministicValue < deterministicValue){
                    betterdeterministicValue = deterministicValue;
                    selectedPersonage = TeamPlayer.get(i);
                }
            }
            
        }
        
        //System.out.println("Personagem escolhido para ser atacado: "+selectedPersonage.getName());
        return selectedPersonage;
    }
}
