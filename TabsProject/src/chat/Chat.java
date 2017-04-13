package chat;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andrea M. Galvan 0362124
 */
public class Chat extends Application {

    // Logo Title
    Image img = new Image("logo.png");
    ImageView iv = new ImageView(img);
    GridPane pane = new GridPane();

    // User 1 Picture
    Image User1img = new Image("user1.jpg");
    ImageView User1IV = new ImageView(User1img);

    // User 2 Picture
    Image User2img = new Image("user2.jpg");
    ImageView User2IV = new ImageView(User2img);

    // User 1 Information
    TextField User1Message = new TextField();
    TextArea User1MessagesDisplay = new TextArea();
    ArrayList<String> user1messagesdata = new ArrayList<>();
    Button User1Send = new Button("Send");
    Button User1Exit = new Button("Exit");

    // Future Addition (Change name)
    // Button User1Name = new Button("Change Name");
    // Button User1ImageChange = new Button("Change Picture");
    
    // User 2 Information
    TextField User2Message = new TextField();
    TextArea User2MessagesDisplay = new TextArea();
    ArrayList<String> user2messagesdata = new ArrayList<>();
    Button User2Send = new Button("Send");
    Button User2Exit = new Button("Exit");
    
    // Future Addition (Change name)
    // Button User2Name = new Button("Change Name");
    // Button User2ImageChange = new Button("Change Picture");
    
    @Override
    public void start(Stage primaryStage) {

        // Set Grid 
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Title 
        String Title = "UTRGV Chatroom";
        pane.add(new Label(Title), 4, 0);

        // Logo
        iv.setFitHeight(100);
        iv.setFitWidth(100);
        pane.add(iv, 4, 1);

        // User 1 Side (Left)
        // Avatar
        User1IV.setFitHeight(100);
        User1IV.setFitWidth(100);
        pane.add(User1IV, 0, 2);
        
        // Future Addition (Change name)
        // pane.add(User1Name, 0, 5);

        User1Exit.setTextFill(Color.web("#08324d"));
        User1Send.setTextFill(Color.web("#800000"));

        // Messages
        pane.add(new Label("User 1"), 0, 4);
        pane.add(User1Message, 2, 4);
        pane.add(User1Send, 2, 5);
        pane.add(User1Exit, 2, 6);

        // Show the messages
        User1MessagesDisplay.setPrefColumnCount(20);
        User1MessagesDisplay.setPrefRowCount(20);

        User1MessagesDisplay.setFont(Font.font("Times New Roman",
                FontWeight.MEDIUM, FontPosture.ITALIC, 14));
        User1MessagesDisplay.setStyle("-fx-text-inner-color: DEEPPINK;");
        pane.add(User1MessagesDisplay, 2, 3);

        // User 2 Side (Right)
        // Avatar
        User2IV.setFitHeight(100);
        User2IV.setFitWidth(100);
        pane.add(User2IV, 11, 2);
        
        // Future Addition (Change name)
        //pane.add(User2Name, 7, 5);

        // Messages
        pane.add(new Label("User 2"), 7, 4);
        pane.add(User2Message, 9, 4);
        pane.add(User2Send, 9, 5);
        pane.add(User2Exit, 9, 6);

        User2Exit.setTextFill(Color.web("#08324d"));
        User2Send.setTextFill(Color.web("#800000"));

        // Show the messages
        User2MessagesDisplay.setPrefColumnCount(20);
        User2MessagesDisplay.setPrefRowCount(20);

        User2MessagesDisplay.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.REGULAR, 14));
        User2MessagesDisplay.setStyle("-fx-text-inner-color: blue;");
        pane.add(User2MessagesDisplay, 9, 3);

        User1Send.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String MessagesUser1 = "";
                MessagesUser1
                        = User1Message.getText() + "\n";

                user1messagesdata.add(MessagesUser1);

                System.out.println("Sent Text to User 2!");

                String allMessages1Data = "";
                for (int i = 0; i < user1messagesdata.size(); i++) {
                    allMessages1Data += user1messagesdata.get(i);
                }

                User1MessagesDisplay.setText(allMessages1Data);

                User1Message.clear();
                User1Message.setText(null);
            }
        });

        User2Send.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String MessagesUser2 = "";
                MessagesUser2
                        = User2Message.getText() + "\n";

                user2messagesdata.add(MessagesUser2);

                System.out.println("Sent Text to User 1!");

                String allMessages2Data = "";
                for (int i = 0; i < user2messagesdata.size(); i++) {
                    allMessages2Data += user2messagesdata.get(i);
                }

                User2MessagesDisplay.setText(allMessages2Data);

                User2Message.clear();
                User2Message.setText(null);
            }
        });

        User1Exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Leave Chatroom");
                alert.setContentText("Do you want to leave the chatroom?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {

                    System.out.println("Oh no!");
                    System.out.println("User 1 left chatroom!");
                    
                User1MessagesDisplay.clear();
                User1MessagesDisplay.setText(null);
                //    System.exit(0);
                } else {
                    System.out.println("Yay!");
                    System.out.println("User 1 still in chatroom!");
                }

            }
        });

        User2Exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Leave Chatroom");
                alert.setContentText("Do you want to leave the chatroom?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("Oh no!");
                    System.out.println("User 2 left chatroom!");

                User2MessagesDisplay.clear();
                User2MessagesDisplay.setText(null);
                //    System.exit(0);
                } else {
                    System.out.println("Yay!");
                    System.out.println("User 2 still in chatroom!");
                }

            }
        });

        
        // Future Addition (Change name)
//        User1Name.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//
//            }
//        });
//
//        User2Name.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//
//            }
//        });

        Scene scene = new Scene(pane, 300, 250);

        primaryStage.setTitle("Andrea Galvan's UTRGV Chatroom");
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
