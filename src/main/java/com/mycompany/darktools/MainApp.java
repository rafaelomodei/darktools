 package com.mycompany.darktools;

import com.mycompany.darktools.controller.PersonageController;
import com.mycompany.darktools.controller.ScriptSegmentController;
import com.mycompany.darktools.controller.ViwerController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class MainApp extends Application {
    

    @Override
    public void start(Stage stage) throws Exception {
        
        ViwerController.getStante().start(stage);
        
        //ScriptSegmentController scriptSegmentController = new ScriptSegmentController();
        //PersonageController personagecontroller = new PersonageController();
    }


    public static void main(String[] args) {
        
        launch(args);
    }

}
