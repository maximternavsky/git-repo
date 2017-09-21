package geekbrains.oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 30; i >= 0; i--) {
            System.out.println(i);

            Thread.sleep(100);
        }

        System.out.println("Бум!");
    }
}