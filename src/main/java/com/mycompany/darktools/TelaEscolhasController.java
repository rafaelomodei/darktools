/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools;

import com.mycompany.darktools.controller.BoardControllerImp;
import com.mycompany.darktools.controller.ScriptSegmentController;
import com.mycompany.darktools.model.vo.ScriptSegment;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class TelaEscolhasController implements Initializable {

    
    BoardControllerImp boardControllerImp = new BoardControllerImp();
    
    @FXML
    private Label label;
    
    @FXML
    private Button nextText;
    
    @FXML
    private Button option1;
    
    @FXML
    private Button option2;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boardControllerImp.startGame();
        
        label.setText(""+boardControllerImp.goToNextWord());        
    }    
    
    
    @FXML
    private void nextButton() {
        label.setText(""+boardControllerImp.goToNextWord());
        
    }
    
    @FXML
    private void option1Button() {
        boardControllerImp.goToNextScriptSegment(0);
               
    }
    
    @FXML
    private void option2Button() {
        boardControllerImp.goToNextScriptSegment(1);
        
    }
    
    
}
