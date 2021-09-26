package TCPFileTransfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * This class is used for:
 * This class establishes a connection with Server.java class via tcp socket connection
 * This class sends a file with it's content to the server
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.SendFileToServer();
    }

    /**
     * This method send file to the Server.java class
     * and Server.java class should accept the file and save it to a directory
     */
    public void SendFileToServer() throws IOException {

        Socket socket = new Socket("localhost", 93);

        //Create input stream
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/TCPFileTransfer/SSHKey.txt"));

        //Create Output stream
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        try {
            //Write data
            byte[] b = new byte[1024 * 8];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
                bos.flush();
            }
            System.out.println("File uploaded");

            //close resource
            bos.close();
            socket.close();
            bis.close();
            System.out.println("File upload completed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}