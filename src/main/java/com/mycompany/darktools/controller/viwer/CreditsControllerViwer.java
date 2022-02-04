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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class CreditsControllerViwer implements Initializable {

    @FXML
    private Label label_credits;

    @FXML
    private Button button_back;

    @FXML
    private Label label_nameGame;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
        @FXML
    private void switchToWindow() throws IOException {
        ViwerController viwerController = ViwerController.getInstance();
        viwerController.setRoot("Home");
    }
    
}
