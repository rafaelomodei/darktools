/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools;

import com.mycompany.darktools.controller.BoardControllerImp;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class TelaEscolhasController implements Initializable, Observer {

    BoardControllerImp boardControllerImp = BoardControllerImp.getInstante();
   
    
    @FXML
    private Label label;
    
    @FXML
    private Button nextText;
    
    @FXML
    private Button option1;
    
    @FXML
    private Button option2;
    
    List<Button> buttonList = new ArrayList<Button>();
    
    Observable boardController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boardControllerImp.startGame("");//main
        
        
        buttonList.add(option1);
        buttonList.add(option2);
        
        this.boardController = boardControllerImp;
        boardController.addObserver(this);//adiciona o observer
        
        boardControllerImp.goToNextWord();    
    }    
    
    
    @FXML
    private void nextButton() {
        boardControllerImp.goToNextWord();
        
    }
    
    /**
     * Setar o texto da fala
     * @param word String com a fala
     */
    private void setTextInLabel(String word){
        label.setText(word);
    }
    
    private void hideButtons(){
        option1.setVisible(false);
        option2.setVisible(false);
        
        
    }
    
    private void showButtons(List listChoices){
        
        for(int i=0; i<listChoices.size(); i++){
            buttonList.get(i).setText(listChoices.get(i).toString());
            buttonList.get(i).setVisible(true);
        }
        
    }
    
    @FXML
    private void option1Button() {
        boardControllerImp.goToNextScriptSegment(0);
               
    }
    
    @FXML
    private void option2Button() {
        boardControllerImp.goToNextScriptSegment(1);
        
    }

    @Override
    public void update(Observable boardController, Object object) {
        
        if(object instanceof Map){
            
            Map<String, Object> map = (Map<String, Object>) object;
            
            if(map.containsKey("word")){
                setTextInLabel((String) map.get("word"));
            }
            if(map.containsKey("showButtons")){
                showButtons((List) map.get("showButtons"));
            }
            
        }
        if(object instanceof String){
            if(object.equals("hideButtons")){
                hideButtons();
            }
            
        }
    }
    
    
}
