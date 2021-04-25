/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.model.vo;

import java.util.List;

/**
 *
 * @author acer
 */
public class ScriptSegment {
    String id;
    TeamTurn turnSide;
    String whoSpeaks;
    List<String> words;
    List<String> commands;
    String scenario;
    List<String> showButton;
    List<String> routes;

    public ScriptSegment(String id, TeamTurn turnSide, String whoSpeaks, List<String> words, List<String> commands, String scenario, List<String> showButton, List<String> routes) {
        this.id = id;
        this.turnSide = turnSide;
        this.whoSpeaks = whoSpeaks;
        this.words = words;
        this.commands = commands;
        this.scenario = scenario;
        this.showButton = showButton;
        this.routes = routes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TeamTurn getTurnSide() {
        return turnSide;
    }

    public void setTurnSide(TeamTurn turnSide) {
        this.turnSide = turnSide;
    }

    public String getWhoSpeaks() {
        return whoSpeaks;
    }

    public void setWhoSpeaks(String whoSpeaks) {
        this.whoSpeaks = whoSpeaks;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public List<String> getShowButton() {
        return showButton;
    }

    public void setShowButton(List<String> showButton) {
        this.showButton = showButton;
    }

    public List<String> getRoutes() {
        return routes;
    }

    public void setRoutes(List<String> routes) {
        this.routes = routes;
    }

    
    
    
}
