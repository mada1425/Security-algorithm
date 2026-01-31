/*
This code is written by SB, 2025
*/


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientSide {

    public static void main(String args[])throws Exception
 {
   
     Scanner in = new Scanner(System.in);

   try
        {
             
             System.out.println("\n---  Hello From Client Code  ---");

             System.out.println("\nWhat do you want from the server to do?"
                     + "\n1.Calculate the square"
                     + "\n2.Calculate the cube"
                     + "\nEnter your choice please:");     
             
             String ch = in.next();

             System.out.print("\nEnter the number:");
             String num = in.next();

             // start making the connection with the server using its details (address and port)
             Socket s=new Socket("localhost",1024);
          
             
             // define a stream to output the data -- to another socket
             DataOutputStream out = new DataOutputStream(s.getOutputStream());
          
             // send the choice and the number to the server by writing it into the output stream
             out.writeUTF(ch);
             out.writeUTF(num);
          

             
             //  define input streatm to receive data as ( Input ) - from another socket
             DataInputStream input2 = new DataInputStream(
                new BufferedInputStream(s.getInputStream()));

             
             // print the result that we get from the server
             System.out.print("The Answer from the server:"+input2.readUTF());
             

             // send a message back to the server through the output stream
             out.writeUTF("A message from client: Thank you");

             
             // close the socket connection 
             s.close();
        }
        catch(Exception ex)
        {

        }
 }


    
}
