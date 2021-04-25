package com.mycompany.darktools.controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

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
//    private static Stage stage;
//            
//    public void start() throws IOException {
//        scene = new Scene(loadFXML("/fxml/Scene"), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }
//
    public static void setRoot(String fxml) throws IOException {
       scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ViwerController.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
