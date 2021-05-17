/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import com.mycompany.darktools.controller.ViwerController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class OpeningTrailerController implements Initializable {

    private Stage stage;
    private String VIDEO_URL = getClass().getResource("/iu/video/OpeningTraileDarkTools.mp4").toString();
    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private MediaView mediaView;
    @FXML
    private BorderPane borderPane;
   
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage = new Stage();
        stage.setTitle("Dark Tools");
        media  = new Media(VIDEO_URL);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaView = new MediaView(mediaPlayer);
        
        borderPane.setCenter(mediaView);
    }
    
    @FXML
    private void switchToWindow() throws IOException {
        try{
            mediaPlayer.stop();
            ViwerController viwerController = ViwerController.getStante();
            viwerController.setRoot("Home");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }

    }
    
}
