/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursetab;

import javafx.scene.control.ListView;
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
public class coursestabTest {
	
	public coursestabTest() {
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
	 * Test of getGui method, of class coursestab.
	 */
	@Test
	public void testGetGui() {
		System.out.println("getGui");
		coursestab instance = new coursestab();
		instance.getGui();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createTop method, of class coursestab.
	 */
	@Test
	public void testCreateTop() {
		System.out.println("createTop");
		coursestab instance = new coursestab();
		instance.createTop();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createBottom method, of class coursestab.
	 */
	@Test
	public void testCreateBottom() {
		System.out.println("createBottom");
		coursestab instance = new coursestab();
		instance.createBottom();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createLeft method, of class coursestab.
	 */
	@Test
	public void testCreateLeft() {
		System.out.println("createLeft");
		coursestab instance = new coursestab();
		instance.createLeft();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createRight method, of class coursestab.
	 */
	@Test
	public void testCreateRight() {
		System.out.println("createRight");
		coursestab instance = new coursestab();
		instance.createRight();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createCenter method, of class coursestab.
	 */
	@Test
	public void testCreateCenter() {
		System.out.println("createCenter");
		coursestab instance = new coursestab();
		instance.createCenter();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getListView method, of class coursestab.
	 */
	@Test
	public void testGetListView() {
		System.out.println("getListView");
		coursestab instance = new coursestab();
		ListView<Profile> expResult = null;
		ListView<Profile> result = instance.getListView();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCourses method, of class coursestab.
	 */
	@Test
	public void testGetCourses() {
		System.out.println("getCourses");
		coursestab instance = new coursestab();
		instance.getCourses();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteCourse method, of class coursestab.
	 */
	@Test
	public void testDeleteCourse() {
		System.out.println("deleteCourse");
		coursestab instance = new coursestab();
		instance.deleteCourse();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of displayCourses method, of class coursestab.
	 */
	@Test
	public void testDisplayCourses() {
		System.out.println("displayCourses");
		coursestab instance = new coursestab();
		instance.displayCourses();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
