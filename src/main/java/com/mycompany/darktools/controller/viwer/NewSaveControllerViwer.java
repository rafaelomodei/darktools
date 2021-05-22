/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import com.mycompany.darktools.controller.BoardControllerImp;
import com.mycompany.darktools.controller.ViwerController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class NewSaveControllerViwer implements Initializable {

    BoardControllerImp boardControllerImp = BoardControllerImp.getInstante();
    
    @FXML
    private TextField textField_nameSave;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void switchToHome() throws IOException {
        try{
            ViwerController viwerController = ViwerController.getStante();
            viwerController.setRoot("Home");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
    
    @FXML
    private void startNewGame() throws IOException {
        try{
            System.out.println("Valor no textfield = "+textField_nameSave.getText());
            boardControllerImp.startGame(textField_nameSave.getText());
            ViwerController viwerController = ViwerController.getStante();
            viwerController.setRoot("Historie");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
    
}
