package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class is in charge of the database portion of the project and connects
 * to the database to retrieve or input information.
 *
 * @author Jody Whitis
 */
public class Database {
    // after database "vaqchat" with table "profiles" is created, make the connection
    private Connection myconnection = null;
    private String url = "jdbc:mysql://localhost:3306/vaqchat?autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "password";
    ArrayList Userinfo = new ArrayList<String>();
    
    public Database() {
    }

    /**
     * Method to set database url, user, and password to make the connection
     *
     * @param url
     * @param username
     * @param password
     */
    public void establishConnection(String url, String username, String password) {
        if (myconnection == null) {
            try {
                myconnection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to database.");
            } catch (Exception e) {
                System.out.println("Database Connection Error: stack-> " + e.getMessage());
            }
        }
    }

    /**
     * Method for register new users to the database
     *
     * @param user
     * @param passwordUser
     * @param firstName
     * @param lastName
     * @param email
     * @param ID
     */
    public void registerUser(String user, String passwordUser, String firstName, String lastName, String email, String ID) {
        establishConnection(url, username, password);
        String SQLString = "";
        Statement mystatment = null;
        ResultSet myRS = null;

        try {
            mystatment = myconnection.createStatement();
            SQLString = "INSERT INTO vaqchat.profiles (username,passwords,firstName,lastName,email,id) VALUES"
                    + "(\'" + user + "\'," + "\'" + passwordUser + "\'," + "\'" + firstName + "\',"
                    + "\'" + lastName + "\',"
                    + "\'" + email + "\',"
                    /*+ "\'" + webUrl + "\'"*/
                    + "\'" + ID + "\'"
                    + ");";

            mystatment.executeLargeUpdate(SQLString);
            System.out.println("NEW USER " + myRS.getString("user") + " CREATED");

            while (myRS.next()) {
                System.out.println("Your name: " + myRS.getString("firstName") + " " + myRS.getString("lastName") + "\nYour email: " + myRS.getString("email"));
                System.out.println("first name is:         " + myRS.getString("firstName"));
                System.out.println("last name is:         " + myRS.getString("lastName"));
            }
        } catch (Exception e) {
            System.out.println("Unable to register new user.");
        }
    }

    /**
     * Method for adding courses only with correct studentID is entered
     *
     * @param courseID
     * @param prefix
     * @param courseNumber
     * @param section
     * @param start
     * @param end
     * @param location
     * @param instructor
     * @param prereq
     * @param studentID
     */
    public void addCourses(String courseID, String prefix, String courseNumber, String section, String start, String end, String location, String instructor, String prereq, String studentID) {
        establishConnection(url, username, password);
        String SQLString = "";
        Statement mystatment = null;
        ResultSet myRS = null;

        try {
            mystatment = myconnection.createStatement();
            SQLString = "INSERT INTO vaqchat.courses (id,prefix,number,section,start,end,location,instructor,prereq,profileid) VALUES"
                    + "(\'" + courseID + "\'," + "\'" + prefix + "\'," + "\'" + courseNumber + "\',"
                    + "\'" + section + "\',"
                    + "\'" + start + "\',"
                    + "\'" + end + "\',"
                    + "\'" + location + "\',"
                    + "\'" + instructor + "\',"
                    + "\'" + prereq + "\',"
                    + "\'" + studentID + "\'"
                    + ");";

            mystatment.executeLargeUpdate(SQLString);
            System.out.println("NEW Courses for studentID: " + myRS.getString("profileid") + " ADDED");

            if (myRS.isBeforeFirst()) {
                //currentUser = new User();
            }
            while (myRS.next()) {
                System.out.println("Your Course: " + myRS.getString("prefix") + " " + myRS.getString("number"));
            }
        } catch (Exception e) {
            System.out.println("Unable to add courses.");
        }

    }

    /**
     * Method to take studentID and return courses with matching studentID as an
     * arraylist
     *
     * @param studentID
     * @return courseList
     */
    public ArrayList<String> displayCourses(String studentID) {

        ArrayList courseList = new ArrayList<String>();
        establishConnection(url, username, password);

        String SQLString = "";

        Statement mystatment = null;
        ResultSet myRS = null;

        try {
            mystatment = myconnection.createStatement();
            SQLString = "SELECT profiles.id,profiles.firstName,profiles.lastName,courses.prefix,courses.id FROM vaqchat.courses INNER JOIN vaqchat.profiles ON profiles.id=courses.profileid WHERE profiles.id LIKE" + "\'" + studentID + "\';";
            myRS = mystatment.executeQuery(SQLString);

            if (myRS.isBeforeFirst()) {
                //currentUser = new User();
            }
            while (myRS.next()) {
                String addCourses = myRS.getString("prefix");
                courseList.add(addCourses);

                //System.out.println("id is:       " + myRS.getInt("iduser"));
                System.out.println(myRS.getString("profiles.firstName") + " " + myRS.getString("profiles.lastName") + "'s courses: "
                        + myRS.getString("courses.prefix") + " - " + myRS.getString("courses.id"));
            }
        } catch (Exception e) {

            System.out.println("stack:" + e.getMessage());
        }

        System.out.println("\nARRAY OF COURSES: " + courseList);

        return courseList;

    }

