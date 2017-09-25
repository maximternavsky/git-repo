package geekbrains.oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    final String SERVER_ADDR = "localhost";
    final int SERVER_PORT = 1024;
    final String CLIENT_PROMPT = "$ ";
    final String CONNECT_TO_SERVER = "Connection to server established.";
    final String CONNECT_CLOSED = "Connection closed.";
    final String EXIT_COMMAND = "exit";

    Socket socket;
    Scanner scanner;
    PrintWriter writer;
    String message;
    BufferedReader reader;
    String messageServer;

    public static void main(String[] args) {
        new Main();
    }

    Main() {
        scanner = new Scanner(System.in);

        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            System.out.println(CONNECT_TO_SERVER);
            //new Thread(new ServerListener()).start();
            do {
                System.out.print(CLIENT_PROMPT);
                message = scanner.nextLine();
                writer.println(message);
                //messageServer = reader.readLine();
                System.out.println();
                writer.flush();
                message = reader.readLine();
                System.out.println(message);
            } while (!message.equals(EXIT_COMMAND));
            writer.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(CONNECT_CLOSED);
    }


    class ServerListener implements Runnable {
        @Override
        public void run() {
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}