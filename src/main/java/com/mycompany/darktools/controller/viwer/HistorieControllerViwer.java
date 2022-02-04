/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import com.mycompany.darktools.controller.BoardControllerImp;
import com.mycompany.darktools.controller.ViwerController;
//import java.awt.event.KeyEvent;
//import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
/**
 * Classe responsável pelas batalhas
 */
public class HistorieControllerViwer implements Initializable, Observer {

    BoardControllerImp boardControllerImp = BoardControllerImp.getInstante();
    
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
    @FXML
    private Pane pane_console;
    @FXML
    private Label label_console;
    
    List<Button> buttonList = new ArrayList<Button>();
    
    Observable boardControllerObservable;
    
    @FXML
    private BorderPane border_paneMenu;
    
    @FXML
    private BorderPane borderPane_options;
    
    private Effect gaussianBlur = new GaussianBlur();
    
    private String SCENE_URL =  getClass().getResource("/iu/backgroun/save/saveBackgroung.png").toString();
    private String CHARATER_URL =  getClass().getResource("/iu/img/goblin4_self.png").toString();
    private Image imgScene;
    private Image imgCharacter;
    
    @FXML
    private AnchorPane page;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        imgScene = new Image(SCENE_URL);
                
        imageView_scene.setImage(imgScene);
        imageView_scene.setEffect(gaussianBlur);
        
        imgCharacter = new Image(CHARATER_URL);
        imageView_character.setImage(imgCharacter);
        
        this.boardControllerObservable = boardControllerImp;
        boardControllerObservable.addObserver(this);//adiciona o observer
                
        buttonList.add(button_option01);
        buttonList.add(button_option02);
        buttonList.add(button_option03);
        
        button_back.setVisible(false);
        
        hideButtons();
        
        setStateMenu(false);
        
        //boardControllerImp.goToNextWord();  
//        boardControllerImp.readWord(0);
        
        page.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                //System.out.println("A letra "+event.getCode().getName());
                if(event.getCode() == KeyCode.ESCAPE){
                    setStateMenu(!getStateMenu());
                }
            }
            
        });
        
    }
    
    /** Essas funções deve ser retiradas!**/
    @FXML
    private void buttonOption0(){
        boardControllerImp.goToNextScriptSegment(0);
        setTextInButtonNext("Próximo");
    }
    
    @FXML
    private void buttonOption1(){
        boardControllerImp.goToNextScriptSegment(1); 
        setTextInButtonNext("Próximo");
    }
    
    @FXML
    private void buttonOption2(){
        boardControllerImp.goToNextScriptSegment(2);
        setTextInButtonNext("Próximo");
    }
    
    @FXML
    private void buttonOption3(){
        boardControllerImp.goToNextScriptSegment(3);
        setTextInButtonNext("Próximo");
    }
    
    @FXML
    private void buttonOption4(){
        boardControllerImp.goToNextScriptSegment(4); 
        setTextInButtonNext("Próximo");
    }
    
    @FXML
    private void buttonOption5(){
        boardControllerImp.goToNextScriptSegment(5);
        setTextInButtonNext("Próximo");
    }
    
    @FXML
    private void buttonNextWord(){     
        boardControllerImp.goToNextWord();
    }
        
    /**
     * Essa função direciona para o salvamento da Board atual
     */
    @FXML
    private void saveGame() {
        
        try {
            boardControllerImp.inicialize();
            System.out.println("Jogo salvo!");
        } catch (Exception e) {
            System.out.println("Erro! = "+e );
        }
        //boardControllerImp.saveGame(boardControllerImp.getBoard());
        
        //pane_console.setVisible(true);
        //label_console.setText("Jogo Salvo!");
        //ConectionHibernate.close();
    }

    /**
     * Função direciona para o menu
     * @throws IOException 
     */
    @FXML
    private void returnToMenu() throws IOException {
        System.out.println("Retorne ao menu!");
        switchToWindow("Home");
    }

    /**
     * Seta o estado do menu
     * @param value True = Ativo e visíviel. False = Desativo e invisível;
     */
    private void setStateMenu(boolean value){
        border_paneMenu.setVisible(value);
        if(getStateMenu() == false){
            pane_console.setVisible(false);
        }
    }
    
    private boolean getStateMenu(){
        return border_paneMenu.isVisible();
    }
    
    /**
     * Setar o texto da fala
     * @param word String com a fala
     */
    private void setTextInLabelHistory(String word){
        label_descripitionHistorie.setText(word);
    }
    
    /**
     * Setar o nome de quem tá falando o texto
     * @param title String com o nome de quem fala
     */
    private void setTextInLabelTitle(String title){
        label_titleHistorie.setText(title);
    }
    
    /**
     * Seta a imagem de quem fala no momento
     */
    private void setImageFace(String pathImageFace){
        
        imgCharacter = new Image(pathImageFace);
        imageView_character.setImage(imgCharacter);
        
    }
    
    private void setTextInButtonNext(String text){
        button_next.setText(text);
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
                setTextInButtonNext("Repetir");
            }
            if(map.containsKey("pathimageface")){
                setImageFace((String)map.get("pathimageface"));
            }
            
        }
        if(object instanceof String){
            if(object.equals("hideButtons")){
                hideButtons();
            }
            
            if(object.equals("battle")){
                try {
                    switchToWindow("Battle");
                } catch (IOException ex) {
                    Logger.getLogger(HistorieControllerViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(object.equals("losegame")){
                try {
                    switchToWindow("GameOver");
                } catch (IOException ex) {
                    Logger.getLogger(HistorieControllerViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(object.equals("endGame")){
                try {
                    switchToWindow("Victory");
                } catch (IOException ex) {
                    Logger.getLogger(HistorieControllerViwer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
    
    /**
     * Função que muda para outra tela
     * @param Screen String com o nome ta tela
     * @throws IOException 
     */
    @FXML
    private void switchToWindow(String screen) throws IOException {
        try{
            ViwerController viwerController = ViwerController.getStante();
            viwerController.setRoot(screen);
        }catch(Exception e){
            System.out.println("Erro ao acessar a tela "+ screen +" / "+e);
        }

    }
    
}
