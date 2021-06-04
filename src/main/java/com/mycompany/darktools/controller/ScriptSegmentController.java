/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller;

import com.mycompany.darktools.model.vo.ScriptSegment;
import static com.mycompany.darktools.utils.JsonTratament.readAllArraysInArchiveJSON;
import static com.mycompany.darktools.utils.JsonTratament.readScriptSegments;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador responsável pelo manuseio da lista de ScriptSegments.
 * Classe singleton.
 */
public class ScriptSegmentController {
    List<ScriptSegment> scriptSegments;
    
    static ScriptSegmentController uniqueIndex;
    
    private ScriptSegmentController(){
        scriptSegments = readScriptSegments(readAllArraysInArchiveJSON("dados.json"));
        
    }
    
    public static ScriptSegmentController getInstante(){ 
        if(uniqueIndex == null){ //se não existir a instancia
            uniqueIndex = new ScriptSegmentController(); //cria
        }
        return uniqueIndex;//se ela já existe, retorna a mesma
    }

    public List<ScriptSegment> getScriptSegments() {
        return scriptSegments;
    }

    public static ScriptSegmentController getUniqueIndex() {
        return uniqueIndex;
    }

    public static void setUniqueIndex(ScriptSegmentController uniqueIndex) {
        ScriptSegmentController.uniqueIndex = uniqueIndex;
    }
    

    /**
     * Função que irá procurar a instancia do ScriptSegment de acordo com o Id
     * @param scriptSegments Lista com os scriptSegments
     * @param id String do id
     * @return Retorna a instancia do ScriptSegment procurada
     */
    public ScriptSegment foundScriptSegment(List<ScriptSegment> scriptSegments, String id){
        
        for(ScriptSegment seekSegment : scriptSegments){
            if(seekSegment.getId().equalsIgnoreCase(id)){
                return seekSegment;
            }
        }
        
        System.out.println("Não foi possível encontrar o ScriptSegment");
        return null;
        
    }
    
    /**
     * Função responsável por retornar a proxima instancia ScriptSegment de acordo com entrada
     * @param scriptSegments Lista com os scriptSegments
     * @param currentScriptSegment ScriptSegment atual
     * @param selection Escolha, feita por botão, dado ou outro meio
     * @return 
     */
    public ScriptSegment foundNextScriptSegment(List<ScriptSegment> scriptSegments, ScriptSegment currentScriptSegment, int selection){
        
        String idForNextScriptSegment = currentScriptSegment.getRoutes().get(selection);
       
        ScriptSegment nextScriptSegment = foundScriptSegment(scriptSegments, idForNextScriptSegment);
        if(nextScriptSegment != null){
            return nextScriptSegment;
        } else {
            System.out.println("Não foi possível encontrar o próximo segmento!");
            return null;
        }
        
    }
        
}
