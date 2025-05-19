package server;

import dao.MessageDao;
import dao.UserDao;
import model.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.sql.Timestamp;

public class ServerThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private MessageDao messageDao = new MessageDao();
    private UserDao userDao = new UserDao();
    private List<User> users;

    public ServerThread(Socket socket) throws SQLException, ClassNotFoundException {
        this.users = userDao.findAll();
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
                String messageContent = String.join(" ", Arrays.copyOfRange(messageParsed, 2, messageParsed.length));

                User fromUserObj = this.users.stream().filter(user -> user.getName().equals(fromUser)).findFirst().orElse(null);
                User toUserObj = this.users.stream().filter(user -> user.getName().equals(toUser)).findFirst().orElse(null);

                Timestamp currentTime = new Timestamp(System.currentTimeMillis());

                // save into database
                this.messageDao.save(new model.Message(messageContent, currentTime, fromUserObj.getId(), toUserObj.getId()));
                System.out.println("Message received from client: " + message);


                out.println("Message received from client: " + message);
            }
        }catch(Exception e){
            System.out.println("Error occured in main of server " + e.getStackTrace());
        }
    }

}
