/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

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
public class EmailAttachmentSenderTest {
	
	public EmailAttachmentSenderTest() {
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
	 * Test of sendEmailWithAttachments method, of class EmailAttachmentSender.
	 */
	@Test
	public void testSendEmailWithAttachments() throws Exception {
		System.out.println("sendEmailWithAttachments");
		String host = "";
		String port = "";
		String userName = "";
		String password = "";
		String toAddress = "";
		String subject = "";
		String message = "";
		String[] attachFiles = null;
		EmailAttachmentSender.sendEmailWithAttachments(host, port, userName, password, toAddress, subject, message, attachFiles);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
