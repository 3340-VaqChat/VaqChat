/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class DatabaseTest {
	
	public DatabaseTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of establishConnection method, of class Database.
	 */
	@Test
	public void testEstablishConnection() {
		System.out.println("establishConnection");
		String url = "";
		String username = "";
		String password = "";
		Database instance = new Database();
		instance.establishConnection(url, username, password);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of registerUser method, of class Database.
	 */
	@Test
	public void testRegisterUser() {
		System.out.println("registerUser");
		String user = "";
		String passwordUser = "";
		String firstName = "";
		String lastName = "";
		String email = "";
		String ID = "";
		Database instance = new Database();
		instance.registerUser(user, passwordUser, firstName, lastName, email, ID);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addCourses method, of class Database.
	 */
	@Test
	public void testAddCourses() {
		System.out.println("addCourses");
		String courseID = "";
		String prefix = "";
		String courseNumber = "";
		String section = "";
		String start = "";
		String end = "";
		String location = "";
		String instructor = "";
		String prereq = "";
		String studentID = "";
		Database instance = new Database();
		instance.addCourses(courseID, prefix, courseNumber, section, start, end, location, instructor, prereq, studentID);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of displayCourses method, of class Database.
	 */
	@Test
	public void testDisplayCourses() {
		System.out.println("displayCourses");
		String studentID = "";
		Database instance = new Database();
		ArrayList<String> expResult = null;
		ArrayList<String> result = instance.displayCourses(studentID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of displayEmails method, of class Database.
	 */
	@Test
	public void testDisplayEmails() {
		System.out.println("displayEmails");
		Database instance = new Database();
		ArrayList<String> expResult = null;
		ArrayList<String> result = instance.displayEmails();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of loginUser method, of class Database.
	 */
	@Test
	public void testLoginUser() {
		System.out.println("loginUser");
		String usernameProfile = "";
		String passwordProfile = "";
		Database instance = new Database();
		ArrayList<String> expResult = null;
		ArrayList<String> result = instance.loginUser(usernameProfile, passwordProfile);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteCourses method, of class Database.
	 */
	@Test
	public void testDeleteCourses() {
		System.out.println("deleteCourses");
		String courseNumber = "";
		Database instance = new Database();
		instance.deleteCourses(courseNumber);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteProfile method, of class Database.
	 */
	@Test
	public void testDeleteProfile() {
		System.out.println("deleteProfile");
		String id = "";
		Database instance = new Database();
		instance.deleteProfile(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
