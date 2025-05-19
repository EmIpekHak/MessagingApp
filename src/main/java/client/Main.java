package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner = new Scanner(System.in);
            String userInput;
            String response;
            String clientName="empty";
            String recipient;
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();

            System.out.println("Please enter your name");
            userInput = scanner.nextLine();
            clientName = userInput;

            System.out.println("Please enter the name of the recipient");
            userInput = scanner.nextLine();
            recipient = userInput;

            do{

                System.out.println("Please enter your message:");
                userInput = scanner.nextLine();

                if(userInput.equals("exit")){
                    break;
                }

                String message = ("("+ clientName + "->" + recipient +") " +" message: " + userInput);
                System.out.println(message);

                // send message to server
                output.println(clientName + " " + recipient + " " +message);
            }
            while(true);

        } catch (Exception e) {
            System.out.println("Exception in cleint main" + e.getStackTrace());
        }
    }
}
