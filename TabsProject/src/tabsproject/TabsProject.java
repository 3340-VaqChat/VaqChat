package tabsproject;

import GUIs.maingui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author Michelle Marie Garcia
 * 
 * This is the main class.
 */
public class TabsProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        maingui hitGUI = new maingui();
        Scene scene = new Scene(hitGUI.getRootNode());
        primaryStage.setMaximized(true);
        primaryStage.setTitle("VaqChat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}