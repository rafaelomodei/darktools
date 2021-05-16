/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.utils;

import com.mycompany.darktools.model.vo.ScriptSegment;
import java.util.List;

/**
 *
 * @author acer
 */
public class ScriptSegmentConditions {
    
    /**
     * Função responsável pelo direcionamento de comportamento de acordo com o scriptSegment
     * @param scriptSegment 
     */
    public static void ScriptSegmentTargetingConditions(ScriptSegment scriptSegment){
        List<String> commandsList = scriptSegment.getCommands();
        
        if(commandsList.contains("showButtons")){
            System.out.println("Mostrar os botões de escolha na tela!");
        }
        
        if(commandsList.contains("battle")){
            System.out.println("Iniciar batalha!");
        }
        
        if(commandsList.contains("changeScenario")){
            System.out.println("Mudar cenário!");
        }
        
        if(commandsList.contains("changeMusic")){
            System.out.println("Mudar musica!");
        }
        
        if(commandsList.contains("RollDiceD6")){
            System.out.println("Rolar o dado D6!");
        }
    }
}