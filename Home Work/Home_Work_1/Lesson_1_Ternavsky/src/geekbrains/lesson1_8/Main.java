package geekbrains.lesson1_8;

public class Main {

    public static void main(String[] args) {

        //2222222222222222222222222222
        byte a = 25;
        short b = -589;
        int c = 58996;
        long d = 89898656L;
        float e = 4846.0f;
        double f = 4.4686;
        boolean g = false;
        char h = '\u0116';

        //33333333333333333333333333333
        System.out.println(calc(5, 8, -16, 37));

        //44444444444444444444444444444
        boolean x = summa(18, 3);

        //55555555555555555555555555555
        proverka(-68);

        //66666666666666666666666666666
        boolean b23 = metod(-6);

        //77777777777777777777777777777
        printf("Василий");

        //88888888888888888888888888888
        year(2017);

    }

    static int calc(int a, int b, int c, int d){
        return (a * (b + (c / d)));
    }

    public static boolean summa(int a, int b){
        if((a + b) >= 10 && (a + b) <= 20){
            return true;
        } else {
            return false;
        }
    }

    public static void proverka(int a){
        if(a >= 0){
            System.out.println("Число положительное.");
        } else {
            System.out.println("Число отрицательное.");
        }
    }

    public static boolean metod(int a){
        if(a < 0){
            return true;
        } else {
            return false;
        }
    }

    public static void printf(String a){
        System.out.println("Привет, " + a + "!");
    }

    public static void year(double a){
        if(((a % 4) == 0) && ((a % 100) != 0)) {
            System.out.println("Год високосный.");
        } else if(((a % 100) == 0) && ((a % 400) == 0)){
            System.out.println("Год високосный.");
        } else {
            System.out.println("Год не високосный.");
        }

    }
}
