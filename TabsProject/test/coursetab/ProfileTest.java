/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursetab;

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
public class ProfileTest {
	
	public ProfileTest() {
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
	 * Test of toString method, of class Profile.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Profile instance = new Profile();
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getScreenName method, of class Profile.
	 */
	@Test
	public void testGetScreenName() {
		System.out.println("getScreenName");
		Profile instance = new Profile();
		String expResult = "";
		String result = instance.getScreenName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setScreenName method, of class Profile.
	 */
	@Test
	public void testSetScreenName() {
		System.out.println("setScreenName");
		String screenName = "";
		Profile instance = new Profile();
		instance.setScreenName(screenName);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCurrentCourses method, of class Profile.
	 */
	@Test
	public void testGetCurrentCourses() {
		System.out.println("getCurrentCourses");
		Profile instance = new Profile();
		Courses expResult = null;
		Courses result = instance.getCurrentCourses();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setCurrentCourses method, of class Profile.
	 */
	@Test
	public void testSetCurrentCourses() {
		System.out.println("setCurrentCourses");
		Courses currentCourses = null;
		Profile instance = new Profile();
		instance.setCurrentCourses(currentCourses);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
