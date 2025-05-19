package server;

import dao.MessageDao;
import dao.UserDao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

public class ServerThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private MessageDao messageDao = new MessageDao();
    private UserDao userDao = new UserDao();

    public ServerThread(Socket socket) throws SQLException, ClassNotFoundException {
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
                String[] messageParsed = message.split(" ");
                String fromUser = messageParsed[0];
                String toUser = messageParsed[1];
                String messageContent = messageParsed[2];



                this.messageDao.save(new model.Message(0,message,null));
                System.out.println("Message received from client: " + message);
                out.println("Message received from client: " + message);
            }
        }catch(Exception e){
            System.out.println("Error occured in main of server " + e.getStackTrace());
        }
    }

}
