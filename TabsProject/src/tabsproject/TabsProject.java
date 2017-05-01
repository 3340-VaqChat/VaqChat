package tabsproject;

import GUIs.chatstab;
import GUIs.maingui;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Michelle Marie Garcia
 *
 * This is the main class.
 */
public class TabsProject extends Application {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

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
		openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent args) {
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Files", "*.*");
				fileChooser.getExtensionFilters().add(extFilter);
				File file = fileChooser.showOpenDialog(primaryStage);
				System.out.println(file);
			}
		});
		MenuItem saveMenuItem = new MenuItem("Save");
		MenuItem exitMenuItem = new MenuItem("Exit");
		exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		exitMenuItem.setOnAction(actionEvent -> Platform.exit());

		fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem,
			new SeparatorMenuItem(), exitMenuItem);
		//Edit section...
		Menu editMenu = new Menu("Edit");
		MenuItem copyMenuItem = new MenuItem("Copy");
		editMenu.getItems().add(copyMenuItem);
		MenuItem pasteMenuItem = new MenuItem("Paste");
		editMenu.getItems().add(pasteMenuItem);
		MenuItem selectMenuItem = new MenuItem("Select");
		editMenu.getItems().add(selectMenuItem);
		MenuItem selectallMenuItem = new MenuItem("Select all");
		editMenu.getItems().add(selectallMenuItem);

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
		MenuItem settingsItem1 = new MenuItem("Chat options");
		settingsMenu.getItems().add(settingsItem1);
		MenuItem settingsItem2 = new MenuItem("Tabs options");
		settingsMenu.getItems().add(settingsItem2);
		//Help menu...
		Menu helpMenu = new Menu("Help");

		helpMenu.getItems().addAll(new SeparatorMenuItem());
		//Tutorial menu inside the help menu
		Menu tutorialMenu = new Menu("Tutorial");
		tutorialMenu.getItems().addAll(
			new MenuItem("JavaFX"));

		tutorialMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("http://www.javafxtutorials.com/whatisjavafx/"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});

		helpMenu.getItems().add(tutorialMenu);

		menuBar.getMenus().addAll(fileMenu, editMenu, menuView, settingsMenu, helpMenu);

		((VBox) scene.getRoot()).getChildren().addAll(menuBar, hitGUI.getRootNode());
		primaryStage.setMaximized(true);
		primaryStage.setTitle("VaqChat");
		primaryStage.setScene(scene);
		primaryStage.show();

		Stage myloginDialog = new MyLoginDialog(primaryStage);
		myloginDialog.initModality(Modality.WINDOW_MODAL);
		myloginDialog.initOwner(primaryStage.getScene().getWindow());
		myloginDialog.sizeToScene();
		myloginDialog.show();
	}
}

class MyLoginDialog extends Stage {

	public MyLoginDialog(Stage owner) {
		super();
		initOwner(owner);
		setTitle("Login Window");
		Group root = new Group();
		Scene scene = new Scene(root, 250, 220);
		setScene(scene);

		Label topLabel = new Label(" Login ");
		topLabel.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 40));
		topLabel.setTextFill(Color.CORAL);
		topLabel.setWrapText(true);

		topLabel.setBorder(new Border(new BorderStroke(Color.DARKBLUE, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2))));
		topLabel.setTextAlignment(TextAlignment.CENTER);

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

		BooleanBinding LoginCheck = new BooleanBinding() {
			{
				super.bind(uname.textProperty(),
					pass.textProperty());
			}

			@Override
			protected boolean computeValue() {
				return (uname.getText().isEmpty()
					|| pass.getText().isEmpty());
			}
		};

		Button LoginButton = new Button("Log-in");
		LoginButton.disableProperty().bind(LoginCheck);
		LoginButton.setMaxWidth(Double.MAX_VALUE);
		LoginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				// Alert if Success then close window
				// Alert if Error then stay on the window
			}
		});

		Button CancelButton = new Button("Cancel");
		CancelButton.setMaxWidth(Double.MAX_VALUE);
		CancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Quit program?");

				ButtonType buttonYes = new ButtonType("Yes");
				ButtonType buttonNo = new ButtonType("No");

				alert.getButtonTypes().setAll(buttonYes, buttonNo);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == buttonYes) {
					Platform.exit();
				} else {

				}
			}
		});

		Button MakeAccountButton = new Button("Make New Account");
		MakeAccountButton.setMaxWidth(Double.MAX_VALUE);
		MakeAccountButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage myaccountDialog = new NewAccountDialog(owner);
				myaccountDialog.initModality(Modality.WINDOW_MODAL);
				myaccountDialog.initOwner(owner.getScene().getWindow());
				myaccountDialog.sizeToScene();
				myaccountDialog.show();
			}
		});

		profileEntryGrid.add(topLabel, 1, 1);

		profileEntryGrid.add(username, 0, 2);

		profileEntryGrid.add(uname, 1, 2);

		profileEntryGrid.add(password, 0, 3);

		profileEntryGrid.add(pass, 1, 3);

		profileEntryGrid.add(LoginButton, 0, 5);

		profileEntryGrid.add(CancelButton, 1, 5);

		profileEntryGrid.add(MakeAccountButton, 1, 6);

		root.getChildren().add(profileEntryGrid);
	}
}

