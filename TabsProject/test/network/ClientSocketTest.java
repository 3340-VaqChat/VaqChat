/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.net.InetAddress;
import java.net.Socket;
import javafx.stage.Stage;
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
public class ClientSocketTest {
	
	public ClientSocketTest() {
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
	 * Test of establishSocket method, of class ClientSocket.
	 */
	@Test
	public void testEstablishSocket() {
		System.out.println("establishSocket");
		InetAddress hostxx = null;
		int PORT = 0;
		ClientSocket instance = new ClientSocket();
		instance.establishSocket(hostxx, PORT);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of sendMessage method, of class ClientSocket.
	 */
	@Test
	public void testSendMessage() {
		System.out.println("sendMessage");
		String message = "";
		ClientSocket instance = new ClientSocket();
		instance.sendMessage(message);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of receiveMessage method, of class ClientSocket.
	 */
	@Test
	public void testReceiveMessage() {
		System.out.println("receiveMessage");
		ClientSocket instance = new ClientSocket();
		String expResult = "";
		String result = instance.receiveMessage();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of closeConnection method, of class ClientSocket.
	 */
	@Test
	public void testCloseConnection() {
		System.out.println("closeConnection");
		ClientSocket instance = new ClientSocket();
		instance.closeConnection();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLink method, of class ClientSocket.
	 */
	@Test
	public void testGetLink() {
		System.out.println("getLink");
		ClientSocket instance = new ClientSocket();
		Socket expResult = null;
		Socket result = instance.getLink();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setLink method, of class ClientSocket.
	 */
	@Test
	public void testSetLink() {
		System.out.println("setLink");
		Socket link = null;
		ClientSocket instance = new ClientSocket();
		instance.setLink(link);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of start method, of class ClientSocket.
	 */
	@Test
	public void testStart() throws Exception {
		System.out.println("start");
		Stage primaryStage = null;
		ClientSocket instance = new ClientSocket();
		instance.start(primaryStage);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
