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

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class NewSaveControllerViwer implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void switchToWindow() throws IOException {
        try{
            ViwerController viwerController = ViwerController.getStante();
            viwerController.setRoot("Home");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
    
}
