/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class JavaMail extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		
		// SMTP info
		String host = "smtp.gmail.com";
		String port = "465";
		String mailFrom = "vaqchathost@gmail.com"; //host email
		String password = "SoftwareEng";

		// message info
		String mailTo = "carlos.a.mata01@utrgv.edu"; 
		String subject = "New email with attachments";
		String message = "Let the sharing begin...";

		// attachments
		/*String[] attachFiles = new String[2];
		attachFiles[0] = "f1.pdf";
		attachFiles[1] = "f2.pdf";
*/
		try {
			EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
				subject, message, null);//attachFiles);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}
	
}
