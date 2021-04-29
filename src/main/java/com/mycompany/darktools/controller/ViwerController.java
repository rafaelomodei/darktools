package com.mycompany.darktools.controller;

import static akka.event.jul.Logger.root;
import java.io.IOException;
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
    
    
//    public void inicialize() throws IOException{
//        System.out.println(">> Função inicialize [ViwerController]");
//        scene = new Scene(ViwerController.loadFXML("/viwer/OpeningTrailer"), 1280, 720);
//        stage.setScene(scene);
//        stage.show();
//    }
    
    public static void setRoot(String fxml) throws IOException {
        
        System.out.println(">> Função setRoot [ViwerController]");
           scene.setRoot(loadFXML(fxml)); 
    }

    public static Parent loadFXML(String fxml) throws IOException {
         System.out.println(">> Função loadFXML [ViwerController]");
        FXMLLoader fxmlLoader = new FXMLLoader(ViwerController.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
