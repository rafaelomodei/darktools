/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.utils;

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
     * @return 
     */
    public static List<ScriptSegment> readScriptSegments(List<JSONObject> jsonObjects){
        List<ScriptSegment> scriptSegments = new ArrayList<ScriptSegment>();
        
        for(JSONObject data: jsonObjects){
            System.out.println("data :"+data.toString());
            readScriptSegment(data);
        }
        
        return scriptSegments;
    }
    
    
    /**
     * Função que vai ler todo o arquivo JSON e vai construíndo a classe ScriptSegment com os dados desse JSON
     */
    public static ScriptSegment readScriptSegment(JSONObject jsonObject){
        //ScriptSegment scriptSegment = new ScriptSegment(null, null, null, null, null, null, null, null, null);
        
        //JSONObject jsonObject = readArrayInArchiveJSON(blocInJSON);
        
        
        ScriptSegment scriptSegment = new ScriptSegment(
                (String) jsonObject.get("id"),
                verifyTeamTurnInJsonBloc(jsonObject),
                jsonObject.get("whoSpeaks") != null ? (String)jsonObject.get("whoSpeaks") : null,
                parseJsonObjectToList(jsonObject,"words") != null ? parseJsonObjectToList(jsonObject,"words") : null,
                parseJsonObjectToList(jsonObject,"commands") != null ? parseJsonObjectToList(jsonObject,"commands") : null,
                (String) jsonObject.get("currentScenario") != null ? (String) jsonObject.get("currentScenario") : null,
                parseJsonObjectToList(jsonObject,"showButtons") != null ? parseJsonObjectToList(jsonObject,"showButtons") : null,
                parseJsonObjectToList(jsonObject, "routes") != null ? parseJsonObjectToList(jsonObject, "routes") : null
        );
        
        //scriptSegment.showData();
        return scriptSegment;
        
    }
    
    
    /**
     * Função responsável por percorrer a linha Line do jsonObject e escrever uma lista com os dados do array contido no json
     * @param jsonObject
     * @param line
     * @return 
     */
    static List<String> parseJsonObjectToList(JSONObject jsonObject, String line){
        List<String> stringSegment = new ArrayList<String>();
        
        JSONArray arr = (JSONArray) jsonObject.get(line);
        
        if(arr != null){
                       
            for(int i=0; i< arr.size(); i++){
                stringSegment.add(arr.get(i).toString());
            }

            return stringSegment;
        }
        
        return null;
       
    }
    
    /**
     * Função que verifica o String TeamTurn no JSON para torna-lo a classe TeamTurn
     * @param jsonObject
     * @return 
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
     * Função que lê o array dentro do JSON e retorna o JSONObject do bloco
     */
    public static JSONObject readArrayInArchiveJSON(int bloc){
        
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();//Variaveis que irao armazenar os dados do arquivo JSON
        String texto = null;
        
        try{
            
            //Lê o arquivo JSON, o parser separa od dados e no final é tudo colocado em um array, no caso o JSONArray
            JSONArray array = (JSONArray) parser.parse(new FileReader("dados.json"));
            
            JSONObject j1 = new JSONObject((JSONObject)array.get(bloc));//pega o bloco "bloc" da lista
            
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
     * Função que lê o array dentro do JSON e retorna todos os JSONObject do arquivo
     */
    public static List<JSONObject> readAllArraysInArchiveJSON(){
        
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        JSONParser parser = new JSONParser();//Variaveis que irao armazenar os dados do arquivo JSON
        
        try{
            //Lê o arquivo JSON, o parser separa od dados e no final é tudo colocado em um array, no caso o JSONArray
            //JSONArray array = (JSONArray) parser.parse(new FileReader ("dados.json"));
            
            
            //!! É preciso fazer um meio de ler o arquivo com o formato UTF-8 !!
            
            BufferedReader arqIn = new BufferedReader(new InputStreamReader(new FileInputStream("dados.json"), "UTF-8"));
            //JSONArray array = (JSONArray) arqIn.lines();
            
            //System.out.println("dado :"+linha);
//            for(int i=0; i< array.size(); i++){
//                jsonObjects.add((JSONObject)array.get(i));
//            }
            
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
