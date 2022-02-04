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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Classe responsável pela leitura de arquivos JSON
 */
public class JsonReader {
    

    /**
     * Função responsável por percorrer a linha Line do jsonObject e escrever uma lista com os dados do array contido no json
     * @param jsonObject JsonObject com os dados
     * @param line A string contendo no nome da chave
     * @return Retorna a lista de string com os dados que estava no vetorzinho no JSON
     */
    public static List<String> ParseJsonObjectToList(JSONObject jsonObject, String line){
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
     * Função que lê um array dentro do JSON e retorna o JSONObject do bloco
     * @param segment Qual segmeto dentro do adrquivo JSON será lido
     * @return Retorna o JSONObject com os dados desse segmento do arquivo JSON
     */
    public static JSONObject ReadArrayInArchiveJSON(int segment){
        
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();//Variaveis que irao armazenar os dados do arquivo JSON
        String texto = null;
        
        try{
            
            //Lê o arquivo JSON, o parser separa os dados e no final é tudo colocado em um array, no caso o JSONArray
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
    public List<JSONObject> readAllArraysInArchiveJSON(String filePath){
        
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        JSONParser parser = new JSONParser();//Variaveis que irao armazenar os dados do arquivo JSON
        
        try{
            InputStream input = getClass().getResourceAsStream(filePath);
            BufferedReader arqIn = new BufferedReader(new InputStreamReader(input,"UTF-8"));
            
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
    
}
