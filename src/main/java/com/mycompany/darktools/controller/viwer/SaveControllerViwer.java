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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class SaveControllerViwer implements Initializable {

    BoardControllerImp boardControllerImp = BoardControllerImp.getInstante();
    
    @FXML
    private CheckBox cb_Easy;

    @FXML
    private CheckBox cb_medium;

    @FXML
    private CheckBox cb_hard;

    @FXML
    private Button btn_exit;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void startNewGame() throws IOException {
        try{
            boardControllerImp.startGame();//comeca o jogo tem que por em outro lugar e aqui tem que ficar uma função para dar continuidade ao sair das outras telas
            ViwerController viwerController = ViwerController.getStante();
            viwerController.setRoot("Historie");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
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
}
