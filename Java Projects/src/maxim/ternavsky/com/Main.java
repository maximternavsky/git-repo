package maxim.ternavsky.com;

public class Main {

    public static void main(String[] args) {
        String[] words1 = {"help", "hello", "give", "break"};
        String[] words2 = {"me", "you", "us", "kitty"};

        int w1 = words1.length;
        int w2 = words2.length;

        int rand1 = (int) (Math.random() * w1);
        int rand2 = (int) (Math.random() * w2);

        String phrase = words1[rand1] + " " + words2[rand2];

        System.out.println(phrase);
    }
}
