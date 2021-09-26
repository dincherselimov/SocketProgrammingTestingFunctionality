//package SearchMultipleStrings;
//
//import java.io.*;
//import java.net.Socket;
//
///**
// * This class is used for:
// * Client class send a string to the server
// * and waits for a response from the server,
// * if that string is part of any file
// * returns "yes"/"no"
// */
//public class Client5 {
//
//    public static void main(String[] args) throws IOException {
//
//        Client5.ClientSide();
//    }
//
//    public static void ClientSide() throws IOException {
//
//        //Connect and establish a socket connection via host and port
//        Socket s = new Socket("localhost", 93);
//
//        //Dava dostip do steama koyto otiva kim servera
//        //Printing the formatted representations of objects to a text-output stream
//        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
//        out.println("Dincher Selimov;SSHKey.txt");
//        out.flush();
//
//        //Ako servera prashta otgovor InputStream gi cete
//        InputStreamReader in = new InputStreamReader(s.getInputStream());
//        BufferedReader bf = new BufferedReader(in);
//
//        // "value1;value2;value3;value4;value5;value6".split(";")
//
//        // Reading the server response
//        String str;
//
//        while ((str=bf.readLine()) != null ){
//            //Printing the server response
//            System.out.println("Server: " + str);
//        }
//        out.close();
//        s.close();
//
//    }
//
//}
