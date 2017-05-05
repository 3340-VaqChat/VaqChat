package network;
import java.io.*;
import java.net.*;

public class TCPEchoServer
{
   private static ServerSocket servSock;
   private static final int PORT = 1234;

   public static void main(String[] args)
   {
      System.out.println("Opening port...\n");
      try
      {
         servSock = new ServerSocket(PORT);      //Step 1.
      }
      catch(IOException e)
      {
         System.out.println("Unable to attach to port!");
         System.exit(1);
      }
      do
      {
         run();
      }while (true);
   }

   private static void run()
   {
      Socket link = null;                        //Step 2.
      try
      {
         link = servSock.accept();               //Step 2.

         BufferedReader in =
              new BufferedReader(
	               new InputStreamReader(
                        link.getInputStream())); //Step 3.
         PrintWriter out = new PrintWriter(
                   link.getOutputStream(),true); //Step 3.

         int numMessages = 0;
         String message = in.readLine();         //Step 4.
         while (!message.equals("***CLOSE***"))
         {
		 if (message.equals("***Register***"))
		 {
			 String name="";
			 String id="";
			 String email="";
			 name  = in.readLine(); 
			 id    = in.readLine(); 
			 email = in.readLine(); 
			 System.out.println("Message received.");
			 System.out.println("Registering--> "+name+"  "+ id+"  "+ email);
			 out.println("Registed --> "+name+"  "+ id+"  "+ email);   			 
		 }
		 else
		 {
			System.out.println("Message received.");
			numMessages++;
			out.println("Message " + numMessages + ": " + message);   			 
		 }
            message = in.readLine();
         }
         out.println(numMessages
					+ " messages received.");	//Step 4.
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		finally
		{
			try
			{
				System.out.println(
								"\n* Closing connection... *");
				link.close();				    //Step 5.
			}
			catch(IOException e)
			{
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}
		}
	}
}
