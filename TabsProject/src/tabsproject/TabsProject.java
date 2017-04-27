package tabsproject;

import GUIs.chatstab;
import GUIs.maingui;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
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
 
        // File menu - new, save, exit
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
        //Edit section...
        Menu editMenu = new Menu("Edit");
        CheckMenuItem editMenuItem1 = new CheckMenuItem("Copy");
        editMenu.getItems().add(editMenuItem1);
        CheckMenuItem editMenuItem2 = new CheckMenuItem("Paste");
        editMenu.getItems().add(editMenuItem2);
        CheckMenuItem editMenuItem3 = new CheckMenuItem("Select");
        editMenu.getItems().add(editMenuItem3);
        CheckMenuItem editMenuItem4 = new CheckMenuItem("Select all");
        editMenu.getItems().add(editMenuItem4);
	
	//View menu...
	Menu menuView = new Menu("View");
	    chatstab pane = new chatstab();
	    
	    ToggleGroup tGroup = new ToggleGroup();
	    RadioMenuItem mode1 = new RadioMenuItem("Login");
	    mode1.setToggleGroup(tGroup);
	    mode1.setSelected(true);	 
	    mode1.setOnAction(new EventHandler<ActionEvent>() {
	    public void handle(ActionEvent e) {              
		
            }
        });
	    RadioMenuItem mode2 = new RadioMenuItem("Chat");
	    mode2.setToggleGroup(tGroup);
	    mode2.setOnAction(new EventHandler<ActionEvent>() {
	    public void handle(ActionEvent e) {              

	    }
        });
	    RadioMenuItem mode3 = new RadioMenuItem("Profiles");
	    mode3.setToggleGroup(tGroup);
	    mode3.setOnAction(new EventHandler<ActionEvent>() {
	    public void handle(ActionEvent e) {              
		
            }
        });
	    RadioMenuItem mode4 = new RadioMenuItem("Courses");
	    mode4.setToggleGroup(tGroup);
	    mode4.setOnAction(new EventHandler<ActionEvent>() {
	    public void handle(ActionEvent e) {              
		//pane.tabPane.getSelectionModel().selectFirst();
            }
        });
	    RadioMenuItem mode5 = new RadioMenuItem("About");
	    mode5.setToggleGroup(tGroup);
	    mode5.setOnAction(new EventHandler<ActionEvent>() {
	    public void handle(ActionEvent e) {              
		
            }
        });	    
	    menuView.getItems().addAll(mode1, mode2, mode3, mode4, mode5);
	    
        //Settings menu...
        Menu settingsMenu = new Menu("Settings");
        RadioMenuItem settingsItem1 = new RadioMenuItem("Chat options");
        settingsMenu.getItems().add(settingsItem1);
        RadioMenuItem settingsItem2 = new RadioMenuItem("Tabs options");
        settingsMenu.getItems().add(settingsItem2);
        //Help menu...
        Menu helpMenu = new Menu("Help");

        helpMenu.getItems().addAll(new SeparatorMenuItem());
        //Tutorial menu inside the help menu
        Menu tutorialMenu = new Menu("Tutorial");
        tutorialMenu.getItems().addAll(
        new CheckMenuItem("JavaFX"),
        new CheckMenuItem("About..."));

        helpMenu.getItems().add(tutorialMenu);

        menuBar.getMenus().addAll(fileMenu, editMenu, menuView, settingsMenu, helpMenu);
 
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