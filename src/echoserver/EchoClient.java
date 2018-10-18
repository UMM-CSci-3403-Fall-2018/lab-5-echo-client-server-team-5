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

      // Input and output streams for the keyboard and
      // sending the input to the server
      InputStream keyboard_input = System.in;
      OutputStream server_output = socket.getOutputStream();

      // Input and output streams for receiving data from the
      // server and writing out to the console 
      InputStream server_input = socket.getInputStream();
      OutputStream keyboard_output = System.out;


      int element;
      // While there is keyboard input, send it to the server
      // and write out to the console what the server sends back
      while ((element = keyboard_input.read()) != -1) {
        server_output.write(element);
        keyboard_output.write(server_input.read());
      }
      // Make sure everything has been sent to System.out
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
