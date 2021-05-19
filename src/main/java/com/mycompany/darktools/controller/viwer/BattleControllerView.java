/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;

import com.mycompany.darktools.controller.BattleController;
import com.mycompany.darktools.controller.BoardController;
import com.mycompany.darktools.controller.BoardControllerImp;
import com.mycompany.darktools.controller.ViwerController;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.utils.JsonTratament;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * Classe responsável pelo controle das batalhas
 */
public class BattleControllerView implements Initializable, Observer {

    BoardControllerImp boardControllerImp = BoardControllerImp.getInstante();
    
    BattleController battleController;
    
    Observable battleControllerObservable;
    
    @FXML
    private Button buttonEnemy;

    @FXML
    private Button buttonAttack;
    
    String selectedEnemyToAttack, selectedSkill = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<Personage> TeamEnemy = JsonTratament.createAllNPCs(JsonTratament.readAllArraysInArchiveJSON("characters.json"));//Isso deverá ser colocado na classe que fará o controle de comportamento com o sistema do dado e depois direcionado pra cá
        
        List<Personage> TeamPlayer = boardControllerImp.getBoard().getTeamPlayer().getPersonages();
        
        System.out.println("Quantidade de inimigos "+TeamEnemy.size());
        
        battleController = new BattleController(TeamEnemy, TeamPlayer);
        
        this.battleControllerObservable = battleController;
        battleControllerObservable.addObserver(this);
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