    /**
     * Method to return the list of all emails registered in the database
     *
     * @return emailList
     */
    public ArrayList<String> displayEmails() {

        ArrayList emailList = new ArrayList<String>();
        establishConnection(url, username, password);

        String SQLString = "";

        Statement mystatment = null;
        ResultSet myRS = null;

        try {
            mystatment = myconnection.createStatement();
            SQLString = "SELECT firstName,lastName,email FROM vaqchat.profiles";
            myRS = mystatment.executeQuery(SQLString);

            if (myRS.isBeforeFirst()) {
                //currentUser = new User();
            }
            while (myRS.next()) {
                String addEmail = myRS.getString("email");
                emailList.add(addEmail);
                //System.out.println("id is:       " + myRS.getInt("iduser"));
                //	System.out.println(myRS.getString("firstName") + " " + myRS.getString("lastName") + "'s email: " + myRS.getString("email"));
            }
        } catch (Exception e) {

            //System.out.println("stack:" + e.getMessage());
        }

        //System.out.println("\nARRAY OF EMAIL: " + emailList);
        //String res = String.join(", ", emailList);
        //System.out.println(res);
        return emailList;

    }

    /**
     * Method to match login and password, then return profile information in
     * arrayList
     *
     * @param usernameProfile
     * @param passwordProfile
     * @return profileList
     */
    public ArrayList<String> loginUser(String usernameProfile, String passwordProfile) {

        ArrayList profileList = new ArrayList<String>();
        establishConnection(url, username, password);

        String SQLString = "";

        Statement mystatment = null;
        ResultSet myRS = null;

        try {
            mystatment = myconnection.createStatement();
            SQLString = "SELECT * FROM vaqchat.profiles WHERE username LIKE " + "\'" + usernameProfile + "\' AND passwords LIKE " + "\'" + passwordProfile + "\'";
            myRS = mystatment.executeQuery(SQLString);

            if (myRS.isBeforeFirst()) {
                //currentUser = new User();
            }
            while (myRS.next()) {
                String addProfileinfo = myRS.getString("username");
                String addProfilename = myRS.getString("firstName");
                String addProfilelastname = myRS.getString("lastName");
                String addProfileemail = myRS.getString("email");

                profileList.add(addProfileinfo);
                profileList.add(addProfilename);
                profileList.add(addProfilelastname);
                profileList.add(addProfileemail);

                //System.out.println("id is:       " + myRS.getInt("iduser"));
                System.out.println("Welcome");
                System.out.println(myRS.getString("firstName") + " " + myRS.getString("lastName") + "'s username: " + myRS.getString("username"));
            }
        } catch (Exception e) {

            System.out.println("stack:" + e.getMessage());
        }

        System.out.println("\nARRAY OF Profile infomation" + profileList);
        String res = String.join(", ", profileList);
        System.out.println(res);

        return profileList;
    }

    /**
     * Method with course number as parameter and delete it from database
     *
     * @param courseNumber
     */
    public void deleteCourses(String courseNumber) {

        ArrayList profileList = new ArrayList<String>();
        establishConnection(url, username, password);

        String SQLString = "";

        Statement mystatment = null;
        ResultSet myRS = null;

        try {
            mystatment = myconnection.createStatement();
            SQLString = "DELETE FROM vaqchat.courses WHERE number LIKE "
                    + "\'" + courseNumber + "\'";
            myRS = mystatment.executeQuery(SQLString);

            if (myRS.isBeforeFirst()) {
                //currentUser = new User();
            }
            while (myRS.next()) {

                //System.out.println("id is:       " + myRS.getInt("iduser"));
                System.out.println("COURSE DELETE");
            }
        } catch (Exception e) {

            System.out.println("stack:" + e.getMessage());
        }

        String res = String.join(", ", profileList);
        System.out.println(res);

    }

    public void deleteProfile(String id) {

        ArrayList profileList = new ArrayList<String>();
        establishConnection(url, username, password);

        String SQLString = "";

        Statement mystatment = null;
        ResultSet myRS = null;

        try {
            mystatment = myconnection.createStatement();
            SQLString = "DELETE FROM vaqchat.profiles WHERE profileid LIKE " + "\'" + id + "\'";
            myRS = mystatment.executeQuery(SQLString);

            if (myRS.isBeforeFirst()) {
                //currentUser = new User();
            }
            while (myRS.next()) {

                //System.out.println("id is:       " + myRS.getInt("iduser"));
                System.out.println("PROFILE DELETE");
            }
        } catch (Exception e) {

            System.out.println("stack:" + e.getMessage());
        }

        String res = String.join(", ", profileList);
        System.out.println(res);
    }
}