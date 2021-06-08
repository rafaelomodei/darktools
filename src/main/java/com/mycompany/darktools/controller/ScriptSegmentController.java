/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller;

import com.mycompany.darktools.model.vo.ScriptSegment;
import static com.mycompany.darktools.utils.JsonTratament.readAllArraysInArchiveJSON;
import static com.mycompany.darktools.utils.JsonTratament.readScriptSegments;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Controlador responsável pelo manuseio da lista de ScriptSegments.
 * Classe singleton.
 */
public class ScriptSegmentController {
    List<ScriptSegment> scriptSegments;
    private final ExecutorService poolScriptSegmentController = Executors.newFixedThreadPool(1);
    private final ExecutorService poolFoundScriptSegment = Executors.newFixedThreadPool(1);
    static ScriptSegmentController uniqueIndex;
    
    private ScriptSegmentController(){
        
        Future<List<ScriptSegment>> scriptSegmentControllerFuture = poolScriptSegmentController.submit(new Callable<List<ScriptSegment>>(){
            @Override
            public ArrayList<ScriptSegment> call() throws Exception {
                return (ArrayList<ScriptSegment>) readScriptSegments(readAllArraysInArchiveJSON("dados.json"));

            }
        
        });
        
        try {
            scriptSegments = scriptSegmentControllerFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            poolScriptSegmentController.shutdown();
        }
        
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
        
        SeekScriptSegment seekScriptSegment = new SeekScriptSegment(scriptSegments, id);
        
        Future<ScriptSegment> scriptSegmentControllerFuture = poolFoundScriptSegment.submit(seekScriptSegment);
        
        try {
            System.out.println("Tentativa");
            return scriptSegmentControllerFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Não foi possível encontrar o ScriptSegment");
            e.printStackTrace();
            return null;
        } finally {
            poolFoundScriptSegment.shutdown();
        }
        
        
        
        
        
    }
    
public class SeekScriptSegment implements Callable<ScriptSegment>{
    private List<ScriptSegment> scriptsegment;
    private String id;

    public SeekScriptSegment(List<ScriptSegment> scriptSegments, String id) {
        this.scriptsegment = scriptSegments;
        this.id = id;
    }

    public ScriptSegment call() throws Exception {
        for(ScriptSegment seekSegment : scriptSegments){
            if(seekSegment.getId().equalsIgnoreCase(id)){
                return seekSegment;
            }
        }
        return null;
    }
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
