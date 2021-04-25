package com.mycompany.darktools;

import com.mycompany.darktools.controller.BoardController;
import com.mycompany.darktools.controller.BoardControllerImp;
import com.mycompany.darktools.model.br.SkillBR;
import com.mycompany.darktools.model.vo.Board;
import com.mycompany.darktools.model.vo.Personage;
import com.mycompany.darktools.model.vo.ScriptSegment;
import com.mycompany.darktools.model.vo.Skill;
import com.mycompany.darktools.model.vo.Team;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.mycompany.darktools.utils.JsonTratament;
import static com.mycompany.darktools.utils.JsonTratament.readAllArraysInArchiveJSON;
import static com.mycompany.darktools.utils.JsonTratament.readScriptSegments;
import org.json.simple.JSONObject;


public class MainApp extends Application {
    List<ScriptSegment> scriptSegments;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        
        //JsonTratament.readAllArraysInArchiveJSON()
        
        scriptSegments = readScriptSegments(readAllArraysInArchiveJSON());
        
        for(ScriptSegment ss: scriptSegments){
            System.out.println("Id :"+ss.getId());
        }
        
         
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
