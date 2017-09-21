package geekbrains.oop;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main extends JFrame implements Runnable {

    static private Socket connection;
    static private ObjectOutputStream output;
    static private ObjectInputStream input;

    public static void main(String[] args) {
        // write your code here
    }

    @Override
    public void run() {
        try {
            connection = new Socket(InetAddress.getByName("127.0.0.1"), 5678);
            while (true) {
                output = new ObjectOutputStream(connection.getOutputStream());
                input = new ObjectInputStream(connection.getInputStream());
                JOptionPane.showMessageDialog(null, (String) input.readObject());
                );
            }
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
    }

    private static void SendData(Object obj) throws IOException {
        try {
            output.flush();
            output.writeObject(obj);
        } catch (IOException e) {

        }
    }
}
