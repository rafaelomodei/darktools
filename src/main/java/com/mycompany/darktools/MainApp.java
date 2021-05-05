package com.mycompany.darktools;

import com.mycompany.darktools.controller.ViwerController;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class MainApp extends Application {
    
   public void start(Stage stage) throws IOException {
        ViwerController.getStante().start(stage);
   }

    
    public static void main(String[] args) {
        System.out.println(">> Função main iNICIANDO... [MainApp]");
        launch(args);
    }

}
