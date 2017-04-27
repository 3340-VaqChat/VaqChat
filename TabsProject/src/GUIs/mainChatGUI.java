/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Carlos
 */
public class mainChatGUI extends BorderPane {

    GridPane root = new GridPane();
    TabPane tabsPane = new TabPane();

    Image img = new Image("imgs/utrgv.png");
    Image img2 = new Image("imgs/p1.jpeg");
    Image img3 = new Image("imgs/p2.jpg");

    ImageView iv = new ImageView(img);
    ImageView iv2 = new ImageView(img2);
    ImageView iv3 = new ImageView(img3);

    Line line1 = new Line(0, 0, 0, 300);

    TextField SendMessages = new TextField();
    TextArea MessagesData = new TextArea();

    ArrayList<String> messagedata1 = new ArrayList<>();
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy h:mm a");
    String formattedDate = sdf.format(date);

    /**
     * Default constructor calling method to create GUI
     */
    public mainChatGUI() {
        getGUI();
    }

    public void getGUI() {
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
        Button btsend1 = new Button("Send Message");
        Button btexit1 = new Button("Clear Messages");

        btsend1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fullmessage1 = "";
                fullmessage1 = SendMessages.getText();
                messagedata1.add(fullmessage1);

                String allData = "";
                for (int i = 0; i < messagedata1.size(); i++) {
                    allData += "Person 1: " + messagedata1.get(i) + "\n-Sent: " + formattedDate + "\n\n";
                }
                MessagesData.setText(allData);
                SendMessages.clear();
            }
        });
        
        btexit1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                messagedata1.clear();
                MessagesData.clear();
                SendMessages.clear();
            }
        });

        HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.TOP_CENTER);
        buttonHBox.setPadding(new Insets(50, 50, 50, 50));
        buttonHBox.getChildren().addAll(btsend1, btexit1);
        BorderPane.setAlignment(buttonHBox, Pos.TOP_CENTER);

        this.setBottom(buttonHBox);
    }

    public void createLeft() {
        iv2.setFitHeight(100);//image size
        iv2.setFitWidth(100);
        GridPane profileEntryGrid = new GridPane();
        profileEntryGrid.setVgap(5);
        profileEntryGrid.setHgap(5);
        profileEntryGrid.setPadding(new Insets(5, 5, 5, 5));

        Separator separator2 = new Separator();
        separator2.setMinSize(20, 20);
        separator2.setOrientation(Orientation.VERTICAL);

        Separator separator3 = new Separator();
        separator3.setMinSize(10, 10);
        separator3.setOrientation(Orientation.HORIZONTAL);

        Label owneruser = new Label("   User 1   ");

        // Add classmates/friends here
        VBox leftVBox = new VBox();
        HBox leftHBox = new HBox();
        leftVBox.getChildren().addAll(iv2, owneruser);
        leftHBox.getChildren().addAll(leftVBox, separator2);
        leftVBox.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(leftHBox, Pos.TOP_CENTER);

        this.setLeft(leftHBox);
    }

    public void createRight() {
        iv3.setFitHeight(100);//image size
        iv3.setFitWidth(100);

        // Group/Single user talking to
        Label user = new Label("   User 2   ");

        Separator separator3 = new Separator();
        separator3.setMinSize(20, 20);
        separator3.setOrientation(Orientation.VERTICAL);


        VBox rightVBox = new VBox();
        HBox rightHBox2 = new HBox();
        rightVBox.getChildren().addAll(iv3, user);
        rightHBox2.getChildren().addAll(separator3, rightVBox);
        rightVBox.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(rightHBox2, Pos.TOP_CENTER);

        this.setRight(rightHBox2);
    }

    public void createCenter() {
//        Button btsend1 = new Button("Send Message");
//        Button btexit1 = new Button("Clear Messages");
//
//        btsend1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                String fullmessage1 = "";
//                fullmessage1 = SendMessages.getText();
//                messagedata1.add(fullmessage1);
//
//                String allData = "";
//                for (int i = 0; i < messagedata1.size(); i++) {
//                    allData += "Person 1: " + messagedata1.get(i) + " -Sent: " + formattedDate;
//                }
//                MessagesData.setText(allData);
//                SendMessages.clear();
//            }
//        });

        VBox middleVBox = new VBox(10);
        middleVBox.setPadding(new Insets(5, 5, 5, 5));
        middleVBox.setAlignment(Pos.TOP_CENTER);
        middleVBox.getChildren().addAll(MessagesData, SendMessages);

//        HBox buttonHBox = new HBox();
//        buttonHBox.setAlignment(Pos.TOP_CENTER);
//        buttonHBox.setPadding(new Insets(50, 50, 50, 50));
//        buttonHBox.getChildren().addAll(btsend1, btexit1);
//        BorderPane.setAlignment(buttonHBox, Pos.TOP_CENTER);

        this.setCenter(middleVBox);
    }
}