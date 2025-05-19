package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000))
        {
            while(true)
            {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        }catch (Exception e) {
            System.out.println("Error occured in main of server :" + e.getStackTrace());
        }
    }
}
