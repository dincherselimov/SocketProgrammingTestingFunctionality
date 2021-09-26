package FindTheString;

import java.io.*;
import java.net.Socket;

/**
 * This class is used for:
 * Client class send a string to the server
 * and waits for a response from the server,
 * if that string is part of any file
 * returns "yes"/"no"
 */
public class Client2{

    public static void main(String[] args) throws IOException {

        Client2 client2 = new Client2();
        client2.ClientSide();
    }

    /**
     * This method send a string to be searched in a file
     * and gets response from the server side
     */
    public void ClientSide() throws IOException {

        //Connect and establish a socket connection via host and port
        Socket s = new Socket("localhost", 94);

        //Gives access to the stream going to the server
        //Printing the formatted representations of objects to a text-output stream
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("asdasdasd");
        out.flush();

        //If the server sends response- read the response
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        //Reading the server response
        String str;
        while ((str=bf.readLine()) != null ){
            //Printing the server response
            System.out.println("Server: " + str);
        }
        out.close();
        s.close();
    }
}
