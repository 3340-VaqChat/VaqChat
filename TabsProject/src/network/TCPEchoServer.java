package network;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the class in charge of the TCP server for the chat.
 * @author Michelle Marie Garcia
 */
public class TCPEchoServer {
    private static ServerSocket servSock;
    private static final int PORT = 1234;

    public static void main(String[] args) {
        System.out.println("Opening port...\n");
        try {
            servSock = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
        do {
            run();
        } while (true);
    }

    private static void run() {
        Socket link = null;
        
        try {
            link = servSock.accept();

            BufferedReader in = new BufferedReader( new InputStreamReader(link.getInputStream()));
            PrintWriter out = new PrintWriter(link.getOutputStream(), true);

            String message = in.readLine();
            
            while (!message.equals("***CLOSE***")) {
                System.out.println("Message received.");
                
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy h:mm a");
                out.println("Person 2: " + message + " -Sent: " + sdf.format(date));
                message = in.readLine();
            }
            
            out.println("All messages have been received.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("\n* Closing connection... *");
                link.close();
            } catch (IOException e) {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}