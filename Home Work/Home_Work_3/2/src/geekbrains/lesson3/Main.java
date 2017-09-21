package geekbrains.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String answer;
        String otv = "";
        char[] chars;
        String rand = words[(int)(Math.random() * words.length)];
        boolean compl = false;
        int k = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Угадай слово. (фрукт или овощ)");
//        System.out.println("Подсказка: \n");
//        for (int i = 0; i < words.length; i++) {
//            System.out.print(words[i] + ", ");
//            if(((i +1) % 5) == 0){
//                System.out.print("\n");
//            }
//        }
        while(true) {
            k = 0;
            otv = "";
            answer = reader.readLine();
            chars = answer.toCharArray();
            answer = "";
            for (char c : chars) {
                c = Character.toLowerCase(c);
                answer += c;
            }
            if(answer == rand) {
                System.out.println("Вы выиграли!");
            }

            for (int i = 0; i < 15; i++) {
                if ((answer.length() > i) && (rand.length() > i)) {
                    if (answer.charAt(i) != rand.charAt(i)) {
                        otv += "#";
                    } else {
                        otv += answer.charAt(i);
                        k++;
                    }
                } else {
                    otv += "#";
                }
            }
            if(k == answer.length()) {
                System.out.println("Вы выиграли!");
                return;
            }
            System.out.println(otv);
        }
    }
}
