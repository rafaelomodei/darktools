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
    TeamTurn turnSide;
    List<String> messages;
    List<String> voicesPath;
    List<String> commands;

    public ScriptSegment(TeamTurn turnSide, List<String> messages, List<String> voicesPath, List<String> commands) {
        this.turnSide = turnSide;
        this.messages = messages;
        this.voicesPath = voicesPath;
        this.commands = commands;
    }
    
    
}
