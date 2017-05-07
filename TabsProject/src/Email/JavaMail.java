/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.io.File;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class will give the values to the email attachment sender like host,
 * port, who the email is coming from and to who it is sent and with what
 * message or attachments
 * @author Carlos
 */
public class JavaMail {

	public void email() {
		
		// SMTP info
		String host = "smtp.gmail.com";
		String port = "465";
		String mailFrom = "vaqchathost@gmail.com"; //host email
		String password = "SoftwareEng";
		EmailTab em = new EmailTab();	
		// message info
		String mailTo = em.recipient;
		
		String subject = "New email with attachments";
		String message = "These are the attachments: ";
		
			
		// attachments
		String[] attachFiles = new String[1];	
		attachFiles[0] = em.finalmyfile;                  


		try {
			EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, mailTo, subject, message,attachFiles);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Email Sent");
			alert.showAndWait();
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}	
		
	
	}
	
	
}

