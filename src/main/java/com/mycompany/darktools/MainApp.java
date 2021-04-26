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
    
   private String VIDEO_URL = getClass().getResource("/video/trailer_dark_tools.mp4").toString();
   private static Scene scene;
    
   @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(ViwerController.loadFXML("/viwer/OpeningTrailer"), 1080, 720);
        stage.setScene(scene);
        stage.show();
        
        Media media = new Media(VIDEO_URL); // 1
        MediaPlayer mediaPlayer = new MediaPlayer(media); // 2
        MediaView mediaView = new MediaView(mediaPlayer); // 3
        
        StackPane raiz = new StackPane();
        raiz.getChildren().add(mediaView); // 4
        Scene cena = new Scene(raiz, 600, 400);
        stage.setTitle("Tocando Video em JavaFX");
        stage.setScene(cena);
        stage.show();
        mediaPlayer.play(); // 
        
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
