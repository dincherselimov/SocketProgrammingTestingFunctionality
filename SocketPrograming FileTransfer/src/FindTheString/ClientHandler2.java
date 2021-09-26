package FindTheString;

import java.io.*;
import java.net.Socket;

public class ClientHandler2 extends Thread {

    private final Socket client;
    String ss;

    /**
     *
     * @param client
     */
    public ClientHandler2(Socket client) {

        this.client = client;
    }


    @Override
    public void run(){
        //Creation of File Descriptor for input file
        File f  = new File("src/TCPFileTransfer/SSHKey.txt");

        //Creation of File Reader object
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Creation of BufferedReader object
        BufferedReader br = new BufferedReader(fr);

        //Initialize the word Array
        String[] words = null;

        //getting info from the other socket(client)
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sending info to the other socket(client)
        PrintWriter out = null;
        try {
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reading the given String from the client and if the string is not read continue reading
        String s = null;
        try {
            s = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while ((s == null)){
            try {
                s = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The given string is: " +  s);

        //Initialize the word to zero
        int count=0;

        //Reading Content from the file
        while(true)
        {
            try {
                if (!((ss=br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Split the word using space
            words=ss.split(" ");
            for (String word : words)
            {
                //Search for the given word
                if (word.equals(s))
                {
                    //If Present increase the count by one
                    count++;
                }
            }
        }

        //Check for count not equal to zero
        if(count!=0)
        {
            out.println("The given word is present for " +count+ " Times in the file");
            out.flush();
        }
        else
        {
            out.println("The given word is not present in the file");
            out.flush();
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
