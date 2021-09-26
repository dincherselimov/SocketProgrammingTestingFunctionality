package FindTheString;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class is used for:
 * Client sends a string, the server searches that string in a file,
 * if there is a string which the client asks for returns a response with "yes" or "no"
 */
public class Server2 extends Thread {
    public static void main(String[] args) throws IOException {

        //waiting for a request on port(for example 93)
        ServerSocket socket = new ServerSocket(94);

        while (true) {
            //establish connection
            Socket client = socket.accept();
            System.out.println("Successful");

            //use separate threads
            ClientHandler2 clientThread = new ClientHandler2(client);
            new Thread(clientThread).start();

        }

    }
}


