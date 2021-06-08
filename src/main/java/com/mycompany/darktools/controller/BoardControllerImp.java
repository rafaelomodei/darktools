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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javafx.scene.media.AudioClip;
import java.util.Observable;

/**
 * Classe controladora da instância Board que será a base de todas as informações do jogador
 * Contém a responsabilidade do manuseio de informações da Instancia Board e a interação com as classes de regra de negócio para a persistencia de dados da classe Board e outras que a compoem.
 * @author acer
 */
public class BoardControllerImp extends Observable implements BoardController {
    BoardBR boardBR;
    PersonageBR personageBR;
    SkillBR skillBR;
    TeamBR teamBR;
    
    Board board;
    
    int currentWord;//fala atual
    
    AudioClip clip;//clipe
    
    static BoardControllerImp uniqueIndex;
    
    private BoardControllerImp(){}
    
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
        
        
        //boardBR = new BoardBR();
        //personageBR = new PersonageBR();
        //skillBR = new SkillBR();
        //teamBR = new TeamBR();
        
        
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
     * @param nameSave Nome do save
     */
    @Override
    public void startGame(String saveName){
        ScriptSegmentController scriptSegmentController = ScriptSegmentController.getInstante();
        
        Board board = new Board(createDefaulTeam(), 10000, saveName, "0a");//mudar para rota "0a"
        
        board.setScriptSegments(scriptSegmentController.getScriptSegments());
        
        board.setCurrentScriptSegment(scriptSegmentController.foundScriptSegment(board.getScriptSegments(), board.getSegmentStoppedId()));
        
        currentWord = 0;
        
        setBoard(board);
    }
    
    /**
     * Função que cria uma time padrão com 3 personages e cada um com uma habilidade unica
     * @return Retorna o time para testes
     */
    private Team createDefaulTeam(){
        Skill skill1 = new Skill("Soco", 20.0f);
        Skill skill2 = new Skill("Tiro", 50.0f);
        Skill skill3 = new Skill("Bola de fogo", 20.0f);
        List<Skill> skillList = new ArrayList<Skill>();
        skillList.add(skill1);
        
        List<Skill> skillList1 = new ArrayList<Skill>();
        skillList1.add(skill2);
        
        List<Skill> skillList2 = new ArrayList<Skill>();
        skillList2.add(skill3);
        
        Personage personage0 = new Personage("Guerreiro", 100, skillList, "/iu/img/victus_self.png", "/iu/character/warrior/guerreiro_back_batlle.png");
        Personage personage1 = new Personage("Arqueiro", 100, skillList1, "/iu/img/arletics_self.png","/iu/character/acher/acher_back_battle.png");
        Personage personage2 = new Personage("Mago", 100, skillList2, "/iu/img/davi_self.png","/iu/character/mage/mago_back_batlle.png");
        
        List<Personage> personages = new ArrayList<Personage>();
        personages.add(personage0);
        personages.add(personage1);
        personages.add(personage2);
        
        Team teamDefault = new Team(personages, 0.0);
        
        return teamDefault;
    }
    
    
    /**
     * Avança para o proximo ScriptSegment de acordo com a escolha
     * @param choice Inteiro que define a escolha de qual segmento irá
     */
    @Override
    public void goToNextScriptSegment(int choice){
        ScriptSegmentController scriptSegmentController = ScriptSegmentController.getInstante();
        
        try {
            board.setCurrentScriptSegment(scriptSegmentController.foundNextScriptSegment(board.getScriptSegments(), board.getCurrentScriptSegment(), choice));
        } catch (Exception e) {
            System.out.println("Erro no goToNextScriptSegment "+e);
        }finally{
            this.currentWord = 0;//vai para a fala inicial do scriptSegment
        
            hideButtons();
            readWord(currentWord);
            comportamentAntecipaded();
        }
        
    }

    /**
     * Função que irá passando os textos de fala
     */
    @Override
    public void goToNextWord() {
        
        if (this.currentWord < board.getCurrentScriptSegment().getWords().size()-1){
            
            this.currentWord++; 
            readWord(currentWord);
            
        } else { 
            
            comportamentsDesignation();
            
        }
    }
    
    /**
     * Função responsável por direcionar os comportamentos da interface de acordo com o que está escrito no "commands" do JSON da 
     */
    private void comportamentAntecipaded(){
        if(board.getCurrentScriptSegment().getCommands().contains("showButtons")){
            showButtons();
            readWord(currentWord);
            
            System.out.println("Responda a pergunta!"); 
        }
    }
    
