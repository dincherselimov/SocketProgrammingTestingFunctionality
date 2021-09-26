package TCPFileTransfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is used for:
 * This class establishes a connection with Client.java class via tcp socket connection
 * This class reads the full length of a  file sent by the client
 * and saves the file to certain directory
 */
public class Server {

    static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {

        //waiting for a request on port(for example 93)
        ServerSocket socket = new ServerSocket(93);

        while (true) {
            //establish connection
            Socket client = socket.accept();
            System.out.println("Successful");

            //use separate threads
            ClientHandler clientThread = new ClientHandler(client);
            new Thread(clientThread).start();

            pool.execute(clientThread);
        }
    }
}