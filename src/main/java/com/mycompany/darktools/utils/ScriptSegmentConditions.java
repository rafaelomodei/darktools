/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.utils;

import com.mycompany.darktools.model.vo.ScriptSegment;
import java.util.List;
import java.util.Random;

/**
 * Classe responsável por funções que auxiliam no comportamento do jogo de acordo com o "commands"
 */
public class ScriptSegmentConditions {
    
    public static int rollDice6(){
        Random generator = new Random();
        
        return generator.nextInt(6);  
    }
    
    public static int rollDice20(){
        Random generator = new Random();
        
        return generator.nextInt(20);  
    }
    
    /**
     * Função que irá quebrar o string para identificar a condição e o valor que será comparado
     * @param condition 
     */
    public static void understandCondition(String condition){
        if(condition.length() == 3){
            try {
                int value = Integer.parseInt(condition.substring(1, 3));
                System.out.println("O valor da comparacao de "+value+" "+condition.substring(0,1)+" "+20+" e "+customIf(value, 20, condition.substring(0,1)));
            } catch (Exception e) {
                int value = Integer.parseInt(condition.substring(2, 3));
                System.out.println("O valor da comparacao de "+value+" "+condition.substring(0,2)+" "+20+" e "+customIf(value, 20, condition.substring(0,2)));
            }
            
        } else if(condition.length() == 4){
            int value =Integer.parseInt(condition.substring(2,4));
            System.out.println("O valor da comparacao de "+value+" "+condition.substring(0,2)+" "+20+" e "+customIf(value, 20, condition.substring(0,2)));
            
        } else {
            int value = Integer.parseInt(condition.substring(1,2));
            System.out.println("O valor da comparacao de "+value+" "+condition.substring(0,1)+" "+20+" e "+customIf(value, 20, condition.substring(0,1)));
        }
        
    }
    
    /**
     * If customizado pelos dados de entrada
     * @param value Valor que ira ser comparado
     * @param comparabledValue Segundo valor que será comparado (normalmente é o valor máximo do dado)
     * @param condition Condicional
     */
    public static boolean customIf(int value, int comparabledValue, String condition){
        if(condition.equals(">")){
            if(value > comparabledValue){
                return true;
            } else {
                return false;
            }
        } else if(condition.equals("<")){
            if(value < comparabledValue){
                return true;
            } else {
                return false;
            }
        } else if(condition.equals(">=")){
            if(value >= comparabledValue){
                return true;
            } else {
                return false;
            }
        } else {
            if(value <= comparabledValue){
                return true;
            } else {
                return false;
            }
        }
    }
}
