/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class LoadingController implements Initializable {
    
    @FXML
    private BorderPane bp_background;

    @FXML
    private ImageView imgv_background;

    @FXML
    private BorderPane bp_loading;

    @FXML
    private MediaView md_loading;

    @FXML
    private Label lb_title;

    @FXML
    private Label lb_description;
    
    private Media media;
    private MediaPlayer mediaPlayer;
    
    private String BACKGROUNG_URL =  getClass().getResource("/iu/img/image_02.png").toString();
    private String LOADING_URL =  getClass().getResource("/iu/video/loading.mp4").toString();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       imgv_background = new ImageView(BACKGROUNG_URL);
       imgv_background.setPreserveRatio(true);
       imgv_background.setFitWidth(1280);
       imgv_background.setX(152.0);
       bp_background.setCenter(imgv_background);
       
       media  = new Media(LOADING_URL);
       mediaPlayer = new MediaPlayer(media);
       mediaPlayer.setAutoPlay(true);
       md_loading = new MediaView(mediaPlayer);
       bp_loading.setCenter(md_loading);
//       bp_loading.setS
//       mediaPlayer.play();
    }    
    
}
