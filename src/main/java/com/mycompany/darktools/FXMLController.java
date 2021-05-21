package com.mycompany.darktools;

import com.mycompany.darktools.controller.BoardController;
import com.mycompany.darktools.controller.BoardControllerImp;
import com.mycompany.darktools.model.dao.ConectionHibernate;
import com.mycompany.darktools.model.vo.Board;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.model.vo.Skill;
import com.mycompany.darktools.model.vo.Team;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {
    
    
    //BoardController boardController;
    BoardControllerImp boardControllerImp = BoardControllerImp.getInstante();
    Board board;
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //boardController.inicialize(); <-- erro
        
//        Skill skill = new Skill(10, "punch1");//crei a skill
//        Skill skill2 = new Skill(20, "kick1");//crei a skill
//        List<Skill> skills = new ArrayList<Skill>();
//        skills.add(skill);
//        skills.add(skill2);
 
        Skill skill1 = new Skill("Soco", 20.0f);
        Skill skill2 = new Skill("Tiro", 50.0f);
        Skill skill3 = new Skill("Bola de fogo", 20.0f);
        List<Skill> skillList = new ArrayList<Skill>();
        skillList.add(skill1);
        
        List<Skill> skillList1 = new ArrayList<Skill>();
        skillList1.add(skill2);
        
        List<Skill> skillList2 = new ArrayList<Skill>();
        skillList2.add(skill3);
        
//        Personage p = new Personage("Lucas", skills, "image1.png");//criei o personagem e passei a lista de skills que fiz antes
//        Personage p1 = new Personage("Maria", skills, "image2.png");//criei o personagem e passei a lista de skills que fiz antes
//        Personage p2 = new Personage("Erick", skills, "image3.png");//criei o personagem e passei a lista de skills que fiz antes

        Personage p = new Personage("Guerreiro", 100, skillList, "/iu/batlle/character.png", "/iu/character/warrior/guerreiro_back_batlle.png");
        Personage p1 = new Personage("Arqueiro", 100, skillList1, "/iu/batlle/character.png","/iu/character/acher/acher_back_battle.png");
        Personage p2 = new Personage("Mago", 100, skillList2, "/iu/batlle/character.png","/iu/character/mage/mago_back_batlle.png");

        List<Personage> ps = new ArrayList<Personage>(); 

        ps.add(p);//coloquei o personagem na lista de personagens
        ps.add(p1);
        ps.add(p2);
        
        Team t = new Team(ps,200.0); //criei o time com a lista de personagens que fiz

        try {
            board = new Board(t,8100,"save1","1d"); //criei a mesa com o time, que é nós
            
            //boardController.saveGame(board);//salvei  
            boardControllerImp.saveGame(board);
            //boardController.upgradeSave(board);
            
        } catch (Exception e) {
            System.out.println("erro no salvamento = "+e);
        }   
        
        ConectionHibernate.close();
    }
    
    @FXML
    private void loadButtonAction(ActionEvent event) {
        List<Board> boardList;//criei a mesa pegará o save
        Board board2;

        //boardList = boardController.loadGames();
        boardList = boardControllerImp.loadGames();
//        for(Board b: boardList){
//            System.out.println("Saves: "+b.getNameSave());
//        }
        
        board2 = boardList.get(0);//é carregado a mesa do banco, pegando a primeira que tá lá

        //abaixo só printa as coisas que foram persistidas
        System.out.println("name save: "+board2.getNameSave()+ "\n pessoas vivas: "+board2.getCityPeoplesAlive()+"\n segment stopped: "+board2.getSegmentStoppedId());
        System.out.println("Nome do primeiro personagem: "+board2.getTeamPlayer().getPersonages().get(0).getName());
        System.out.println("Nome da primeira skill do personagem: "+board2.getTeamPlayer().getPersonages().get(0).getSkills().get(0).getName());
        
        
    }
    
    @FXML
    private void deleteSaveButtonAction(ActionEvent event) {
        //boardController.deleteSave(board);
        boardControllerImp.deleteSave(board);
        ConectionHibernate.close();
    }
    
    @FXML
    private void upgradeSaveButtonAction(ActionEvent event) {
        //boardController.upgradeSave(board);
        boardControllerImp.upgradeSave(board);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //boardController = new BoardControllerImp();//controlador
        
        //boardControllerimp = new BoardControllerImp();
        
        //boardController.inicialize();
        boardControllerImp.inicialize();
    }    
}
