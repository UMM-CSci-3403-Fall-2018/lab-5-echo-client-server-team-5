package echoserver;

import java.net.*;
import java.io.*;


public class EchoClient {

  public static final int portNumber = 6013;

  public static void main(String[] args) throws IOException {
    String server;
    // Use "127.0.0.1", i.e., localhost, if no server is specified.
    if (args.length == 0) {
      server = "127.0.0.1";
    } else {
      server = args[0];
    }

    try {
      // Connect to the server
      Socket socket = new Socket(server, portNumber);

      // Get the input stream so we can read from that socket
      InputStream keyboard_input = System.in;
      OutputStream server_output = socket.getOutputStream();

      InputStream server_input = socket.getInputStream();
      OutputStream keyboard_output = System.out;

      int element;
      // Print all the input we receive from the server
      while ((element = keyboard_input.read()) != -1) {
        server_output.write(element);
        keyboard_output.write(server_input.read());
      }
      keyboard_output.flush();
      // Close the socket when we're done reading from it
      socket.close();

} catch (ConnectException ce) {
     System.out.println("We were unable to connect to " + server);
     System.out.println("You should make sure the server is running.");
   } catch (IOException ioe) {
     System.out.println("We caught an unexpected exception");
     System.err.println(ioe);
   }
 }
 }
