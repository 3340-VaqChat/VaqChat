package Email;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import javax.swing.JFileChooser;
import database.Database;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
/**
 *  This is the GUI for the email tab "File exchange"
 * 
 * -this class will take care of the sending of attachments through email 
 * -emails will be gotten dynamically from registered users and displayed in checkboxes
 * -choose a file or multiple files and select which users will receive the files
 * -click send and the emails with the files as attachments will be sent to selected users
 * @author Carlos
 *
 */
public class EmailTab extends BorderPane {
	JavaMail mail=new JavaMail();
	ImageView avatarView;
	ListView<String> list = new ListView<String>();
	public static String recipient;
	public String myfile;
	public static String finalmyfile;
	Database database = new Database();
	ArrayList<String> emailList = database.displayEmails();
	ObservableList<String> items =FXCollections.observableArrayList (database.displayEmails());	

    /**
     * Default constructor calling method to create GUI
     */
    public EmailTab() {
        getGUI();
	
    }

    /**
     * This method creates the BorderPane GUI
     */
    public void getGUI() {
        this.setPadding(new Insets(20, 10, 10, 10));
	createUItopPanel();
        createUIbottomPanel();
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

    /***
     * This is a method for the file image upload.
	 *
     */
    public void attach(){
	    
	    //set the starting directory
	String userDir = System.getProperty("user.home");
	JFileChooser chooser= new JFileChooser(userDir +"/Desktop");
	//set the title
	chooser.setDialogTitle("Set Attachments");
	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	System.out.println("getSelectedFile():" + chooser.getSelectedFile().getAbsolutePath());
	myfile = chooser.getSelectedFile().getAbsolutePath();
	finalmyfile = myfile.replace("\\", "\\\\");  //replace the \ with \\
		System.out.println(finalmyfile); //checking the string that will be going in the attachFiles array
	} 
	else {
		System.out.println("No Selection ");
	}
	
    }
    

	private void createUIcenterPanel() {
		Label label = new Label();
		list = new ListView<>(items);
		list.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						// change the label text value to the newly selected
						// item.
						label.setText("You Selected: " + newValue);
						recipient = newValue;
					}
				});
		
		VBox middleHBox = new VBox(10);
		middleHBox.setPadding(new Insets(5, 5, 5, 5));
		middleHBox.setAlignment(Pos.TOP_CENTER);
		middleHBox.getChildren().addAll(list, label);
		

		this.setCenter(middleHBox);
	}

	/**
	 * This method creates the center panel
	 */
	private void createUIbottomPanel() {

		Button AttachButton = new Button("Attach");
		AttachButton.setMaxWidth(Double.MAX_VALUE);
		AttachButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				attach();
            }
        });
		Button SendButton = new Button("Send");
		SendButton.setMaxWidth(Double.MAX_VALUE);
		SendButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mail.email();
            }
        });
		Button getEm = new Button("Refresh List");		
		getEm.setMaxWidth(Double.MAX_VALUE);
		getEm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				list.setItems(FXCollections.observableArrayList(database.displayEmails()));
				 
            }
        });

	HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.TOP_CENTER);
        buttonHBox.setPadding(new Insets(50, 50, 50, 50));
        buttonHBox.getChildren().addAll(AttachButton, SendButton, getEm);
        BorderPane.setAlignment(buttonHBox, Pos.TOP_CENTER);

        this.setBottom(buttonHBox);
    }
}
