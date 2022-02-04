/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.model.vo.Skill;
import com.mycompany.darktools.utils.JsonReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

/**
 * Classe responsável pelo controle dos dados de personagens do jogo.
 */
public class PersonageController {
    static PersonageController uniqueIndex;
    List<Personage> personages;
    
    private PersonageController(){
        JsonReader jsonTratament = new JsonReader();
        personages = CreateAllNPCs(jsonTratament.readAllArraysInArchiveJSON("/data/characters.json"));
    }
    
    public static PersonageController getInstance(){ 
        if(uniqueIndex == null){ //se não existir a instancia
            uniqueIndex = new PersonageController(); //cria
        }
        return uniqueIndex;//se ela já existe, retorna a mesma
    }
    
    /**
     * Função que cria a lista de NPCs de acordo com as informações contidas no Json dos NPCs
     * @param jsonObject Os dados pego do arquivo JSON
     * @return Lista de personagens contendo os NPCs
     */
    private List<Personage> CreateAllNPCs(List<JSONObject> jsonObjects){
        
        List<Personage> personages = new ArrayList<Personage>();
        
        for(JSONObject data: jsonObjects){           
            personages.add(CreateNPC(data));
        }
        
        return personages;
        
    }
    
    /**
     * Função que cria o NPC de acordo com os dados do JSON de characters
     * @param jsonObject JsonObject com o segmento de dados do 
     * @return Retorna a instância Personage com dados do NPC
     */
    private Personage CreateNPC(JSONObject jsonObject){
        
        List<Skill> skills = new ArrayList<Skill>();
        
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

    public List<Personage> getPersonages() {
        return personages;
    }
    
    
}
