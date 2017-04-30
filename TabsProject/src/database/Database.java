package database;

import javafx.application.Platform;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jody Whitis
 */
public class Database {

	//after database "vaqchat" is created, make the connection
	
	private Connection myconnection = null;
	private String url = "jdbc:mysql://localhost:3306/vaqchat";
	private String username = "root";
	private String password = "";
	

	public Database() {
	}

	public Database(String url, String username,String password) {
		this.url = url;
		this.username = username;
		establishConnection(url, username, password);
	}

	public void establishConnection(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;

		if (myconnection == null) {
			try {
				myconnection = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				System.out.println("Database Connection Error: stack-> " + e.getMessage());
				Platform.exit();
			}
		}
	}

    

	
	
    }
