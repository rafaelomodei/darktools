 package com.mycompany.darktools;

import com.mycompany.darktools.controller.PersonageController;
import com.mycompany.darktools.controller.ScriptSegmentController;
import com.mycompany.darktools.controller.ViwerController;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
 
        ViwerController.getStante().start(stage);
        
        PersonageController personagecontroller = PersonageController.getInstante();
        
    }


    public static void main(String[] args) {
        
        launch(args);
    }

}
