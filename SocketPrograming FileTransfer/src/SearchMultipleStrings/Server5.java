//package SearchMultipleStrings;
//
//import FindTheString.Server2;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * This class is used for:
// * Client sends a string, the server searches that string in a file,
// * if there is a string which the client asks for returns a response with "yes" or "no"
// */
//public class Server5 extends Thread {
//    public static void main(String[] args) throws IOException {
//        Server2.SearchInFile();
//    }
//
//    public static void SearchInFile() throws IOException {
//
//        //Open a socket connection
//        ServerSocket socket = new ServerSocket(93);
//
//        //accept and establish the connection
//        Socket socket1 = socket.accept();
//
//        //Creation of File Descriptor for input file
//        File f1;
//
//        //Initialize the word Array
//        String[] words = null;
//
//
//
//        //getting info from the other socket(client)
//        BufferedReader input = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
//
//        //sending info to the other socket(client)
//        PrintWriter out = new PrintWriter(socket1.getOutputStream(), true);
//
//        //reading the given String from the client and if the string isn't continue reading
//        String s = input.readLine();
//        while ((s == null)){
//            s = input.readLine();
//        }
//        System.out.println(s);
//
//        //Initialize the word to zero
//        int count=0;
//        String[] arguments = s.split(";");
//
//        File f  = new File("src/TCPFileTransfer/" + arguments[1]);
//
//        //Creation of File Reader object
//        FileReader fr = new FileReader(f);
//
//        //Creation of BufferedReader object
//        BufferedReader br = new BufferedReader(fr);
//
//        String ss;
//
//        //Reading Content from the file
//        while((ss=br.readLine()) != null)
//        {
//            //Split the word using space
//            words=ss.split(" ");
//            for (String word : words)
//            {
//                //Search for the given word
//                if (word.equals(arguments[0]))
//                {
//                    //If Present increase the count by one
//                    count++;
//                }
//            }
//        }
//
//        //Check for count not equal to zero
//        if(count!=0)
//        {
//            out.println("The given word is present for " +count+ " Times in the file");
//            out.flush();
//        }
//        else
//        {
//            out.println("The given word is not present in the file");
//            out.flush();
//        }
//
//        fr.close();
//        socket1.close();
//    }
//
//}
//
//
//
