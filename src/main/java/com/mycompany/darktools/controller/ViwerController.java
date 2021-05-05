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
    private static Stage stage;
    
    static ViwerController uniqueIndex;
    
    public ViwerController(){}
    
    public static ViwerController getStante() throws IOException{
        if(uniqueIndex == null){
            System.out.println(">> Função getStante [ViwerController]");
            uniqueIndex = new ViwerController();
        }
        System.out.println(">> Função getStante RETURN [ViwerController]");
        return uniqueIndex;
    }
    
    
//    public void inicialize() throws IOException{
    public void start(Stage stage) throws IOException {
        System.out.println(">> Função inicialize [ViwerController]");
        scene = new Scene(loadFXML("/viwer/OpeningTrailer/OpeningTrailer"), 1280, 720);
        stage.setScene(scene);
        stage.show();
       
    }
    
    //ciar sigton
    public void setRoot(String fxml) throws IOException {
        
//        System.out.println(">> Função setRoot [ViwerController]");
//        Parent parent = FXMLLoader.load(getResource("main.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource(fxml + ".fxml"));
           scene.setRoot(loadFXML(fxml)); 
    }

    private  Parent loadFXML(String fxml) throws IOException {
        System.out.println(">> Função loadFXML [ViwerController]");
        URL url = ViwerController.class.getResource(fxml + ".fxml");
//        URL url = Url(fxml);
        
        System.out.println(">> URL: " + url);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        System.out.println(">> FXMLLoader: " + fxmlLoader.getLocation());
        return fxmlLoader.load();
    }
    
//    private URL Url(String fxml){
//        return getClass().getResource(fxml + ".fxml");
//    }
}
