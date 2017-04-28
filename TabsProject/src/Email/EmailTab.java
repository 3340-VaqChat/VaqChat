package Email;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
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
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import profiletab.profilestab;

/**
 *
 * @author Carlos
 * -this class will take care of the sending of attachments through email 
 * -emails will be gotten dynamically from registered users and displayed in checkboxes
 * -choose a file or multiple files and select which users will receive the files
 * -click send and the emails with the files as attachments will be sent to selected users
 */
public class EmailTab extends BorderPane {

    ImageView avatarView;

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
     */
    private void attach(){
        FileChooser fChooser = new FileChooser();
        fChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPEG", "*jpeg"));
        File fileimg = fChooser.showOpenDialog(null);
        try {
            BufferedImage image = ImageIO.read(fileimg);
            Image imgChoosen = SwingFXUtils.toFXImage(image, null);
            avatarView.setImage(imgChoosen);

        } catch (IOException ex) {
            Logger.getLogger(profilestab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
	private void createUIcenterPanel() {

		CheckBox cb1 = new CheckBox("email1");
		cb1.setSelected(true);
		CheckBox cb2 = new CheckBox("email2");
		CheckBox cb3 = new CheckBox("email3");
		CheckBox cb4 = new CheckBox("email4");
		CheckBox cb5 = new CheckBox("email5");
		CheckBox cb6 = new CheckBox("email6");
		CheckBox cb7 = new CheckBox("email7");
		CheckBox cb8 = new CheckBox("email8");
		
		
		VBox middleHBox = new VBox(10);
		middleHBox.setPadding(new Insets(5, 5, 5, 5));
		middleHBox.setAlignment(Pos.TOP_CENTER);
		middleHBox.getChildren().addAll(cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8);

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
				JavaMail mail=new JavaMail();
				mail.start(null);
            }
        });

	HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.TOP_CENTER);
        buttonHBox.setPadding(new Insets(50, 50, 50, 50));
        buttonHBox.getChildren().addAll(AttachButton, SendButton);
        BorderPane.setAlignment(buttonHBox, Pos.TOP_CENTER);

        this.setBottom(buttonHBox);
    }


}
