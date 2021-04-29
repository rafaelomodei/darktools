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

    public TeamTurn getTurnSide() {
        return turnSide;
    }

    public String getWhoSpeaks() {
        return whoSpeaks;
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getCommands() {
        return commands;
    }

    public String getScenario() {
        return scenario;
    }

    public List<String> getShowButton() {
        return showButton;
    }

    public List<String> getRoutes() {
        return routes;
    }


    
    
    
}
