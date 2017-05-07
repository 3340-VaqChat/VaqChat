package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This is the class in charge of the Client side portion of the chat.
 * @author Noe
 */
public class ClientSocket extends Application{

	private Socket link = null;
	private InetAddress host = null;
	private int PORT;

	// input and outpur for Socket
	BufferedReader in = null;
	PrintWriter out = null;

	public ClientSocket() {
	}

	public ClientSocket(InetAddress hostxx, int PORT) {
		this.host = host;
		this.PORT = PORT;
		establishSocket(host, PORT);
	}

	public void establishSocket(InetAddress hostxx, int PORT) {
		this.host = hostxx;
		this.PORT = PORT;
		try {
			this.host = InetAddress.getLocalHost();
			link = new Socket(host, PORT);
			in = new BufferedReader(new InputStreamReader(link.getInputStream()));
			out = new PrintWriter(link.getOutputStream(), true);
		} catch (UnknownHostException e) {
			System.out.println("Host ID not found!");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) {
		//make sure you have a connection
		if (link != null && out != null) {
			try {
				//send collected message to server
				out.println(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//Warn user
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Establish a connection first...");
			alert.showAndWait();
		}
	}

	public String receiveMessage() {
		String response = null;
		//make sure you have a connection		
		if (link != null && in != null) {
			try {
				//wait for response from server
				response = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Establish a connectin first...");
			alert.showAndWait();
		}
		return response;
	}

	public void closeConnection() {
		String message = "***CLOSE***";
		if (link != null && in != null) {
			try {
				out.println(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Establish a connectin first...");
			alert.showAndWait();
		}
	}

	/**
	 * @return the link
	 */
	public Socket getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(Socket link) {
		this.link = link;
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        

}

