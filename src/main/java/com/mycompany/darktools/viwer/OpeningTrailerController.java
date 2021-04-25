/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.viwer;

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
public class OpeningTrailerController implements Initializable {

    @FXML
    private Label lb_open;

    @FXML
    private Button btn_next;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        ViwerController.setRoot("/fxml/Scene");
    }
    
}
