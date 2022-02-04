/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller;

import com.mycompany.darktools.model.vo.ScriptSegment;
import com.mycompany.darktools.model.vo.TeamTurn;
import java.util.List;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import com.mycompany.darktools.utils.JsonReader;
import static com.mycompany.darktools.utils.JsonReader.ParseJsonObjectToList;

/**
 * Controlador responsável pelo manuseio da lista de ScriptSegments.
 * Classe singleton.
 */
public class ScriptSegmentController {
    List<ScriptSegment> scriptSegments;
    
    static ScriptSegmentController uniqueIndex;
    
    private ScriptSegmentController(){
        JsonReader jsonTratament = new JsonReader();
        
        scriptSegments = InstantiateScriptSegmentList(jsonTratament.readAllArraysInArchiveJSON("/data/dados.json"));
        
    }
    
    public static ScriptSegmentController getInstance(){ 
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
     * Função que irá pegar todos os JSONObject do arquivo e criar as classes ScriptSegment
     * @return Lista com as instancias de ScriptSegment
     */
    public static List<ScriptSegment> InstantiateScriptSegmentList(List<JSONObject> jsonObjects){
        List<ScriptSegment> scriptSegments = new ArrayList<ScriptSegment>();
        
        for(JSONObject data: jsonObjects){
            //System.out.println("data :"+data.toString());
            try{
                scriptSegments.add(InstantiateScriptSegment(data));
            }catch(Exception e){
                   System.out.println("Erro no tratamento do json" + e);
            }
            
        }
        return scriptSegments;
    }
    
    /**
     * Função que vai ler todo o arquivo JSON e vai construíndo a classe ScriptSegment com os dados desse JSON
     * @param jsonObject JsonObject com os dados do segmento
     * @return A instância do ScriptSegment já com os dados preenchidos
     */
    public static ScriptSegment InstantiateScriptSegment(JSONObject jsonObject){
        
        String scenario;
        try {
            scenario = (String) jsonObject.get("scenario");
        } catch (Exception e) {
            scenario = null;
        }
        
        List<String> showButtons; 
        try{
            showButtons = ParseJsonObjectToList(jsonObject,"showButtons");
        } catch (Exception e){
            showButtons = null;

        }
        
        List<String> enemies;
        try {
            enemies = ParseJsonObjectToList(jsonObject, "enemy");
        } catch (Exception e) {
            enemies = null;
        }
        
    
        ScriptSegment scriptSegment = new ScriptSegment(
                (String) jsonObject.get("id"), ParseTeamTurnInJsonBloc(jsonObject), //TurnSide
                jsonObject.get("whoSpeaks") != null ? (String)jsonObject.get("whoSpeaks") : null, //whoSpeaks
                ParseJsonObjectToList(jsonObject,"words") != null ? ParseJsonObjectToList(jsonObject,"words") : null, //words
                ParseJsonObjectToList(jsonObject, "wordsSongs") != null ? ParseJsonObjectToList(jsonObject,"wordsSongs") : null, //wordsSongsPath
                ParseJsonObjectToList(jsonObject,"commands") != null ? ParseJsonObjectToList(jsonObject,"commands") : null,//commands
                scenario,//scenario
                showButtons,//showButton
                ParseJsonObjectToList(jsonObject, "routes") != null ? ParseJsonObjectToList(jsonObject, "routes") : null,//routes
                enemies
        );
        
        //scriptSegment.showData();
        return scriptSegment;
        
    }

    /**
     * Função que trasnforma string TeamTurn para TeamTurn tipo enum
     * @param jsonObject 
     * @return Retorna o TeamTurn já definido
     */
    static TeamTurn ParseTeamTurnInJsonBloc(JSONObject jsonObject){
        
        String turnSide = (String)jsonObject.get("turnSide");
        
        TeamTurn teamTurn = TeamTurn.Neutral;//Comportamento padrão
        
        if(turnSide.equals("neutral")){
            teamTurn = TeamTurn.Neutral;
        } else if(turnSide.equals("enemy")){
            teamTurn = TeamTurn.Enemy;
        } else if(turnSide.equals("player")){
            teamTurn = TeamTurn.Player;
        }
        
        return teamTurn;
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
