/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiletab;

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
public class profilestabTest {
	
	public profilestabTest() {
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
	 * Test of getGUI method, of class profilestab.
	 */
	@Test
	public void testGetGUI() {
		System.out.println("getGUI");
		profilestab instance = new profilestab();
		instance.getGUI();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getListView method, of class profilestab.
	 */
	@Test
	public void testGetListView() {
		System.out.println("getListView");
		profilestab instance = new profilestab();
		ListView<Profile> expResult = null;
		ListView<Profile> result = instance.getListView();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProfile method, of class profilestab.
	 */
	@Test
	public void testGetProfile() {
		System.out.println("getProfile");
		profilestab instance = new profilestab();
		instance.getProfile();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of delete method, of class profilestab.
	 */
	@Test
	public void testDelete() {
		System.out.println("delete");
		profilestab instance = new profilestab();
		instance.delete();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
