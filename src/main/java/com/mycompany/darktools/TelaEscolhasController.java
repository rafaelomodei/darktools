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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
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
public class TelaEscolhasController implements Initializable, Observer {

    
    BoardControllerImp boardControllerImp = new BoardControllerImp();
    
    @FXML
    private Label label;
    
    @FXML
    private Button nextText;
    
    @FXML
    private Button option1;
    
    @FXML
    private Button option2;
    
    
    Observable boardController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boardControllerImp.startGame();//main
        
        this.boardController = boardControllerImp;
        boardController.addObserver(this);//adiciona o observer
        
        boardControllerImp.goToNextWord();    
    }    
    
    
    @FXML
    private void nextButton() {
        boardControllerImp.goToNextWord();
        
    }
    
    private void setTextInLabel(String word){
        label.setText(word);
    }
    
    private void hideButtons(){
        option1.setVisible(false);
        option2.setVisible(false);
        
    }
    
    private void showButtons(List listChoices){
        System.out.println("Mostrar botao");
        option1.setText((String) listChoices.get(0));
        option1.setVisible(true);
        option2.setText((String) listChoices.get(1));
        option2.setVisible(true);
        
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
        //System.out.println("Mudou o rolê lá");
        //Map<String, Object> map;
        
        if(object instanceof Map){
            
            //Hashtable<String, String> my_dict = (Hashtable<String, String>) object;
            Map<String, Object> map = (Map<String, Object>) object;
            
            if(map.containsKey("word")){
                setTextInLabel((String) map.get("word"));
            }
            if(map.containsKey("showButtons")){
                System.out.println("aqui tem");
                
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
