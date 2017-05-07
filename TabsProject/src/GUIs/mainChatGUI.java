/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
import network.TCPEchoServer;

/**
 *This class is the GUI for the "Chat tab" and also contains some parts of the
 * networking.
 * @author Carlos
 * 
 */
public class mainChatGUI extends BorderPane {
    GridPane root = new GridPane();
    TabPane tabsPane = new TabPane();
    Socket link = null;
    BufferedReader in;
    PrintWriter out;
    String message, response;
    private static InetAddress host;
    private static final int PORT = 1234;


    Image img = new Image("imgs/utrgv.png");
    Image img2 = new Image("imgs/p1.jpeg");
    Image img3 = new Image("imgs/p2.jpg");

    ImageView iv = new ImageView(img);
    ImageView iv2 = new ImageView(img2);
    ImageView iv3 = new ImageView(img3);

    Line line1 = new Line(0, 0, 0, 300);

    TextField sendMessageField = new TextField();
    TextArea MessagesArea = new TextArea();

    ArrayList<String> messagedata1 = new ArrayList<>();

    /**
     * Default constructor calling method to create GUI
     */
    public mainChatGUI() {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("Host ID not found!");
            System.exit(1);
        }
        
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
	Button btstart = new Button("Start Client");
        Button btsend1 = new Button("Send Message");
        Button btclear1 = new Button("Clear Messages");

        btstart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                runStart();
            }
        });
        
        btsend1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                runSend();
            }
        });
        
        btclear1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                runClose();
                
                messagedata1.clear();
                MessagesArea.clear();
                sendMessageField.clear();
            }
        });
	
        

        HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.TOP_CENTER);
        buttonHBox.setPadding(new Insets(50, 50, 50, 50));
        buttonHBox.getChildren().addAll(btsend1, btclear1, btstart);
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
        iv3.setFitHeight(100);
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
//        Button btclear1 = new Button("Clear Messages");
//
//        btsend1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                String fullmessage1 = "";
//                fullmessage1 = sendMessageField.getText();
//                messagedata1.add(fullmessage1);
//
//                String allData = "";
//                for (int i = 0; i < messagedata1.size(); i++) {
//                    allData += "Person 1: " + messagedata1.get(i) + " -Sent: " + formattedDate;
//                }
//                MessagesArea.setText(allData);
//                sendMessageField.clear();
//            }
//        });

        VBox middleVBox = new VBox(10);
        middleVBox.setPadding(new Insets(5, 5, 5, 5));
        middleVBox.setAlignment(Pos.TOP_CENTER);
        middleVBox.getChildren().addAll(MessagesArea, sendMessageField);

        this.setCenter(middleVBox);
    }
    
    private void runStart() {					//Step 1.
        try {
            link = new Socket(host, PORT);		//Step 1.
            in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            out = new PrintWriter(link.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runSend() {
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy h:mm a");
            
            message = sendMessageField.getText();
            messagedata1.add(message + " -Sent: " + sdf.format(date));
            out.println(message);
            response = in.readLine();
            messagedata1.add(response);
            
            String allData = "";
            for (int i = 0; i < messagedata1.size(); i++) {
                allData += "Person 1: " + messagedata1.get(i) + "\n";
            }
            
            MessagesArea.clear();
            MessagesArea.setText(allData);
            sendMessageField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void runClose() {
        try {
            message = "***CLOSE***";
            out.println(message); 		//Step 3.
            response = in.readLine();		//Step 3
            messagedata1.add(response);
            link.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//    private void sendToServer() {					//Step 1.
//	try {
//            String fullmessage1 = "";
//            fullmessage1 = sendMessageField.getText();
//
//            if (!(sendMessageField.getText().equalsIgnoreCase("CLOSE"))) {
//                messagedata1.add(fullmessage1);
//                out.println(fullmessage1);
//                response = in.readLine();
//                messagedata1.add(response);
//
//                String allData = "";
//                for (int i = 0; i < messagedata1.size(); i++) {
//                    allData += "Person 1: " + messagedata1.get(i) + " -Sent: " + formattedDate + "\n";
//                }
//
//                MessagesArea.clear();
//                MessagesArea.setText(allData);
//                
//                sendMessageField.clear();
//            } else {
//                out.println("CLOSE");
//            }
//		
//	} catch(IOException e)
//            {
//		e.printStackTrace();
//            }
//    }
//
//    private String receiveFromServer() {					//Step 1.
//        try {
//            response = in.readLine();		//Step 3
//            messagedata1.add(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return response;
//    }
}
