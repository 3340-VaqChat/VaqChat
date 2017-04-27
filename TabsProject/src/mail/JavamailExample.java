/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;
/**
 *
 * @author MQ0162246
 */
public class JavamailExample {
	/**
	 * @param args the command line arguments
	 */
	/**
	 * Test sending e-mail with attachments
	 */
	public static void main(String[] args) {
		// SMTP info
		String host = "smtp.gmail.com";
		String port = "465";
		String mailFrom = "jodywhitis0407@gmail.com";
		String password = "****";

		// message info
		String mailTo = "jody.whitis01@utrgv.edu";
		String subject = "New email with attachments";
		String message = "Let the sharing begin...";

		// attachments
		String[] attachFiles = new String[2];
		attachFiles[0] = "f1.pdf";
		attachFiles[1] = "f2.pdf";
		//attachFiles[2] = "e:/Test/Video.mp4";

		try {
			EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
				subject, message, attachFiles);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}
}