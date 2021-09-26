package TCPFileTransfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * This class handles multiple client connection using Threads(which implements class Runnable)
 */
public class ClientHandler extends Thread {

    private final Socket client;
    private BufferedInputStream bis = null;
    private BufferedOutputStream bos = null;

    public ClientHandler(Socket socket) throws IOException {
        this.client = socket;
        bis = new BufferedInputStream(client.getInputStream());
        bos = new BufferedOutputStream(new FileOutputStream("src/TCPFileTransfer/tt22332.txt"));

    }

    /**
     * This method accepts a file sent by the client.java class
     * The method reads the whole content of the file and saves it to a certain directory
     */
    @Override
    public void run() {

        //Create byte array
        byte[] b = new byte[1024 * 8];

        //Read character array
        int len = 0;
        while (true) {
            try {
                assert bis != null;
                if ((len = bis.read(b)) == -1) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert bos != null;

            try {
                bos.write(b, 0, len);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //close resource
        try {
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Upload succeeded");
    }
}
