/*
This code is written by SB, 2025
*/

import java.io.*;
import java.net.*;

public class ServerSide {

    public static void main(String args[])throws Exception
  {

      System.out.println("\n---  Hello from Server Code  ---");
try
    {
       // define the serve socket to start listeing on port 1024
       ServerSocket ss=new ServerSocket(1024);
       
       System.out.print("\nKeep listening -- Waiting for client.....");
       
       // find a client -- this line will be excuted after running the client code 
       Socket s=ss.accept();
       System.out.println("\nConnected");

       //  define input streatm to receive data as ( Input ) - from the client socket
       DataInputStream input=new DataInputStream(
                new BufferedInputStream(s.getInputStream()));
       
       
       // get the data received from the client ( the same order sent )
       String ch = input.readUTF();
       String num = input.readUTF();

         
        // define a stream to output the data (result) -- to the client socket 
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        
        int result=0;
        switch(Integer.parseInt(ch))
        {
          case 1:result=Square(Integer.parseInt(num));

                out.writeUTF(Integer.toString(result)); // way 1 

                 /*to write the result into the stream to send it ( as output ) to another socket
                 out.writeUTF(String.valueOf(result)); // way 2   
                 */
                break;
                  
          case 2:result=Cube(Integer.parseInt(num));
                out.writeUTF(String.valueOf(result)); // way 2
                break;
        }

        System.out.println("The answer is sent to the client");
        
        System.out.print(input.readUTF());

        
        // close the both sockets
          ss.close();
          s.close();
    }
catch(Exception ex)
{

}
  }

  public static int Square(int n)
  {
    return n*n;
  }
  
  public static int Cube(int n)
  {
    return n*n*n;
  }
    
}
