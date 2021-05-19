/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class HistorieControllerViwer implements Initializable {
    
    @FXML
    private BorderPane borderPane_scene;
    @FXML
    private ImageView imageView_scene;
    @FXML
    private BorderPane borderPane_historie;
    @FXML
    private Label label_titleHistorie;
    @FXML
    private ImageView imageView_character;
    @FXML
    private Label label_descripitionHistorie;
    @FXML
    private Button button_next;
    @FXML
    private Button button_back;
    @FXML
    private Button button_option01;
    @FXML
    private Button button_option02;
    @FXML
    private Button button_option03;
    
     List<Button> buttonList = new ArrayList<Button>();
    
    
    @FXML
    private VBox vbox_option;
    
    @FXML
    private BorderPane borderPane_options;
    
    private Effect gaussianBlur = new GaussianBlur();
    
    private String SCENE_URL =  getClass().getResource("/iu/img/image_03.png").toString();
    private String CHARATER_URL =  getClass().getResource("/iu/img/acher_self.png").toString();
    private Image imgScene;
    private Image imgCharacter;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgScene = new Image(SCENE_URL);
                
        imageView_scene.setImage(imgScene);
        imageView_scene.setEffect(gaussianBlur);
        
        label_titleHistorie.setText("Dive Rock");
        
        imgCharacter = new Image(CHARATER_URL);
        imageView_character.setImage(imgCharacter);
        
        
        
        
        button_option01.setText("Soneca");
        button_option02.setText("Rafael");
        button_option03.setText("Omodei");
        button_option02.setVisible(false);


        //button_option1.setStyle("/viwer/Historie/style.css");
//        btn_option.setText("Omodei");
       // buttonList.add(button_option);
       // buttonList.add(button_option);
        
        //buttonList.add(button_option);
        
        //borderPane_options.setCenter(vbox_option);
//        
        
//        imageView_charater = new ImageView(CHARATER_URL);
//        imageView_charater.setPreserveRatio(true);
//        imageView_charater.setFitWidth(100);
//        imageView_charater.setX(100);
        //borderPane_historie.setCenter(label_titleHistorie);
        
    }    
    
}
