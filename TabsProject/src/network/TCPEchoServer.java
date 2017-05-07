package network;

import java.io.*;
import java.net.*;

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
            servSock = new ServerSocket(PORT);      //Step 1.
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
            link = servSock.accept();               //Step 2.

            BufferedReader in = new BufferedReader( new InputStreamReader(link.getInputStream())); //Step 3.
            PrintWriter out = new PrintWriter(link.getOutputStream(), true); //Step 3.

            String message = in.readLine();
            
            while (!message.equals("***CLOSE***")) {
                System.out.println("Message received.");
                out.println("Message: " + message.toUpperCase());     //Step 4.
                message = in.readLine();
            }
            
            out.println("All messages have been received.");	//Step 4.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("\n* Closing connection... *");
                link.close();				    //Step 5.
            } catch (IOException e) {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}