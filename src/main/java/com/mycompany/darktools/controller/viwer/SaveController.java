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
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class SaveController implements Initializable {

    
    
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
    
}
