/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import com.mycompany.darktools.controller.BoardControllerImp;
import com.mycompany.darktools.controller.ViwerController;
import java.io.FileInputStream;
import java.io.IOException;
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
public class HomeControllerViwer implements Initializable {
    

    BoardControllerImp boardControllerImp = BoardControllerImp.getInstante();
    
    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView background;

    @FXML
    private Button button_exit;

    @FXML
    private Button button_credits;

    @FXML
    private Button button_start;
    
    @FXML
    private Button btn_start;

    private String BACKGROUNG_URL =  getClass().getResource("/iu/img/image_02.png").toString();
    
    public void start(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       background = new ImageView(BACKGROUNG_URL);
       background.setPreserveRatio(true);
       background.setFitWidth(1280);
       background.setX(152.0);
       borderPane.setCenter(background);
    }   
    
    @FXML
    private void switchToNewGame() throws IOException {
        try{
            ViwerController viwerController = ViwerController.getInstance();
            viwerController.setRoot("NewSave");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
    
    @FXML
    private void loadGamePage() throws IOException {
        ViwerController viwerController = ViwerController.getInstance();
        viwerController.setRoot("Save");
    }
    
    @FXML
    void switchToWindowCredits() throws IOException {
        try{
            ViwerController viwerController = ViwerController.getInstance();
            viwerController.setRoot("Credits");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }

    @FXML
    void switchToWindowExit() throws IOException {
        try{
            System.exit(0);
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
    
}
