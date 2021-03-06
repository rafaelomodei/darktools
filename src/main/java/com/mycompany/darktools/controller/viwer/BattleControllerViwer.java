/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import com.mycompany.darktools.controller.BattleController;
import com.mycompany.darktools.controller.BoardControllerImp;
import com.mycompany.darktools.controller.PersonageController;
import com.mycompany.darktools.controller.ViwerController;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.utils.JsonReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Classe responsável pelo controle de dados da interface das batalhas
 */
public class BattleControllerViwer implements Initializable, Observer {

    BoardControllerImp boardControllerImp = BoardControllerImp.getInstante();
    
    BattleController battleController;
    
    Observable battleControllerObservable;
    
    private List<ImageView> imagebodyList = new ArrayList(); 
    
    @FXML
    private ImageView imagebody_character01;
    
    @FXML
    private ImageView imagebody_character02;
    
    @FXML
    private ImageView imagebody_character03;

    @FXML
    private Pane pane_characterInfo3;

    @FXML
    private Pane pane_characterInfo2;

    @FXML
    private Pane pane_characterInfo1;

    List<ProgressBar> progressBarList = new ArrayList<ProgressBar>();
    
    @FXML
    private ProgressBar progressBar_characterLife;

    @FXML
    private ProgressBar progressBar_characterLife1;

    @FXML
    private ProgressBar progressBar_characterLife2;
    
    @FXML
    private Button bottun_special;

    @FXML
    private ImageView imageView_scene;

    List<Label> label_characterNamesList = new ArrayList<Label>();
    
    @FXML
    private Label label_characterName;

    @FXML
    private Label label_characterName1;

    @FXML
    private Label label_characterName2;
    
    @FXML
    private Label label_console;
    
    @FXML
    private Button bottun_attack;

    @FXML
    private Button bottun_shield;

    private List<ImageView> imageView_characters = new ArrayList<ImageView>();
    
    @FXML
    private ImageView imageView_character;
    
    @FXML
    private ImageView imageView_character1;
    
    @FXML
    private ImageView imageView_character2;

    @FXML
    private VBox vBox_characterInfo;

    @FXML
    private List<Button> buttonsEnemyList = new ArrayList<Button>();
    
    @FXML
    private Button botton_enemy01;

    @FXML
    private Button botton_enemy02;

    @FXML
    private Button botton_enemy03;
    
    List<VBox> vBox_enemyList = new ArrayList<VBox>();
    
    @FXML
    private VBox vBox_enemy1, vBox_enemy2, vBox_enemy3, vBox_enemy4, vBox_enemy5, vBox_enemy6, vBox_enemy7;
    
    List<ProgressBar> progressBar_enemyList = new ArrayList<ProgressBar>();
    
    @FXML
    private ProgressBar progressBar_enemyLife1, progressBar_enemyLife2, progressBar_enemyLife3, progressBar_enemyLife4, progressBar_enemyLife5, progressBar_enemyLife6, progressBar_enemyLife7;



    List<Personage> TeamEnemy;

    String selectedEnemyToAttack, selectedSkill = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JsonReader jsonTratament = new JsonReader();
        
        TeamEnemy = PersonageController.getInstance().getPersonages();
        List<Personage> TeamPlayer = boardControllerImp.getBoard().getTeamPlayer().getPersonages();//<-
        
        TeamEnemy = boardControllerImp.getBoard().getTeamEnemy().getPersonages();
        
        battleController = new BattleController(TeamEnemy, TeamPlayer);//isso

        this.battleControllerObservable = battleController;
        battleControllerObservable.addObserver(this);
        
        organizeViewComponentsInLists();
        
        
        updateLifeAllTeams();
        updateNames();
        updateImagesTeamPlayer();
        updateImagesTeamEnemy();
        
