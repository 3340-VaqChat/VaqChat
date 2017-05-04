package database;

import javafx.application.Platform;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jody Whitis
 */
public class Database {

	/*
	after database "vaqchat" with 
	table "profiles" is created, make the connection
	 */
	private Connection myconnection = null;
	private String url = "jdbc:mysql://localhost:3306/vaqchat";
	private String username = "root";
	private String password = "";

	public Database() {
	}

	
	/***
	 * Connecting to the database
	 * @param url
	 * @param username
	 * @param password 
	 */
	public Database(String url, String username, String password) {
		this.url = url;
		this.username = username;
		establishConnection(url, username, password);
	}

	
	/***
	 * Method to set database url, user, and password to make the connection
	 * @param url
	 * @param username
	 * @param password 
	 */
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

	/***
	 * Method to register users to database with input from profileTab
	 * @param user
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param webUrl
	 * @param ID 
	 */
	public void registerUser(String user, String password, String firstName, String lastName, String email, String webUrl, String ID) {

		String SQLString = "";

		Statement mystatment = null;
		ResultSet myRS = null;

		try {
			mystatment = myconnection.createStatement();
			SQLString = "INSERT INTO vaqchat.profiles (username,passwords,firstName,lastName,email,weburl,id) VALUES"
				+ "(\'" + user + "\'," + "\'" + password + "\'," + "\'" + firstName + "\',"
				+ "\'" + lastName + "\',"
				+ "\'" + email + "\',"
				+ "\'" + webUrl + "\',"
				+ "\'" + ID + "\'"
				+ ");";

			mystatment.executeLargeUpdate(SQLString);

			if (myRS.isBeforeFirst()) {
				//currentUser = new User();
			}
			while (myRS.next()) {
				//System.out.println("id is:       " + myRS.getInt("iduser"));
				System.out.println("Your name: " + myRS.getString("firstName") + " " + myRS.getString("lastName") + "\nYour email: " + myRS.getString("email"));

				System.out.println("first name is:         " + myRS.getString("firstName"));
				System.out.println("last name is:         " + myRS.getString("lastName"));
			}
		} catch (Exception e) {
			System.out.println("stack:" + e.getMessage());
		}

	}

}
