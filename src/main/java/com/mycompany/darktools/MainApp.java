package com.mycompany.darktools;

import com.mycompany.darktools.controller.ViwerController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class MainApp extends Application {
    
   private static Scene scene;
    
   @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(ViwerController.loadFXML("/viwer/OpeningTrailer"), 1280, 720);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }

}