class NewAccountDialog extends Stage {

	public NewAccountDialog(Stage owneraccount) {
		super();
		initOwner(owneraccount);
		setTitle("New Account Window");
		Group root = new Group();
		Scene scene = new Scene(root, 410, 320);
		setScene(scene);

		Label topLabel = new Label(" Create Account ");
		topLabel.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 40));
		topLabel.setTextFill(Color.CORAL);
		topLabel.setWrapText(true);

		topLabel.setBorder(new Border(new BorderStroke(Color.DARKBLUE, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2))));
		topLabel.setTextAlignment(TextAlignment.CENTER);

		GridPane profileEntryGrid = new GridPane();
		profileEntryGrid.setVgap(5);
		profileEntryGrid.setHgap(5);
		profileEntryGrid.setPadding(new Insets(5, 5, 5, 5));

		Label firstname = new Label("First Name:");
		TextField fname = new TextField();
		fname.setPromptText("Enter Your First Name here...");

		Label lastname = new Label("Last Name:");
		TextField lname = new TextField();
		lname.setPromptText("Enter Your Last Name here...");

		Label schooladdress = new Label("University's Email:");
		TextField schoolemail = new TextField();
		schoolemail.setPromptText("Enter Your University's Email here...");

		Label idnumber = new Label("University's ID:");
		TextField idnum = new TextField();
		idnum.setPromptText("Enter Your University's ID here...");

		Label username = new Label("Username:");
		TextField uname = new TextField();
		uname.setPromptText("Enter username here...");

		Label password = new Label("Password:");
		TextField pass = new TextField();
		pass.setPromptText("Enter password here...");

		BooleanBinding AccountCheck = new BooleanBinding() {
			{
				super.bind(fname.textProperty(),
					lname.textProperty(),
					schoolemail.textProperty(),
					idnum.textProperty(),
					uname.textProperty(),
					pass.textProperty());
			}

			@Override
			protected boolean computeValue() {
				return (fname.getText().isEmpty()
					|| lname.getText().isEmpty()
					|| schoolemail.getText().isEmpty()
					|| idnum.getText().isEmpty()
					|| uname.getText().isEmpty()
					|| pass.getText().isEmpty());
			}
		};

		Button CreateButton = new Button("Create Account");
		CreateButton.disableProperty().bind(AccountCheck);
		CreateButton.setMaxWidth(Double.MAX_VALUE);
		CreateButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				// Alert if Success then close window
				// Alert if Error then stay on the window
			}
		});

		Button CancelButton = new Button("Cancel");
		CancelButton.setMaxWidth(Double.MAX_VALUE);
		CancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Close Window?");

				ButtonType buttonYes = new ButtonType("Yes");
				ButtonType buttonNo = new ButtonType("No");

				alert.getButtonTypes().setAll(buttonYes, buttonNo);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == buttonYes) {
					close();
				} else {

				}
			}
		});

		profileEntryGrid.add(topLabel, 1, 1);

		profileEntryGrid.add(firstname, 0, 2);
		profileEntryGrid.add(fname, 1, 2);

		profileEntryGrid.add(lastname, 0, 3);
		profileEntryGrid.add(lname, 1, 3);

		profileEntryGrid.add(schooladdress, 0, 4);
		profileEntryGrid.add(schoolemail, 1, 4);

		profileEntryGrid.add(idnumber, 0, 5);
		profileEntryGrid.add(idnum, 1, 5);

		profileEntryGrid.add(username, 0, 6);
		profileEntryGrid.add(uname, 1, 6);

		profileEntryGrid.add(password, 0, 7);
		profileEntryGrid.add(pass, 1, 7);

		profileEntryGrid.add(CreateButton, 0, 8);

		profileEntryGrid.add(CancelButton, 1, 8);

		root.getChildren().add(profileEntryGrid);
	}
}
