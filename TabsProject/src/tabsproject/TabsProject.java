package tabsproject;

import GUIs.maingui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        Scene scene = new Scene(new VBox(), 400, 350);
        scene.setFill(Color.OLDLACE);
	
	//Menu Bar
        MenuBar menuBar = new MenuBar();
 
        //File section: needs an exit option to exit the gui/program
        Menu menuFile = new Menu("File");
        //Edit section: ...
        Menu menuEdit = new Menu("Edit");
        //View section: alternate way of traversing gui tabs (probably using a checkmenu to toggle the options)
        Menu menuView = new Menu("View");
	//add the setions to the menu bar
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
 
 
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar,hitGUI.getRootNode());
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