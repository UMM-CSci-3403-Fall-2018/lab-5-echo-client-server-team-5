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

      PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

      writer.println();

      // Close the client socket since we're done.
      client.close();
    }
  } catch (IOException ioe) {
    System.out.println("We caught an unexpected exception");
    System.err.println(ioe);
  }
 }
}
