package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ServerThread(Socket socket){
        this.clientSocket = socket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e) {
            System.out.println("Exception in server" + e.getStackTrace());
        }
    }

    @Override
    public void run(){
        try{
            while(true){
                String message = in.readLine();
                System.out.println("Message received from client: " + message);
                out.println("Message received from client: " + message);
            }
        }catch(Exception e){
            System.out.println("Error occured in main of server " + e.getStackTrace());
        }
    }

}
