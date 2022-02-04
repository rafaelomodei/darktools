 package com.mycompany.darktools;

import com.mycompany.darktools.controller.PersonageController;
import com.mycompany.darktools.controller.ScriptSegmentController;
import com.mycompany.darktools.controller.ViwerController;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    private final ExecutorService pool = Executors.newFixedThreadPool(1);
    
    @Override
    public void start(Stage stage) throws Exception {
 
        ScriptSegmentController scriptSegmentController = ScriptSegmentController.getInstante();
        
        ViwerController.getStante().start(stage);
    }


    public static void main(String[] args) {
        
        launch(args);
    }

}