    /**
     * Função responsável por direcionar os comportamentos da interface de acordo com o que está escrito no "commands" do JSON da história
     */
    private void comportamentsDesignation(){
        
        if(board.getCurrentScriptSegment().getCommands().contains("showButtons")){
            showButtons();
            readWord(currentWord);
            
            System.out.println("Responda a pergunta!"); 
            
        } else if(board.getCurrentScriptSegment().getCommands().contains("RollDiceD6")) {
            System.out.println("Momento do D6!");
            readWord(currentWord);
            
            goToNextScriptSegment(ScriptSegmentConditions.rollDice6());
            
        } else if(board.getCurrentScriptSegment().getCommands().contains("Battle")){
            System.out.println("Momento batalha!");

            updateTeamEnemy();//Fazer mais testes!

            setChanged();
            notifyObservers("battle");

            goToNextScriptSegment(0);
            
        } else if(board.getCurrentScriptSegment().getCommands().contains("RollDiceD20")){
            System.out.println("Rolar dado D20");
            
        }else if(board.getCurrentScriptSegment().getCommands().contains("creditos")){
            setChanged();
            notifyObservers("endGame");
            
        } else if(board.getCurrentScriptSegment().getCommands().contains("changeScenario")){
            goToNextScriptSegment(0);
            
        } else {
            goToNextScriptSegment(0);
        }
    }

    /**
     * Função responsável pro fazer o retorno dos dados de fala para interface
     * @param currentWord Variável que armazena qual a fala sendo falada no momento
     */
    public void readWord(int currentWord){

        System.out.println("Esse scriptSegment e o : "+board.getCurrentScriptSegment().getId());
        
        Hashtable<String, String> my_dict = new Hashtable<String, String>();//uso de map para ajudar na identificação no view
        my_dict.put("word", board.getCurrentScriptSegment().getWords().get(this.currentWord));
        setChanged();
        notifyObservers(my_dict);
        
        my_dict = new Hashtable<String, String>();//uso de map para ajudar na identificação no view
        my_dict.put("title", foundNPC(board.getCurrentScriptSegment().getWhoSpeaks()).getName());
        setChanged();
        notifyObservers(my_dict);
        
        my_dict = new Hashtable<String, String>();//uso de map para ajudar na identificação no view
        my_dict.put("pathimageface", foundNPC(board.getCurrentScriptSegment().getWhoSpeaks()).getPathImageFace());
        
        setChanged();
        notifyObservers(my_dict);
        
        reproduceAudio();

    }
    
    /**
     * Função responsável por interromper se tem algum audio operando e reproduzir o a audio da fala atual
     */
    public void reproduceAudio(){
        if(clip != null){
            clip.stop();
        }
        
        try {
            String AUDIO_URL = getClass().getResource(board.getCurrentScriptSegment().getWordsSongsPath().get(currentWord)).toString();
            clip = new AudioClip(AUDIO_URL);
            clip.play();
        } catch (Exception e) {
            System.out.println("Sem arquivos de audio! " + e);
        }
        
    }
    
    /**
     * Função responsável por envio de aviso para os botões da inteface serem ocultados
     */
    public void hideButtons(){
        setChanged();
        notifyObservers("hideButtons");
    }
    
    /**
     * Função que manda para o view os dados dos botões de resposta
     */
    public void showButtons(){
        Hashtable<String, ArrayList<String>> my_dict = new Hashtable<String, ArrayList<String>>();//uso de map para ajudar na identificação no view
        my_dict.put("showButtons", (ArrayList<String>) board.getCurrentScriptSegment().getShowButton());
        setChanged();
        notifyObservers(my_dict);
    }
   
    /**
     * Função que atualiza o time inimigo que irá batalhar com o jogador
     */
    private void updateTeamEnemy(){
        //List<Personage> enemiesList = JsonTratament.createAllNPCs(JsonTratament.readAllArraysInArchiveJSON("characters.json"));
        
        List<Personage> enemiesList = PersonageController.getInstante().personages;
        
        Team teamEnemy = new Team();
        List<Personage> selectecEnemiesList = new ArrayList<Personage>();
        //Tá pegando o mesmo?
        for(int i = 0; i < getBoard().getCurrentScriptSegment().getEnemies().size(); i++){
            Personage selectedPersonage = null;
            for(int y = 0; y < enemiesList.size(); y++){
                if(getBoard().getCurrentScriptSegment().getEnemies().get(i).equals(enemiesList.get(y).getNPCid())){
                    enemiesList.get(y);
                    selectedPersonage = new Personage(enemiesList.get(y).getNPCid(), enemiesList.get(y).getName(), enemiesList.get(y).getLife(), enemiesList.get(y).getSkills() ,  enemiesList.get(y).getPathImageFace(), enemiesList.get(y).getPathImageBody());
                    selectecEnemiesList.add(selectedPersonage);
                    System.out.println("O time inimigo e composto por "+enemiesList.get(y).getName());
                }
            }
            if(selectedPersonage == null){
                System.out.println("Personagem não econtrado no JSON de NPCs!");
            }
        }

        teamEnemy.setPersonages(selectecEnemiesList);
        board.setTeamEnemy(teamEnemy);
    }
    
    /**
     * Funçào que procura o NPC nos NPCs do jogo (deve ser retirada daqui!)
     * @param id Id do NPC
     * @return Retorna o personagem procurado
     */
    private Personage foundNPC(String id){
        //List<Personage> npcsList = JsonTratament.createAllNPCs(JsonTratament.readAllArraysInArchiveJSON("characters.json"));
        
        List<Personage> npcsList = PersonageController.getInstante().personages;
        
        for(int i = 0; i<npcsList.size(); i++){
            if(npcsList.get(i).getNPCid().equals(id)){
                return npcsList.get(i);
            }
        }
        return null;
    }
}
