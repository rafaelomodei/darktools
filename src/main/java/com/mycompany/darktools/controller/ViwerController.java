package com.mycompany.darktools.controller;

import static akka.event.jul.Logger.root;
import static com.google.common.io.Resources.getResource;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafae
 */
public class ViwerController {
    
    private static Scene scene;
    private final double width = 1280;
    private final double height = 720;
    
    private String STYLESHEET_MODENA = "OpeningTrailer";
    
    static ViwerController uniqueIndex;
    
    public ViwerController(){}
    
    public static ViwerController getStante() throws IOException{
        if(uniqueIndex == null){
           
            uniqueIndex = new ViwerController();
        }
        return uniqueIndex;
    }
    
    
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(STYLESHEET_MODENA), width, height);
        stage.setScene(scene);
        stage.show();
       
    }
    
    public void setRoot(String fxml) throws IOException {
        try{
            scene.setRoot(loadFXML(fxml));    
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = null;
        try{                                                                // /viwer/fxml/fxml.fmxl
            fxmlLoader = new FXMLLoader(ViwerController.class.getResource("/viwer/" + fxml + "/" + fxml + ".fxml"));
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
        
        return fxmlLoader.load();
    }
    
}
