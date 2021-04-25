package com.mycompany.darktools;

import com.mycompany.darktools.controller.ViwerController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
    
//    private static Scene scene;
//
//    @Override
//    public void start(Stage stage) throws Exception {
///       Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
//        
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
//        
//        stage.setTitle("JavaFX and Maven");
//        stage.setScene(scene);
//        stage.show();
//       // ViwerController.setRoot();
//
//       
//   
//    }
    
   private static Scene scene;
    
   @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(ViwerController.loadFXML("/viwer/OpeningTrailer"), 640, 480);
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
