/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import com.mycompany.darktools.controller.BoardControllerImp;
import java.beans.EventHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class HistorieControllerViwer implements Initializable, Observer {
    
    @FXML
    private BorderPane borderPane_scene;
    @FXML
    private ImageView imageView_scene;
    @FXML
    private BorderPane borderPane_historie;
    @FXML
    private Label label_titleHistorie;
    @FXML
    private ImageView imageView_character;
    @FXML
    private Label label_descripitionHistorie;
    @FXML
    private Button button_next;
    @FXML
    private Button button_back;
    @FXML
    private Button button_option01;
    @FXML
    private Button button_option02;
    @FXML
    private Button button_option03;
    
    List<Button> buttonList = new ArrayList<Button>();
    
    Observable boardController;
    
    @FXML
    private VBox vbox_option;
    
    @FXML
    private BorderPane borderPane_options;
    
    private Effect gaussianBlur = new GaussianBlur();
    
    private String SCENE_URL =  getClass().getResource("/iu/img/image_03.png").toString();
    private String CHARATER_URL =  getClass().getResource("/iu/img/acher_self.png").toString();
    private Image imgScene;
    private Image imgCharacter;
<<<<<<< HEAD:src/main/java/com/mycompany/darktools/controller/viwer/HistorieController.java
   
=======
    /**
     * Initializes the controller class.
     */
    
>>>>>>> viwer:src/main/java/com/mycompany/darktools/controller/viwer/HistorieControllerViwer.java
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boardControllerImp.startGame();//comeca o jogo
        
        imgScene = new Image(SCENE_URL);
                
        imageView_scene.setImage(imgScene);
        imageView_scene.setEffect(gaussianBlur);
        
        label_titleHistorie.setText("Dive Rock");
        
        imgCharacter = new Image(CHARATER_URL);
        imageView_character.setImage(imgCharacter);
        
        this.boardController = boardControllerImp;
        boardController.addObserver(this);//adiciona o observer
                
        buttonList.add(button_option01);
        buttonList.add(button_option02);
        buttonList.add(button_option03);
        
        button_back.setVisible(false);
        
        hideButtons();
        
        boardControllerImp.goToNextWord();  
        
    }
    
    /** Essas funções deve ser retiradas!**/
    @FXML
    private void buttonOption0(){
        boardControllerImp.goToNextScriptSegment(0); 
    }
    
    @FXML
    private void buttonOption1(){
        boardControllerImp.goToNextScriptSegment(1); 
    }
    
    @FXML
    private void buttonOption2(){
        boardControllerImp.goToNextScriptSegment(2); 
    }
    
    @FXML
    private void buttonOption3(){
        boardControllerImp.goToNextScriptSegment(3); 
    }
    
    @FXML
    private void buttonOption4(){
        boardControllerImp.goToNextScriptSegment(4); 
    }
    
    @FXML
    private void buttonOption5(){
        boardControllerImp.goToNextScriptSegment(5); 
    }
    
    @FXML
    private void buttonNextWord(){
        
        boardControllerImp.goToNextWord();
        
    }

    /**
     * Setar o texto da fala
     * @param word String com a fala
     */
    private void setTextInLabelHistory(String word){
        label_descripitionHistorie.setText(word);
    }
    
    private void setTextInLabelTitle(String title){
        label_titleHistorie.setText(title);
    }
    
    /**
     * Função que esconde os botões
     */
    private void hideButtons(){
        
        for(int i=0; i<buttonList.size(); i++){
            buttonList.get(i).setVisible(false);
        }
 
    }
    
    /**
     * Mostra os botões com o texto
     * @param listChoices Lista com os textos das opções de escolha
     */
    private void showButtons(List listChoices){
        
        for(int i=0; i<listChoices.size(); i++){
            buttonList.get(i).setText(listChoices.get(i).toString());
            buttonList.get(i).setVisible(true);
        }
        
    }    

    /**
     * Função update do Observer
     * @param o
     * @param object Objeto que está recebendo do controlador "linkado" 
     */
    @Override
    public void update(Observable o, Object object) {
        if(object instanceof Map){
            
            Map<String, Object> map = (Map<String, Object>) object;
            
            if(map.containsKey("word")){
                setTextInLabelHistory((String) map.get("word"));
            }
            if(map.containsKey("title")){
                setTextInLabelTitle((String) map.get("title"));
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
