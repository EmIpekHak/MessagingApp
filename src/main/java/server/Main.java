package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)
        {
            Socket socket = serverSocket.accept();
        }catch (Exception e) {
            System.out.println("Error occured in main of server :" + e.getStackTrace());
        }
    }
}
