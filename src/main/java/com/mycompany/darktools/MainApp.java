package com.mycompany.darktools;

import com.mycompany.darktools.controller.ScriptSegmentController;
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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.mycompany.darktools.utils.JsonTratament;
import static com.mycompany.darktools.utils.JsonTratament.readAllArraysInArchiveJSON;
import static com.mycompany.darktools.utils.JsonTratament.readScriptSegments;
import org.json.simple.JSONObject;


public class MainApp extends Application {
    

    @Override
    public void start(Stage stage) throws Exception {
        
        ViwerController.getStante().start(stage);
        
        ScriptSegmentController scriptSegmentController = new ScriptSegmentController();
         
    }


    public static void main(String[] args) {
        
        launch(args);
    }

}
