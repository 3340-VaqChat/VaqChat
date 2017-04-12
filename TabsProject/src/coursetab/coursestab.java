package coursetab;

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

/**
 *
 * @author Michelle Marie Garcia
 * 
 * This class creates the content within the Courses tab. Within this class, a
 * GUI is created along with the necessary classes needed for the GUI to function.
 */
public class coursestab extends BorderPane {
    ArrayList<Profile> profiles = new ArrayList<>();
    ListView<Profile> coursesView = new ListView<>();
    
    public coursestab() {
        getGui();
    }
    
    public void getGui() {
        this.setPadding(new Insets(20, 10, 10, 10));
        createTop();
        createBottom();
        createLeft();
        createRight();
        createCenter();
    }
    
    public void createTop() {
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
    
    public void createBottom() {
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
                // Delete
            }
        });

        HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.TOP_CENTER);
        buttonHBox.setPadding(new Insets(50, 50, 50, 50));
        buttonHBox.getChildren().addAll(addProfileButton, modifyProfileButton, deleteProfileButton);
        BorderPane.setAlignment(buttonHBox, Pos.TOP_CENTER);

        this.setBottom(buttonHBox);
    }
    
    public void createLeft() {
        GridPane profileEntryGrid = new GridPane();
        profileEntryGrid.setVgap(5);
        profileEntryGrid.setHgap(5);
        profileEntryGrid.setPadding(new Insets(5, 5, 5, 5));
        
        Label courseInfoLabel = new Label("Course Info");
        courseInfoLabel.setStyle("-fx-font-weight: bold;");
        
        Label unameLabel = new Label("Username:");
        TextField unameField = new TextField();
        unameField.setId("uname");
        unameField.setMaxWidth(Double.MAX_VALUE);
        
        Label cidLabel = new Label("Course ID:");
        TextField cidField = new TextField();
        cidField.setId("cid");
        cidField.setMaxWidth(Double.MAX_VALUE);

        Label prefixLabel = new Label("Prefix:");
        TextField prefixField = new TextField();
        prefixField.setId("prefix");
        prefixField.setMaxWidth(Double.MAX_VALUE);

        Label cnumLabel = new Label("Course Number:");
        TextField cnumField = new TextField();
        cnumField.setId("cnum");
        cnumField.setMaxWidth(Double.MAX_VALUE);

        Label sectionLabel = new Label("Section:");
        TextField sectionField = new TextField();
        sectionField.setId("section");
        sectionField.setMaxWidth(Double.MAX_VALUE);

        Label startLabel = new Label("Start Time:");
        TextField startField = new TextField();
        startField.setId("start");
        startField.setMaxWidth(Double.MAX_VALUE);

        Label endLabel = new Label("End Time:");
        TextField endField = new TextField();
        endField.setId("end");
        endField.setMaxWidth(Double.MAX_VALUE);

        Label locationLabel = new Label("Location:");
        TextField locationField = new TextField();
        locationField.setId("location");
        locationField.setMaxWidth(Double.MAX_VALUE);

        Label instLabel = new Label("Instructor:");
        TextField instField = new TextField();
        instField.setId("inst");
        instField.setMaxWidth(Double.MAX_VALUE);

        Label prenumLabel = new Label("Prereq. Number:");
        TextField prenumField = new TextField();
        prenumField.setId("prenum");
        prenumField.setMaxWidth(Double.MAX_VALUE);

        Separator separator2 = new Separator();
        separator2.setMinSize(20, 20);
        separator2.setOrientation(Orientation.VERTICAL);
        
        profileEntryGrid.add(courseInfoLabel, 0, 0);
        profileEntryGrid.add(unameLabel, 0, 1);
        profileEntryGrid.add(unameField, 1, 1);
        profileEntryGrid.add(cidLabel, 0, 2);
        profileEntryGrid.add(cidField, 1, 2);
        profileEntryGrid.add(prefixLabel, 0, 3);
        profileEntryGrid.add(prefixField, 1, 3);
        profileEntryGrid.add(cnumLabel, 0, 4);
        profileEntryGrid.add(cnumField, 1, 4);
        profileEntryGrid.add(sectionLabel, 0, 5);
        profileEntryGrid.add(sectionField, 1, 5);
        profileEntryGrid.add(startLabel, 0, 6);
        profileEntryGrid.add(startField, 1, 6);
        profileEntryGrid.add(endLabel, 0, 7);
        profileEntryGrid.add(endField, 1, 7);
        profileEntryGrid.add(locationLabel, 0, 8);
        profileEntryGrid.add(locationField, 1, 8);
        profileEntryGrid.add(instLabel, 0, 9);
        profileEntryGrid.add(instField, 1, 9);
        profileEntryGrid.add(prenumLabel, 0, 10);
        profileEntryGrid.add(prenumField, 1, 10);
        
        HBox leftHBox = new HBox();
        leftHBox.getChildren().addAll(profileEntryGrid, separator2);
        leftHBox.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(leftHBox, Pos.TOP_CENTER);

        this.setLeft(leftHBox);
    }
    
    public void createRight() {
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
    
    public void createCenter() {
        MenuItem menuItem1 = new MenuItem("Course ID");
        menuItem1.setId("mi1");
        menuItem1.setOnAction(e -> {
            Collections.sort(profiles, new CourseIDComparator());
            coursesView.getItems().clear();
            coursesView.getItems().addAll(profiles);
        });
        MenuItem menuItem2 = new MenuItem("Course Number");
        menuItem2.setId("mi2");
        menuItem2.setOnAction(e -> {
            Collections.sort(profiles, new CourseNumComparator());
            coursesView.getItems().clear();
            coursesView.getItems().addAll(profiles);
        });
        MenuItem menuItem3 = new MenuItem("Section");
        menuItem3.setId("mi3");
        menuItem3.setOnAction(e -> {
            Collections.sort(profiles, new SectionComparator());
            coursesView.getItems().clear();
            coursesView.getItems().addAll(profiles);
        });
        MenuItem menuItem4 = new MenuItem("Instructor");
        menuItem4.setId("mi4");
        menuItem4.setOnAction(e -> {
            Collections.sort(profiles, new InstructorComparator());
            coursesView.getItems().clear();
            coursesView.getItems().addAll(profiles);
        });

        MenuButton dropdown = new MenuButton("Select", null, menuItem1, menuItem2, menuItem3, menuItem4);

        HBox middleHBox = new HBox(10);
        middleHBox.setPadding(new Insets(5, 5, 5, 5));
        middleHBox.setAlignment(Pos.TOP_CENTER);
        middleHBox.getChildren().addAll(new Label("Sort By: "), dropdown);

        this.setCenter(middleHBox);
    }
    
    public ListView<Profile> getListView() {
        return coursesView;
    }
    
    public void getProfile() {
        Profile profile1 = new Profile();
        Scene scene = this.getScene();

        TextField Txuname = (TextField) scene.lookup("#uname");
        TextField Txcid = (TextField) scene.lookup("#cid");
        TextField Txprefix = (TextField) scene.lookup("#prefix");
        TextField Txcnum = (TextField) scene.lookup("#cnum");
        TextField Txsection = (TextField) scene.lookup("#section");
        TextField Txstart = (TextField) scene.lookup("#start");
        TextField Txend = (TextField) scene.lookup("#end");
        TextField Txlocation = (TextField) scene.lookup("#location");
        TextField Txinst = (TextField) scene.lookup("#inst");
        TextField Txprenum = (TextField) scene.lookup("#prenum");

        profile1.setScreenName(Txuname.getText());
        profile1.setCurrentCourses(new Courses(Txcid.getText(), Txprefix.getText(),
                Txcnum.getText(), Txsection.getText(), Txstart.getText(), Txend.getText(),
                Txlocation.getText(), Txinst.getText(), Txprenum.getText()));

        profiles.add(profile1);
//--------------------------------------------------------------------------------
        coursesView.getItems().clear();
        coursesView.getItems().addAll(profiles);

        Txuname.setText("");
        Txcid.setText("");
        Txprefix.setText("");
        Txcnum.setText("");
        Txsection.setText("");
        Txstart.setText("");
        Txend.setText("");
        Txlocation.setText("");
        Txinst.setText("");
        Txprenum.setText("");
    }
    
    class CourseIDComparator implements Comparator<Profile> {

        @Override
        public int compare(Profile pf1, Profile pf2) {
            String fname1 = pf1.getCurrentCourses().getCourseId();
            String fname2 = pf2.getCurrentCourses().getCourseId();
            return fname1.compareTo(fname2);
        }
    }

    /**
     * This class sorts by last name
     */
    class CourseNumComparator implements Comparator<Profile> {

        @Override
        public int compare(Profile pf1, Profile pf2) {
            String lname1 = pf1.getCurrentCourses().getCourseNum();
            String lname2 = pf2.getCurrentCourses().getCourseNum();
            return lname1.compareTo(lname2);
        }
    }

    /**
     * This class sorts by ID
     */
    class SectionComparator implements Comparator<Profile> {

        @Override
        public int compare(Profile pf1, Profile pf2) {
            String id1 = pf1.getCurrentCourses().getSection();
            String id2 = pf2.getCurrentCourses().getSection();
            return id1.compareTo(id2);
        }
    }

    /**
     * This class sorts by Email
     */
    class InstructorComparator implements Comparator<Profile> {

        @Override
        public int compare(Profile pf1, Profile pf2) {
            String email1 = pf1.getCurrentCourses().getInstructor();
            String email2 = pf2.getCurrentCourses().getInstructor();
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
    private String screenName;
    private Courses currentCourses;
    
    @Override
    public String toString() {
        return screenName + "\n" + this.getCurrentCourses().getCourseId() + "\n" 
                + this.getCurrentCourses().getPrefix() + "\n" 
                + this.getCurrentCourses().getCourseNum() + "\n" 
                + this.getCurrentCourses().getSection() + "\n" 
                + this.getCurrentCourses().getStartTime() + "\n" 
                + this.getCurrentCourses().getEndTime() + "\n" 
                + this.getCurrentCourses().getLocation() + "\n" 
                + this.getCurrentCourses().getInstructor() + "\n"
                + this.getCurrentCourses().getPrereq();
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

    /**
     * @return the currentCourses
     */
    public Courses getCurrentCourses() {
        return currentCourses;
    }

    /**
     * @param currentCourses the currentCourses to set
     */
    public void setCurrentCourses(Courses currentCourses) {
        this.currentCourses = currentCourses;
    }
}