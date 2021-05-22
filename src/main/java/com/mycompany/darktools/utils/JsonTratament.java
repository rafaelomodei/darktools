/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.utils;

import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.model.vo.ScriptSegment;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.mycompany.darktools.model.vo.TeamTurn;
import com.mycompany.darktools.model.vo.ScriptSegment;
import com.mycompany.darktools.model.vo.Skill;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author acer
 */
public class JsonTratament {
    /**
     * Função que irá pegar todos os JSONObject do arquivo e criar as classes ScriptSegment
     * @return Lista com as instancias de ScriptSegment
     */
    public static List<ScriptSegment> readScriptSegments(List<JSONObject> jsonObjects){
        List<ScriptSegment> scriptSegments = new ArrayList<ScriptSegment>();
        
        for(JSONObject data: jsonObjects){
            //System.out.println("data :"+data.toString());
            try{
                scriptSegments.add(readScriptSegment(data));
            }catch(Exception e){
                   System.out.println("VAI SE FUDERRRRRRRRRRRRRRRRRRR" + e);
            }
            
        }
        return scriptSegments;
    }
    
    
    /**
     * Função que vai ler todo o arquivo JSON e vai construíndo a classe ScriptSegment com os dados desse JSON
     * @param jsonObject JsonObject com os dados do segmento
     * @return A instância do ScriptSegment já com os dados preenchidos
     */
    public static ScriptSegment readScriptSegment(JSONObject jsonObject){
        
        String scenario;
        try {
            scenario = (String) jsonObject.get("scenario");
        } catch (Exception e) {
            scenario = null;
        }
        
        List<String> showButtons; 
        try{
            showButtons = parseJsonObjectToList(jsonObject,"showButtons");
        } catch (Exception e){
            showButtons = null;

        }
        
        List<String> enemies;
        try {
            enemies = parseJsonObjectToList(jsonObject, "enemy");
        } catch (Exception e) {
            enemies = null;
        }
        
    
        ScriptSegment scriptSegment = new ScriptSegment(
                (String) jsonObject.get("id"), //id
                verifyTeamTurnInJsonBloc(jsonObject), //TurnSide
                jsonObject.get("whoSpeaks") != null ? (String)jsonObject.get("whoSpeaks") : null, //whoSpeaks
                parseJsonObjectToList(jsonObject,"words") != null ? parseJsonObjectToList(jsonObject,"words") : null, //words
                parseJsonObjectToList(jsonObject, "wordsSongs") != null ? parseJsonObjectToList(jsonObject,"wordsSongs") : null, //wordsSongsPath
                parseJsonObjectToList(jsonObject,"commands") != null ? parseJsonObjectToList(jsonObject,"commands") : null,//commands
                scenario,//scenario
                showButtons,//showButton
                parseJsonObjectToList(jsonObject, "routes") != null ? parseJsonObjectToList(jsonObject, "routes") : null,//routes
                enemies
        );
        
        //scriptSegment.showData();
        return scriptSegment;
        
    }
    
    /**
     * Função que cria a lista de NPCs de acordo com as informações contidas no Json dos NPCs
     * @param jsonObject Os dados pego do arquivo JSON
     * @return Lista de personagens contendo os NPCs
     */
    public static List<Personage> createAllNPCs(List<JSONObject> jsonObjects){
        
        List<Personage> personages = new ArrayList<Personage>();
        
        for(JSONObject data: jsonObjects){           
            personages.add(createNPC(data));
        }
        return personages;
        
        
    }
    
