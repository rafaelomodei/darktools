/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.utils.JsonTratament;
import static com.mycompany.darktools.utils.JsonTratament.readAllArraysInArchiveJSON;
import static com.mycompany.darktools.utils.JsonTratament.readScriptSegments;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Classe responsável por armazenar os NPCs
 */
public class PersonageController {
    
    static PersonageController uniqueIndex;
    List<Personage> personages;
    
    private final ExecutorService pool = Executors.newFixedThreadPool(1);
    
    public PersonageController(){
        //personages = JsonTratament.createAllNPCs(readAllArraysInArchiveJSON("characters.json"));
        
        Future<ArrayList<Personage>> Future = pool.submit(new Callable<ArrayList<Personage>>(){
            @Override
            public ArrayList<Personage> call() throws Exception {
                return (ArrayList<Personage>) JsonTratament.createAllNPCs(readAllArraysInArchiveJSON("characters.json"));
            }
            
    
        });
        
        try {
            personages = Future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
    
    public static PersonageController getInstante(){ 
        if(uniqueIndex == null){ //se não existir a instancia
            uniqueIndex = new PersonageController(); //cria
        }
        return uniqueIndex;//se ela já existe, retorna a mesma
    }
}
