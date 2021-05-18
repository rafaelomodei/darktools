/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller.viwer;
import com.mycompany.darktools.controller.BattleController;
import com.mycompany.darktools.controller.ViwerController;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class BattleTestController implements Initializable, Observer{

    BattleController battleController;
    
    @FXML
    private Button buttonenemy;

    @FXML
    private Button buttonattack;

    @FXML
    private Button buttonskill;

    @FXML
    private Button buttondefense;
    
    int enemySelected, skillSelected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //battleController = new BattleController(TeamEnemy, TeamPlayer);
    }
    
    private void SelectEnemy0(){
        enemySelected = 0;
    }
    
    private void SelectSkill0(){
        skillSelected = 0;
    }
    
    private void attack(){
        
    }
    
    public void switchScreen(){
        try {
            ViwerController viwerController = ViwerController.getStante();
            viwerController.setRoot("BattleTest");
        } catch (Exception e) {
            System.out.println("Erro ao mudar para tela de combate! "+e);
        }
    }

    @Override
    public void update(Observable o, Object o1) {
        
    }
    
}
