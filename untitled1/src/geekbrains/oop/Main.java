package geekbrains.oop;
import java.net.*;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address[] = InetAddress.getAllByName("www.4pda.ru");
        for (int i = 0; i < address.length; i++) {
            System.out.println(address[i]);
        }

    }
}
