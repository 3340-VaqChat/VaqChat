/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import javafx.scene.control.TabPane;
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
public class chatstabTest {
	
	public chatstabTest() {
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
	 * Test of getTabPane method, of class chatstab.
	 */
	@Test
	public void testGetTabPane() {
		System.out.println("getTabPane");
		chatstab instance = new chatstab();
		TabPane expResult = null;
		TabPane result = instance.getTabPane();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setTabPane method, of class chatstab.
	 */
	@Test
	public void testSetTabPane() {
		System.out.println("setTabPane");
		TabPane tabPane = null;
		chatstab instance = new chatstab();
		instance.setTabPane(tabPane);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
