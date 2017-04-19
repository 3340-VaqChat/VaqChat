package profiletab;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
import javafx.stage.FileChooser;

/**
 *
 * @author Michelle Marie Garcia
 * 
 * This class creates the content within the Profile tab. Within this class, a
 * GUI is created along with the necessary classes needed for the GUI to function.
 */
public class profilestab extends BorderPane {
    ArrayList<Profile> profiles = new ArrayList<>();
    ListView<Profile> profilesView = new ListView();

    /**
     * Default constructor calling method to create GUI
     */
    public profilestab() {
        getGUI();
    }

    /**
     * This method creates the BorderPane GUI
     */
    public void getGUI() {
        this.setPadding(new Insets(20, 10, 10, 10));
        createUItopPanel();
        createUIbottomPanel();
        createUIleftPanel();
        createUIrightPanel();
        createUIcenterPanel();
    }

    /**
     * This method creates the topPanel of the BorderPane GUI
     */
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

    /**
     * This method creates the bottom panel
     */
    private void createUIbottomPanel() {
        Button addProfileButton = new Button("Add");
        addProfileButton.setMaxWidth(Double.MAX_VALUE);
        addProfileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getProfile();
            }
        });

        Button modifyProfileButton = new Button("Modify");
        modifyProfileButton.setMaxWidth(Double.MAX_VALUE);
        modifyProfileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Modify
            }
        });

	Button deleteProfileButton = new Button("Delete");
        deleteProfileButton.setMaxWidth(Double.MAX_VALUE);
        deleteProfileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = profiles.size() - 1; i < profiles.size(); i++) {
                    profiles.remove(i);

                    profilesView.getItems().clear();
                    profilesView.getItems().addAll(profiles);
                }
            }
        });

	Button imageProfileButton = new Button("Image");
        imageProfileButton.setMaxWidth(Double.MAX_VALUE);
        imageProfileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser imageFile = new FileChooser();
                imageFile.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("GIF", "*.gif"),
                        new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                        new FileChooser.ExtensionFilter("PNG", "*.png"),
                        new FileChooser.ExtensionFilter("JPEG", "*jpeg"));
                File file = imageFile.showOpenDialog(null);

            }
        });
                
        HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.TOP_CENTER);
        buttonHBox.setPadding(new Insets(50, 50, 50, 50));
        buttonHBox.getChildren().addAll(addProfileButton, modifyProfileButton, deleteProfileButton,imageProfileButton);
        BorderPane.setAlignment(buttonHBox, Pos.TOP_CENTER);

        this.setBottom(buttonHBox);
    }

    /**
     * This method creates the left panel
     */
    private void createUIleftPanel() {
        GridPane profileEntryGrid = new GridPane();
        profileEntryGrid.setVgap(5);
        profileEntryGrid.setHgap(5);
        profileEntryGrid.setPadding(new Insets(5, 5, 5, 5));

        Label studentInfoLabel = new Label("Student Info");
        studentInfoLabel.setStyle("-fx-font-weight: bold;");

        Label unameLabel = new Label("Username:");
        TextField unameField = new TextField();
        unameField.setId("uname0");
        unameField.setMaxWidth(Double.MAX_VALUE);

        Label fnameLabel = new Label("First Name:");
        TextField fnameField = new TextField();
        fnameField.setId("fname");
        fnameField.setMaxWidth(Double.MAX_VALUE);

        Label lnameLabel = new Label("Last Name:");
        TextField lnameField = new TextField();
        lnameField.setId("lname");
        lnameField.setMaxWidth(Double.MAX_VALUE);

        Label idLabel = new Label("Id:");
        TextField idField = new TextField();
        idField.setId("id");
        idField.setMaxWidth(Double.MAX_VALUE);

        Label emailLabel = new Label("Enter Email:");
        TextField emailField = new TextField();
        emailField.setId("mail");
        emailField.setMaxWidth(Double.MAX_VALUE);

        Label urlLabel = new Label("Web URL:");
        TextField urlField = new TextField();
        urlField.setId("url");
        urlField.setMaxWidth(Double.MAX_VALUE);

        Separator separator2 = new Separator();
        separator2.setMinSize(20, 20);
        separator2.setOrientation(Orientation.VERTICAL);

        profileEntryGrid.add(studentInfoLabel, 0, 0);
        profileEntryGrid.add(unameLabel, 0, 1);
        profileEntryGrid.add(unameField, 1, 1);
        profileEntryGrid.add(fnameLabel, 0, 2);
        profileEntryGrid.add(fnameField, 1, 2);
        profileEntryGrid.add(lnameLabel, 0, 3);
        profileEntryGrid.add(lnameField, 1, 3);
        profileEntryGrid.add(idLabel, 0, 4);
        profileEntryGrid.add(idField, 1, 4);
        profileEntryGrid.add(emailLabel, 0, 5);
        profileEntryGrid.add(emailField, 1, 5);
        profileEntryGrid.add(urlLabel, 0, 6);
        profileEntryGrid.add(urlField, 1, 6);

        HBox leftHBox = new HBox();
        leftHBox.getChildren().addAll(profileEntryGrid, separator2);
        leftHBox.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(leftHBox, Pos.TOP_CENTER);

        this.setLeft(leftHBox);
    }

    /**
     * This method creates the right panel
     */
    private void createUIrightPanel() {
        Separator separator3 = new Separator();
        separator3.setMinSize(20, 20);
        separator3.setOrientation(Orientation.VERTICAL);

        HBox rightHBox2 = new HBox();
        rightHBox2.getChildren().addAll(separator3, getListView());

        VBox rightVBox = new VBox();
        rightVBox.setAlignment(Pos.TOP_CENTER);
        rightVBox.getChildren().addAll(rightHBox2);
        BorderPane.setAlignment(rightVBox, Pos.TOP_CENTER);

        this.setRight(rightVBox);
    }

    /**
     * This method creates the center panel
     */
    private void createUIcenterPanel() {
        MenuItem menuItem1 = new MenuItem("First Name");
        menuItem1.setId("mi1");
        menuItem1.setOnAction(e -> {
            Collections.sort(profiles, new FirstNameComparator());
            profilesView.getItems().clear();
            profilesView.getItems().addAll(profiles);
        });
        
        MenuItem menuItem2 = new MenuItem("Last Name");
        menuItem2.setId("mi2");
        menuItem2.setOnAction(e -> {
            Collections.sort(profiles, new LastNameComparator());
            profilesView.getItems().clear();
            profilesView.getItems().addAll(profiles);
        });
        
        MenuItem menuItem3 = new MenuItem("ID");
        menuItem3.setId("mi3");
        menuItem3.setOnAction(e -> {
            Collections.sort(profiles, new IDComparator());
            profilesView.getItems().clear();
            profilesView.getItems().addAll(profiles);
        });
        
        MenuItem menuItem4 = new MenuItem("Email");
        menuItem4.setId("mi4");
        menuItem4.setOnAction(e -> {
            Collections.sort(profiles, new EmailComparator());
            profilesView.getItems().clear();
            profilesView.getItems().addAll(profiles);
        });

        MenuButton dropdown = new MenuButton("Select", null, menuItem1, menuItem2, menuItem3, menuItem4);

        HBox middleHBox = new HBox(10);
        middleHBox.setPadding(new Insets(5, 5, 5, 5));
        middleHBox.setAlignment(Pos.TOP_CENTER);
        middleHBox.getChildren().addAll(new Label("Sort By: "), dropdown);

        this.setCenter(middleHBox);
    }

    /**
     * 
     * @return s the profilesView that holds the profiles inputed by the user
     */
    public ListView<Profile> getListView() {
        return profilesView;
    }

    /**
     * This method retrieves data and sets it to a newly created profile
     */
    public void getProfile() {
        Profile profile1 = new Profile();
        Scene scene = this.getScene();

        TextField Txuname = (TextField) scene.lookup("#uname0");
        TextField Txfname = (TextField) scene.lookup("#fname");
        TextField Txlname = (TextField) scene.lookup("#lname");
        TextField Txid = (TextField) scene.lookup("#id");
        TextField Txmail = (TextField) scene.lookup("#mail");
        TextField Txurl = (TextField) scene.lookup("#url");

        profile1.setPerson(new Person(Txfname.getText(), Txlname.getText(), Txid.getText(),
                Txmail.getText(), Txurl.getText()));
        profile1.setScreenName(Txuname.getText());

        profiles.add(profile1);
//--------------------------------------------------------------------------------
        profilesView.getItems().clear();
        profilesView.getItems().addAll(profiles);

        Txuname.setText("");
        Txfname.setText("");
        Txlname.setText("");
        Txid.setText("");
        Txmail.setText("");
        Txurl.setText("");
    }

    /**
     * This class sorts by first name
     */
    class FirstNameComparator implements Comparator<Profile> {

        @Override
        public int compare(Profile pf1, Profile pf2) {
            String fname1 = pf1.getPerson().getFirstName();
            String fname2 = pf2.getPerson().getFirstName();
            return fname1.compareTo(fname2);
        }
    }

    /**
     * This class sorts by last name
     */
    class LastNameComparator implements Comparator<Profile> {

        @Override
        public int compare(Profile pf1, Profile pf2) {
            String lname1 = pf1.getPerson().getLastName();
            String lname2 = pf2.getPerson().getLastName();
            return lname1.compareTo(lname2);
        }
    }

    /**
     * This class sorts by ID
     */
    class IDComparator implements Comparator<Profile> {

        @Override
        public int compare(Profile pf1, Profile pf2) {
            String id1 = pf1.getPerson().getId();
            String id2 = pf2.getPerson().getId();
            return id1.compareTo(id2);
        }
    }

    /**
     * This class sorts by Email
     */
    class EmailComparator implements Comparator<Profile> {

        @Override
        public int compare(Profile pf1, Profile pf2) {
            String email1 = pf1.getPerson().getEmail();
            String email2 = pf2.getPerson().getEmail();
            return email1.compareTo(email2);
        }
    }
}

/**
 * 
 * @author Michelle Marie Garcia
 * 
 * This class creates Profile objects to hold a complete profile composed of a
 * person's information, their screen name, and their current courses.
 */
class Profile {
    private Person person;
    private String screenName;
    
    @Override
    public String toString() {
        return screenName + "'s Profile:\n" + this.getPerson().getFirstName() + " "
                + this.getPerson().getLastName() + "\n" + this.getPerson().getId() 
                + "\n" + this.getPerson().getEmail() + "\n" + this.getPerson().getWebURL();
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the screenName
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * @param screenName the screenName to set
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}