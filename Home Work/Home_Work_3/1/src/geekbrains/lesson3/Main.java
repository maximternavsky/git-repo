package geekbrains.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        int numb = 0;
        boolean n;

        while (true){
            n = false;
            x = (int)(Math.random() * 10);
            System.out.println("Введите число от 0 до 9. / 3 попытки осталось.");
            for (int i = 0; i < 3; i++) {
                numb = Integer.parseInt(reader.readLine());
                if(numb == x){
                    n = true;
                    break;
                } else if((numb < x) && (i < 2)){
                    System.out.println("Загаданное число больше. / " + (2 - i) + " попытки(ка) осталось.");
                } else if((numb > x) && (i < 2)){
                    System.out.println("Загаданное число меньше. / " + (2 - i) + " попытки(ка) осталось.");
                }
            }
            if(n){
                System.out.println("Вы выиграли!");
            } else {
                System.out.println("Вы проиграли!");
            }
            System.out.println("Повторить игру еще раз? 1 - да / 0 – нет");
            x = Integer.parseInt(reader.readLine());
            if(x != 1){
                break;
            }
        }
    }
}
