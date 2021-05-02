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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class HistorieController implements Initializable {
    
     @FXML
    private BorderPane borderPane_scene;

    @FXML
    private ImageView imageView_scene;

    @FXML
    private BorderPane borderPane_historie;

    @FXML
    private Label label_titleHistorie;

    @FXML
    private ImageView imageView_charater;

    @FXML
    private Label label_descripitionHistorie;

    @FXML
    private Button button_next;
    
    private String SCENE_URL =  getClass().getResource("/iu/img/image_02.png").toString();
    private String CHARATER_URL =  getClass().getResource("/iu/img/acher_self.png").toString();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageView_scene = new ImageView(SCENE_URL);
        imageView_scene.setPreserveRatio(true);
        imageView_scene.setFitWidth(1280);
        imageView_scene.setX(152.0);
        borderPane_scene.setCenter(imageView_scene);
        
        imageView_charater = new ImageView(CHARATER_URL);
        imageView_charater.setPreserveRatio(true);
        imageView_charater.setFitWidth(100);
        imageView_charater.setX(100);
        borderPane_historie.setCenter(imageView_charater);
        
    }    
    
}
