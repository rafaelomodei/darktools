/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.vo;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 *
 * @author acer
 */
@Entity
@Table (name = "Board")
public class Board {
    @Transient
    static Board uniqueIndex;
    
    public Board(){}
    
    public static synchronized Board getInstante(){ //o synchronized permite o controle de acesso da variável pela concorrencia (cada um vai acessando a instancia por vez)
        if(uniqueIndex == null){ //se não existir a instancia
            uniqueIndex = new Board(); //cria
        }
        return uniqueIndex;//se ela já existe, retorna a mesma
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Transient //não vira um campo no banco de dados
    GameState gameState;
    
    @OneToOne
    @JoinColumn(name = "TEAMPLAYER_ID")
    Team teamPlayer;
    
    @Transient
    Team teamEnemy;
    
    @Transient
    Scenario currentScenario;
    
    @Transient
    List<ScriptSegment> scriptSegments;
    
    @Transient
    TeamTurn turnSide;
    
    @Column(name = "citypeoplesalive", nullable = false)
    Integer cityPeoplesAlive;
    
    @Transient
    Map map;
    
    @Column(name = "namesave", length = 15, nullable = false, unique = true)
    String nameSave;
    
    @Temporal (TemporalType.TIMESTAMP)
    Date dateSave; //data e horário desse save
    
    @Column(name = "segmentStoppedId", length = 15, nullable = false)
    String segmentStoppedId;

    public Board(Team teamPlayer, Integer cityPeoplesAlive, String nameSave, String segmentStoppedId) {
        this.teamPlayer = teamPlayer;
        this.cityPeoplesAlive = cityPeoplesAlive;
        this.nameSave = nameSave;
        this.segmentStoppedId = segmentStoppedId;
    }
    
    
    
    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Team getTeamPlayer() {
        return teamPlayer;
    }

    public void setTeamPlayer(Team teamPlayer) {
        this.teamPlayer = teamPlayer;
    }

    public Team getTeamEnemy() {
        return teamEnemy;
    }

    public void setTeamEnemy(Team teamEnemy) {
        this.teamEnemy = teamEnemy;
    }

    public Scenario getCurrentScenario() {
        return currentScenario;
    }

    public void setCurrentScenario(Scenario currentScenario) {
        this.currentScenario = currentScenario;
    }

    public List<ScriptSegment> getScriptSegments() {
        return scriptSegments;
    }

    public void setScriptSegments(List<ScriptSegment> scriptSegments) {
        this.scriptSegments = scriptSegments;
    }

    public TeamTurn getTurnSide() {
        return turnSide;
    }

    public void setTurnSide(TeamTurn turnSide) {
        this.turnSide = turnSide;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCityPeoplesAlive() {
        return cityPeoplesAlive;
    }

    public void setCityPeoplesAlive(Integer cityPeoplesAlive) {
        this.cityPeoplesAlive = cityPeoplesAlive;
    }

    public String getNameSave() {
        return nameSave;
    }

    public void setNameSave(String nameSave) {
        this.nameSave = nameSave;
    }

    public Date getDateSave() {
        return dateSave;
    }

    public void setDateSave(Date dateSave) {
        this.dateSave = dateSave;
    }

    public static Board getUniqueIndex() {
        return uniqueIndex;
    }

    public static void setUniqueIndex(Board uniqueIndex) {
        Board.uniqueIndex = uniqueIndex;
    }

    public String getSegmentStoppedId() {
        return segmentStoppedId;
    }

    public void setSegmentStoppedId(String segmentStoppedId) {
        this.segmentStoppedId = segmentStoppedId;
    }
    
    
}