        setConsoleText("");
        
    }
    
    /**
     * Função que irá pegar vários componentes que se repetem na tela, e por em listas para tratamentos posteriores
     */
    private void organizeViewComponentsInLists(){
        progressBarList.add(progressBar_characterLife);
        progressBarList.add(progressBar_characterLife1);
        progressBarList.add(progressBar_characterLife2);
        
        buttonsEnemyList.add(botton_enemy01);
        buttonsEnemyList.add(botton_enemy02);
        buttonsEnemyList.add(botton_enemy03);
        
        label_characterNamesList.add(label_characterName);
        label_characterNamesList.add(label_characterName1);
        label_characterNamesList.add(label_characterName2);
        
        imagebodyList.add(imagebody_character01);
        imagebodyList.add(imagebody_character02);
        imagebodyList.add(imagebody_character03);
        
        imageView_characters.add(imageView_character);
        imageView_characters.add(imageView_character1);
        imageView_characters.add(imageView_character2);
        
        vBox_enemyList.add(vBox_enemy1);
        vBox_enemyList.add(vBox_enemy2);
        vBox_enemyList.add(vBox_enemy3);
        vBox_enemyList.add(vBox_enemy4);
        vBox_enemyList.add(vBox_enemy5);
        vBox_enemyList.add(vBox_enemy6);
        vBox_enemyList.add(vBox_enemy7);
        
        progressBar_enemyList.add(progressBar_enemyLife1);
        progressBar_enemyList.add(progressBar_enemyLife2);
        progressBar_enemyList.add(progressBar_enemyLife3);
        progressBar_enemyList.add(progressBar_enemyLife4);
        progressBar_enemyList.add(progressBar_enemyLife5);
        progressBar_enemyList.add(progressBar_enemyLife6);
        progressBar_enemyList.add(progressBar_enemyLife7);
        
        for(int i = 0; i<TeamEnemy.size(); i++){
            buttonsEnemyList.get(i).setVisible(true);
        }
        
        for(int i = 0; i<vBox_enemyList.size(); i++ ){
            vBox_enemyList.get(i).setVisible(false);
            //progressBar_enemyList.get(i).setVisible(false);
        }
    }
    
    /**
     * Função que irá selecionar o tipo de ataque realizado, e executa-lo.
     */
    @FXML
    private void attack(){
        System.out.println("Ataque selecionado!");
        setConsoleText("Ataque selecionado!");
        
        selectedSkill = "0";
        
        if(selectedEnemyToAttack != null){
            battleController.battleTurn(0,Integer.parseInt(selectedEnemyToAttack));
            setConsoleText("Inimigo atacado!");
            selectedSkill = null;
            selectedEnemyToAttack = null;
        } else {
            setConsoleText("Selecione o inimigo a ser atacado!");
            System.out.println("Selecione o inimigo a ser atacado!");
        }
        
    }
    
    /**
     * Função que sereciona o inimigo que será atacado
     */
    @FXML
    private void selectEnemy(){
        System.out.println("Enemy0 selecionado!");
        setConsoleText("Enemy0 selecionado!");
        selectedEnemyToAttack = "0";
    }
    
    @FXML
    private void selectEnemy1(){
        System.out.println("Enemy1 selecionado!");
        setConsoleText("Enemy1 selecionado!");
        selectedEnemyToAttack = "1";
    }
    
    @FXML
    private void selectEnemy2(){
        System.out.println("Enemy2 selecionado!");
        setConsoleText("Enemy2 selecionado!");
        selectedEnemyToAttack = "2";
    }
    
    @FXML
    private void selectEnemy3(){
        System.out.println("Enemy3 selecionado!");
        setConsoleText("Enemy3 selecionado!");
        selectedEnemyToAttack = "2";
    }
    
    @FXML
    private void selectEnemy4(){
        System.out.println("Enemy4 selecionado!");
        setConsoleText("Enemy4 selecionado!");
        selectedEnemyToAttack = "2";
    }
    
    @FXML
    private void selectEnemy5(){
        System.out.println("Enemy5 selecionado!");
        setConsoleText("Enemy5 selecionado!");
        selectedEnemyToAttack = "2";
    }
    
    @FXML
    private void selectEnemy6(){
        System.out.println("Enemy6 selecionado!");
        setConsoleText("Enemy6 selecionado!");
        selectedEnemyToAttack = "2";
    }
    
    /**
     * Função que atualiza a vida de todos no campo de batalha.
     */
    private void updateLifeAllTeams(){
        for(int i = 0; i < boardControllerImp.getBoard().getTeamPlayer().getPersonages().size(); i++){
            progressBarList.get(i).setProgress((double)lifeNormalize(boardControllerImp.getBoard().getTeamPlayer().getPersonages().get(i).getMaxlife(), boardControllerImp.getBoard().getTeamPlayer().getPersonages().get(i).getLife())/100);
            //System.out.println("Vida atual de "+boardControllerImp.getBoard().getTeamPlayer().getPersonages().get(i).getName()+" na interface e "+(double)boardControllerImp.getBoard().getTeamPlayer().getPersonages().get(i).getLife());
        }
        
        for(int i = 0; i < boardControllerImp.getBoard().getTeamEnemy().getPersonages().size(); i++){
            progressBar_enemyList.get(i).setProgress((double)lifeNormalize(boardControllerImp.getBoard().getTeamEnemy().getPersonages().get(i).getMaxlife(), boardControllerImp.getBoard().getTeamEnemy().getPersonages().get(i).getLife())/100);
        }
        
    }
    
    /**
     * Função que adapta a vida pra dar certo com o intevalo do progressBar
     * @return valor final
     */
    private float lifeNormalize(float maxlife, float currentlife){
        return (currentlife*100)/maxlife;
    }
    
    /**
     * Função responsável por atualizar os nomes dos personagens da interface
     */
    private void updateNames(){
        for(int i = 0; i < boardControllerImp.getBoard().getTeamPlayer().getPersonages().size(); i++){
            label_characterNamesList.get(i).setText(boardControllerImp.getBoard().getTeamPlayer().getPersonages().get(i).getName());
        }
    }
    
    /**
     * Função que atualizará todas as imagens de personagens do time do jogador
     * Imagens de corpo dos jogadores.
     * Imagens de rosto dos jogadores.
     */
    private void updateImagesTeamPlayer(){
        for(int i = 0; i < boardControllerImp.getBoard().getTeamPlayer().getPersonages().size(); i++){
            if(boardControllerImp.getBoard().getTeamPlayer().getPersonages().get(i).isIsActiveToBattle()){
                imagebodyList.get(i).setImage(new Image(boardControllerImp.getBoard().getTeamPlayer().getPersonages().get(i).getPathImageBody()));
            } else {
                imagebodyList.get(i).setVisible(false);
                setConsoleText(boardControllerImp.getBoard().getTeamPlayer().getPersonages().get(i).getName()+ " morreu em batalha!");
            }
            imageView_characters.get(i).setImage(new Image(boardControllerImp.getBoard().getTeamPlayer().getPersonages().get(i).getPathImageFace()));
            
        }
    }
    
    private void setConsoleText(String text){
        if(!label_console.getText().equals("Derrota!")){
            label_console.setText(text);
        }
        
    }
    
    /**
     * Função que atualizará as imagens dos inimigos no campo de batalha (Inoperante, o método faz ficar zuado)
     */
    private void updateImagesTeamEnemy(){
        for(int i = 0; i < TeamEnemy.size(); i++){
            
            if(TeamEnemy.get(i).isIsActiveToBattle()){
                vBox_enemyList.get(i).setVisible(true);
                String URL_IMAGE = TeamEnemy.get(i).getPathImageBody();
                buttonsEnemyList.get(i).setStyle("-fx-background-image: url(" + URL_IMAGE + "); -fx-background-repeat:  no-repeat; -fx-background-color: rgba(0, 0, 0, 0); -fx-background-size:  cover;");
            } else {
                vBox_enemyList.get(i).setVisible(false);
            }
           
        }
    }

    @Override
    public void update(Observable o, Object object) {
        if(object instanceof String){     
            if(object.equals("endbattle")){
                try {
                    switchToWindow("Historie");
                } catch (IOException ex) {
                    System.out.println("Erro ao passar para tela de Battle para Historie");
                }
            }
            if(object.equals("losegame")){
                System.out.println("Derrota!");
                setConsoleText("Derrota!");
                try {
                    switchToWindow("GameOver");
                } catch (IOException ex) {
                    Logger.getLogger(HistorieControllerViwer.class.getName()).log(Level.SEVERE, null, ex);
                }                      
                
            }  
            
            if(object.equals("updateTurn")){
                updateLifeAllTeams();
                updateImagesTeamPlayer();
                updateImagesTeamEnemy();
                setConsoleText("Sua vez de jogar!");
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
            ViwerController viwerController = ViwerController.getInstance();
            viwerController.setRoot(screen);
        }catch(Exception e){
            System.out.println("Erro ao acessar a tela "+ screen +" / "+e);
        }

    }
    
}
