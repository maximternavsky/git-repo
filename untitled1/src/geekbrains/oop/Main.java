package geekbrains.oop;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        int c;

        try (Socket s = new Socket("whois.internic.net", 43)) {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            String str = (args.length == 0 ? "Yandex.ru" : args[0]) + "\n";

            byte bt[] = str.getBytes();

            out.write(bt);

            while((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
