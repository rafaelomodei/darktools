/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.darktools.controller;

import com.mycompany.darktools.model.br.BoardBR;
import com.mycompany.darktools.model.br.PersonageBR;
import com.mycompany.darktools.model.br.SkillBR;
import com.mycompany.darktools.model.br.TeamBR;
import com.mycompany.darktools.model.vo.Board;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.model.vo.Skill;
import com.mycompany.darktools.model.vo.Team;
import com.mycompany.darktools.utils.ScriptSegmentConditions;
import java.util.List;
import javafx.scene.media.AudioClip;

/**
 * Classe controladora da instância Board que será a base de todas as informações do jogador
 * Contém a responsabilidade do manuseio de informações da Instancia Board e a interação com as classes de regra de negócio para a persistencia de dados da classe Board e outras que a compoem.
 * @author acer
 */
public class BoardControllerImp implements BoardController{
    BoardBR boardBR;
    PersonageBR personageBR;
    SkillBR skillBR;
    TeamBR teamBR;
    
    Board board;
    
    int currentWord;//fala atual
    
    AudioClip clip;//clipe
    
    static BoardControllerImp uniqueIndex;
    
    public BoardControllerImp(){}
    
    /**
     * A classe board controller será singleton para só tem um de sua existência operante em todo o código
     * @return A instância unica do BoardController
     */
    public static BoardControllerImp getInstante(){ 
        if(uniqueIndex == null){ //se não existir a instancia
            uniqueIndex = new BoardControllerImp(); //cria
        }
        return uniqueIndex;//se ela já existe, retorna a mesma
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    
    @Override
    public void inicialize() {
        boardBR = new BoardBR();
        personageBR = new PersonageBR();
        skillBR = new SkillBR();
        teamBR = new TeamBR();
    }
    
    /**
     * Função re realiza o salvamento do jogo.
     * Sendo o jogo a Board, e todos os dados que estão contidos dentro dela.
     * @param board A instância Board que será salva no banco de dados.
     */
    @Override
    public void saveGame(Board board) {

        Team t = board.getTeamPlayer();
        Personage p = t.getPersonages().get(0);
        Skill s = p.getSkills().get(0);
        skillBR.saveAll(p.getSkills());
        personageBR.SaveAll(t.getPersonages());//salva os personagens do time
        teamBR.Save(t);//ele vai salvar o TeamPlayer que tá na board
        boardBR.Save(board);
        
    }

    /**
     * Função responsável para receber todos as mesas que foram salvas
     * @return Board com os dados
     */
    @Override
    public List<Board> loadGames() { 
        return boardBR.ListAll();
    }

    /**
     * Função responsável por deletar a board salva
     * @param board Board que será deletada
     */
    @Override
    public void deleteSave(Board board) {
        Team t = board.getTeamPlayer();
        Personage p = t.getPersonages().get(0);
        
        boardBR.Delete(board);
        
        teamBR.Delete(t);//ele vai salvar o TeamPlayer que tá na board
        
        personageBR.DeleteAll(t.getPersonages());//deleta todos os personagens do time
    }

    /**
     * Função que atualizará o save
     * @param board Board que será atualizada
     */
    @Override
    public void upgradeSave(Board board) {
        //boardBR.Upgrade(board);
        
        Team t = board.getTeamPlayer();
        Personage p = t.getPersonages().get(0);
        Skill s = p.getSkills().get(0);
        skillBR.UpgradeAll(p.getSkills());
        personageBR.UpgradeAll(t.getPersonages());
        teamBR.Upgrade(t);
        boardBR.Upgrade(board);
    }
    
    /**
     * Função que inicializa a classe board que o jogo irá utilizar para manupular dados.
     * O começo do game inicia com dados padrões, assim que for realizado o primero salvamento, os dados serão alterados.
     */
    @Override
    public void startGame(){
        ScriptSegmentController scriptSegmentController = new ScriptSegmentController();
        
        Board board = new Board(null, 10000, "default", "0a");
        
        board.setScriptSegments(scriptSegmentController.getScriptSegments());
        
        board.setCurrentScriptSegment(scriptSegmentController.foundScriptSegment(board.getScriptSegments(), board.getSegmentStoppedId()));
        
        currentWord = 0;//provisório
        
        setBoard(board);
    }
    
    /**
     * Avança para o proximo ScriptSegment de acordo com a escolha
     * @param choice Inteiro que define a escolha de qual segmento irá
     */
    @Override
    public void goToNextScriptSegment(int choice){
        ScriptSegmentController scriptSegmentController = new ScriptSegmentController();
        
        board.setCurrentScriptSegment(scriptSegmentController.foundNextScriptSegment(board.getScriptSegments(), board.getCurrentScriptSegment(), choice));
        
        this.currentWord = 0;//vai para a fala inicial do scriptSegment
        
    }

    /**
     * Função que irá passando os textos de fala (organizar as responsabilidades!)
     * @return String com a fala
     */
    @Override
    public String goToNextWord() {
        
        if(clip != null){
            clip.stop();
        }
        
        String AUDIO_URL = getClass().getResource(board.getCurrentScriptSegment().getWordsSongsPath().get(currentWord)).toString();
        clip = new AudioClip(AUDIO_URL);
        
        clip.play();
        
        if (this.currentWord < board.getCurrentScriptSegment().getWords().size()-1){
            this.currentWord++;
            return board.getCurrentScriptSegment().getWords().get(currentWord);
        } else {
            try {
                //goToNextScriptSegment(currentWord);
                //this.currentWord = 0;
                
                //ScriptSegmentConditions.ScriptSegmentTargetingConditions(board.getCurrentScriptSegment());//teste
                
                return board.getCurrentScriptSegment().getWords().get(currentWord);
            } catch (Exception e) {
                System.out.println("Você está inserindo um valor que está fora da lista! "+e);
            }
            return null;
        }
        
    }    
   
}
