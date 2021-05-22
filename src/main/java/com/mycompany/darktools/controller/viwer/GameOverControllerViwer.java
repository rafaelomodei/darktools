package com.mycompany.darktools.controller.viwer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.darktools.controller.ViwerController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class GameOverControllerViwer implements Initializable {

   @FXML
    private Label label_nameGame;

    @FXML
    private Button button_exit;

    @FXML
    private Label label_gameOver;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    
    @FXML
    private void switchToWindowCredits() throws IOException {
        ViwerController viwerController = ViwerController.getStante();
        viwerController.setRoot("Credits");
    }
    
    @FXML
    private void switchToWindowBack() throws IOException {
        ViwerController viwerController = ViwerController.getStante();
        viwerController.setRoot("Home");
    }


    
    
}
