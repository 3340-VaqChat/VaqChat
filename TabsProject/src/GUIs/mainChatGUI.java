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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;

/**
 *
 * @author Carlos
 */
public class mainChatGUI extends BorderPane{
	GridPane root = new GridPane();
	Image img = new Image("utrgv.png");
	Image img2 = new Image("p1.jpeg");
	Image img3 = new Image("p2.jpg");
	ImageView iv = new ImageView(img);
	ImageView iv2 = new ImageView(img2);
	ImageView iv3 = new ImageView(img3);
	Line line1 = new Line(0, 0, 0, 500);
	TextArea insert1 = new TextArea();
	TextArea insert2 = new TextArea();
	TextArea displayArea1 = new TextArea();
	TextArea displayArea2 = new TextArea();
	ArrayList<String> messagedata1 = new ArrayList<>();
	ArrayList<String> messagedata2 = new ArrayList<>();
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy h:mm a");
	String formattedDate = sdf.format(date);
    
   /**
     * Default constructor calling method to create GUI
     */
    public mainChatGUI(){
	getGUI();
    }

 public void getGUI() {
        this.setPadding(new Insets(20, 10, 10, 10));
        createUIcenterPanel();
    }
private void createUIcenterPanel() {
        iv.setFitHeight(100);//image size
        iv.setFitWidth(150);
        iv2.setFitHeight(100);//image size
        iv2.setFitWidth(70);
        iv3.setFitHeight(100);//image size
        iv3.setFitWidth(70);
        root.add(new Label("Person 1"), 0, 20);
        root.add(new Label("Person 2"), 50, 20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        root.setHgap(5.5); //horizontal distance between cells
        root.setVgap(5.5); //vertical distance between cells
        Button btsend1 = new Button("Send Message");
        Button btsend2 = new Button("Send Message");
        Button btexit1 = new Button("Clear Messages");
        Button btexit2 = new Button("Clear Messages");
        insert1.setPromptText("Enter your message...");
        insert2.setPromptText("Enter your message...");
        root.add(iv, 20, 6, 10, 3);
        root.add(iv2, 0, 12, 2, 3);
        root.add(iv3, 50, 12, 2, 3);
        root.add(btsend1, 5, 100, 2, 2);
        root.add(btexit1, 7, 100, 2, 2);
        root.add(btsend2, 30, 100, 2, 2);       
        root.add(btexit2, 32, 100, 2, 2);
        root.add(line1, 27,55,2,2);
        root.add(insert1, 5, 90,6,4);
        root.add(insert2, 30, 90,6,4);
        root.add(displayArea1, 5, 20,6,60);
        root.add(displayArea2, 30, 20, 6, 60);
        
        /**
        *the left side send button will control the left side display text area
        *and it will send the message from the lower text area to the top one
        **/
        btsend1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fullmessage1 = "";
                fullmessage1 = insert1.getText();
                messagedata1.add(fullmessage1);

                String allData = "";
                for (int i = 0; i < messagedata1.size(); i++) {
                    allData += "Carlos Mata: " + messagedata1.get(i) + "\n-Sent: " + formattedDate + "\n\n";
                }
                displayArea2.setText(allData);
                insert1.clear();
            }
        });
        /**
        *the right side send button will control the right side display text area
        *and it will send the message from the lower text area to the top one
        **/
        btsend2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fullmessage2 = "";
                fullmessage2 = insert2.getText();
                messagedata2.add(fullmessage2);

                String allData = "";
                for (int i = 0; i < messagedata2.size(); i++) {
                    allData += "Jessica Doe: " + messagedata2.get(i) + "\n-Sent: " + formattedDate + "\n\n";
                }
                displayArea1.setText(allData);
                insert2.clear();
            }
        });
        
        /**
        *both of the exit buttons will clear their respective display areas of 
        *already displayed messages
        **/
        btexit1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayArea1.clear();
            }
        });
        btexit2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayArea2.clear();
            }
        });

        HBox middleHBox = new HBox(10);
        middleHBox.setPadding(new Insets(5, 5, 5, 5));
        middleHBox.setAlignment(Pos.TOP_CENTER);
        middleHBox.getChildren().addAll(root);
        this.setCenter(middleHBox);
    }


}

