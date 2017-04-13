/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Carlos
 */
public class loginTab extends BorderPane{
	
	/**
         * Default constructor calling method to create GUI
         */
	public loginTab() {
        getGUI();
    }
	public void getGUI() {
        this.setPadding(new Insets(20, 10, 10, 10));
        createUItopPanel();
	createUIcenterPanel();
    }
	private void createUItopPanel() {
        Label topLabel = new Label(" VaqChat UTRGV ");
        topLabel.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 40));
        topLabel.setTextFill(Color.CORAL);
        topLabel.setWrapText(true);

        topLabel.setBorder(new Border(new BorderStroke(Color.DARKBLUE, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2))));
        topLabel.setTextAlignment(TextAlignment.CENTER);

        Separator separator = new Separator();
        separator.setMinSize(20, 20);
        separator.setOrientation(Orientation.HORIZONTAL);

        VBox topVB = new VBox();
        topVB.setAlignment(Pos.CENTER);
        topVB.getChildren().addAll(topLabel, separator);
        BorderPane.setAlignment(topVB, Pos.CENTER);

        this.setTop(topVB);
    }

	private void createUIcenterPanel() {
        GridPane profileEntryGrid = new GridPane();
        profileEntryGrid.setVgap(5);
        profileEntryGrid.setHgap(5);
        profileEntryGrid.setPadding(new Insets(5, 5, 5, 5));
	
	Label username = new Label("Username:");
	TextField uname = new TextField();
	uname.setPromptText("Enter username here...");

	Label password = new Label("Password:");
	TextField pass = new TextField();
	pass.setPromptText("Enter password here...");

	Button addProfileButton = new Button("Log-in");
        addProfileButton.setMaxWidth(Double.MAX_VALUE);
        addProfileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //
            }
        });
	
	Button modifyProfileButton = new Button("Exit");
        modifyProfileButton.setMaxWidth(Double.MAX_VALUE);
        modifyProfileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Modify
            }
        });
	profileEntryGrid.add(username, 0, 10);
        profileEntryGrid.add(uname, 1, 10);
	profileEntryGrid.add(password, 0, 11);
        profileEntryGrid.add(pass, 1, 11);
        profileEntryGrid.add(addProfileButton, 0, 12);
        profileEntryGrid.add(modifyProfileButton, 1, 12);	
	HBox middleHBox = new HBox(10);
        middleHBox.setPadding(new Insets(5, 5, 5, 5));
	middleHBox.getChildren().addAll(profileEntryGrid);
        middleHBox.setAlignment(Pos.TOP_CENTER);
        this.setCenter(middleHBox);
    }
	
}