    /**
     * Função que cria o NPC de acordo com os dados do JSON de characters
     * @param jsonObject JsonObject com o segmento de dados do 
     * @return Retorna a instância Personage com dados do NPC
     */
    public static Personage createNPC(JSONObject jsonObject){
        
        List<Skill> skills = new ArrayList<Skill>();
        JSONParser parser = new JSONParser();
        
        try{
            Skill skill = new Skill(jsonObject.get("skill").toString(),((Double)jsonObject.get("damage")).floatValue());
            skills.add(skill);
        } catch (Exception e){
            skills = null;
            System.out.println("Erro ao criar a skill: "+e);
        };
        
        Personage personage = new Personage(
                (String) jsonObject.get("id"),
                (String) jsonObject.get("name"),
                ((Double)jsonObject.get("life")).floatValue(),
                skills,
                (String) jsonObject.get("pathimageface"),
                (String) jsonObject.get("pathimagebody")
        );
        
        return personage;
    }
    
    
    /**
     * Função responsável por percorrer a linha Line do jsonObject e escrever uma lista com os dados do array contido no json
     * @param jsonObject JsonObject com os dados
     * @param line A string contendo no nome da chave
     * @return Retorna a lista de string com os dados que estava no vetorzinho no JSON
     */
    static List<String> parseJsonObjectToList(JSONObject jsonObject, String line){
        List<String> stringSegment = new ArrayList<String>();
        
        JSONArray arr;
        
        try{
            arr = (JSONArray) jsonObject.get(line);
        } catch (Exception e){
            System.out.println("Erro ao tentar encontrar o dado no segmento JSON");
            return null;
        }
        
        if(arr != null){
                       
            for(int i=0; i< arr.size(); i++){
                stringSegment.add(arr.get(i).toString());
            }

            return stringSegment;
        }
        
        return null;
       
    }
    
    
    /**
     * Função que verifica o String TeamTurn no JSON para torna-lo a classe TeamTurn com o enum
     * @param jsonObject 
     * @return Retorna o TeamTurn já definido
     */
    static TeamTurn verifyTeamTurnInJsonBloc(JSONObject jsonObject){
        
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
     * Função que lê um array dentro do JSON e retorna o JSONObject do bloco
     * @param bloc Qual segmeto dentro do adrquivo JSON será lido
     * @return Retorna o JSONObject com os dados desse segmento do arquivo JSON
     */
    public static JSONObject readArrayInArchiveJSON(int segment){
        
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();//Variaveis que irao armazenar os dados do arquivo JSON
        String texto = null;
        
        try{
            
            //Lê o arquivo JSON, o parser separa od dados e no final é tudo colocado em um array, no caso o JSONArray
            JSONArray array = (JSONArray) parser.parse(new FileReader("dados.json"));
            
            JSONObject j1 = new JSONObject((JSONObject)array.get(segment));//pega o bloco "bloc" da lista
            
            //texto = (String) j1.get(line);//pega os dados da linha "line"
            
            //System.out.println(""+texto);
            
            return j1;

        }//Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (Exception e){
            System.out.println("Erro in read array in archive Json :"+e);
            return null;
        }
        
        
    }
    
    
    /**
     * Funçào que irá ler todos os segmentos do arquivo JSON
     * @param filePath Caminho do arquivo JSON que será lido
     * @return Retorna uma lista de JSONObject com os dados contidos no JSON
     */
    public static List<JSONObject> readAllArraysInArchiveJSON(String filePath){
        
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        JSONParser parser = new JSONParser();//Variaveis que irao armazenar os dados do arquivo JSON
        
        try{
            
            BufferedReader arqIn = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            JSONArray array = (JSONArray) parser.parse(arqIn);
            
            for(int i=0; i< array.size(); i++){
                jsonObjects.add((JSONObject)array.get(i));
            }
            
            return jsonObjects;
            
        }//Trata as exceptions que podem ser lançadas no decorrer do processo
        catch(Exception e){
            System.out.println("Read all arrays in archive JSON error :"+e);
            return null;
        }
        
        
    }

    
    /***
     * Função que lê dado unico no arquivo JSON
     */
    void readArchiveJSON(){
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();//Variaveis que irao armazenar os dados do arquivo JSON
        
        //FileReader fr = null;
        
        try{
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader("dados.json"));
            //StandardCharsets.UTF_8
            
            //Salva nas variaveis os dados retirados do arquivo
            String texto = (String) jsonObject.get("a");
            
            System.out.println(""+texto);
            
        }//Trata as exceptions que podem ser lançadas no decorrer do processo
        catch(Exception e){
            System.out.println("Error in read archive Json :"+e);
        }
    }
    
    /***
     * Função que escreve no arquivo JSON
     */
    void whiteArchiveJSON(){
        FileWriter writeFile = null;//sistema pra escrever
        
        JSONObject objeto = new JSONObject();
        
        objeto.put("village1", "Olá guerreiro"); //escreve no json
        
        try{
            writeFile = new FileWriter("dados.json");//cria o arquivo com os caracteres especiais
            writeFile.write(objeto.toString());//escreve o json no arquivo
            
            writeFile.close();//fecha o arquivo
        } catch (IOException ex){ //Classe que lança uma exceção de entradas e saídas;
            ex.printStackTrace();
        }
        
    }
}
