/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.utils;

/**
 * Classe responsável pela escrita de arquivos JSON
 */
public class JsonWriter {
    /***
     * Função que escreve no arquivo JSON (Teste)
     *
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
    */
}
