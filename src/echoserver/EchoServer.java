package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
  public static final int portnumber = 6013;

  public static void main(String[] args) throws IOException{
    try{
      // Start listening on the specified port
      ServerSocket sock = new ServerSocket(portnumber);

      while (true) {
      Socket client = sock.accept();
      System.out.println("Got a request!");

      // Input and output streams for receiving data from the
      // client and for sending data back to the client
      InputStream input = client.getInputStream();
      OutputStream output = client.getOutputStream();


      int element;
      // While the client is still sending data
      // Send the data back to the client
      while((element = input.read()) != -1) {
        output.write(element);
      }

      // Close the client socket since we're done.
      client.close();
    }
  } catch (IOException ioe) {
    System.out.println("We caught an unexpected exception");
    System.err.println(ioe);
  }
 }
}
