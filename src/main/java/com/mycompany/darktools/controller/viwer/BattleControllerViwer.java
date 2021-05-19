/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import com.mycompany.darktools.controller.BattleController;
import com.mycompany.darktools.controller.BoardControllerImp;
import com.mycompany.darktools.controller.ViwerController;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.utils.JsonTratament;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Rafae
 */
public class BattleControllerViwer implements Initializable, Observer {

    BoardControllerImp boardControllerImp = BoardControllerImp.getInstante();
    
    BattleController battleController;
    
    Observable battleControllerObservable;
    
    @FXML
    private ImageView imageView_character1;

    @FXML
    private Pane pane_characterInfo3;

    @FXML
    private Pane pane_characterInfo2;

    @FXML
    private Pane pane_characterInfo1;

    @FXML
    private ProgressBar progressBar_characterLife;

    @FXML
    private Button bottun_special;

    @FXML
    private ProgressBar progressBar_characterLife2;

    @FXML
    private ProgressBar progressBar_characterLife1;

    @FXML
    private ImageView imageView_character2;

    @FXML
    private ImageView imageView_scene;

    @FXML
    private Label label_characterName;

    @FXML
    private Button bottun_attack;

    @FXML
    private Label label_characterName2;

    @FXML
    private Label label_characterName1;

    @FXML
    private Button bottun_shield;

    @FXML
    private ImageView imageView_character;

    @FXML
    private VBox vBox_characterInfo;

    @FXML
    private Button bottun_enemy05;

    @FXML
    private Button bottun_enemy06;

    @FXML
    private Button bottun_enemy07;

    @FXML
    private Button bottun_enemy01;

    @FXML
    private Button bottun_enemy02;

    @FXML
    private Button bottun_enemy03;

    @FXML
    private Button bottun_enemy04;

    String selectedEnemyToAttack, selectedSkill = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<Personage> TeamEnemy = JsonTratament.createAllNPCs(JsonTratament.readAllArraysInArchiveJSON("characters.json"));//Isso deverá ser colocado na classe que fará o controle de comportamento com o sistema do dado e depois direcionado pra cá
        
        List<Personage> TeamPlayer = boardControllerImp.getBoard().getTeamPlayer().getPersonages();
        
        battleController = new BattleController(TeamEnemy, TeamPlayer);
        
        //battleController = new BattleController(TeamEnemy, TeamEnemy);
        
        this.battleControllerObservable = battleController;
        battleControllerObservable.addObserver(this);
        
        bottun_enemy01.setVisible(true);
        
        bottun_enemy02.setVisible(true);
        
        bottun_enemy03.setVisible(true);
    }
    
    /**
     * Função que irá selecionar o tipo de ataque realizado, e executa-lo.
     */
    @FXML
    private void attack(){
        System.out.println("Ataque selecionado!");
        
        selectedSkill = "0";
        
        if(selectedEnemyToAttack != null){
            battleController.battleTurn(0,0,Integer.parseInt(selectedEnemyToAttack));
            selectedSkill = null;
            selectedEnemyToAttack = null;
        } else {
            System.out.println("Selecione o inimigo a ser atacado!");
        }
        
    }
    
    /**
     * Função que sereciona o inimigo que será atacado
     */
    @FXML
    private void selectEnemy(){
        System.out.println("Enemy0 selecionado!");
        selectedEnemyToAttack = "0";
    }
    
    @FXML
    private void selectEnemy1(){
        System.out.println("Enemy1 selecionado!");
        selectedEnemyToAttack = "1";
    }
    
    @FXML
    private void selectEnemy2(){
        System.out.println("Enemy2 selecionado!");
        selectedEnemyToAttack = "2";
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
