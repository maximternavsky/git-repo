package geekbrains.lesson2;

public class Main {

    public static void main(String[] args) {
        //1111111111111111111111111111111111
        int[] a = {0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0};
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }

        //22222222222222222222222222222222222
        int[] b = new int[8];
        for (int i = 0; i < b.length; i++) {
            b[i] = i * 3;
        }

        //33333333333333333333333333333333333
        int[] c = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < c.length; i++) {
            if (c[i] < 6) {
                c[i] *= 2;
            }
        }

        //44444444444444444444444444444444444
        int[][] d = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    d[i][j] = 1;
                } else {
                    d[i][j] = 0;
                }
            }
        }

        //55555555555555555555555555555555555
        int min = 0;
        int max = 0;
        int[] e = {5, 3, 12, 8, 88, 9, 6, 7, 56, -22, 4, 16, 20, 4, 58, 13};
        min = e[0];
        max = e[0];
        for (int i = 0; i < e.length; i++) {
            if (min > e[i]) {
                min = e[i];
            }
            if (max < e[i]) {
                max = e[i];
            }
        }

        //66666666666666666666666666666666666
        int[] f = {9,9,8,9,2,4,5,6,18};
        boolean log = checkBalance(f);

        //77777777777777777777777777777777777
        int[] g = {1,2,0,5,4,5,6,9,4,5};
        g = sdvig(g, 3);
        for (int i = 0; i < g.length; i++) {
            System.out.print(g[i] + " ");
        }

    }

    public static boolean checkBalance(int a[]) {
        if(a.length <= 1){
            return false;
        }
        for (int i = 0; i < a.length; i++) {
        }
        int[] temp1 = new int[a.length];
        int[] temp2 = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                temp1[i] = a[i];
            }
            if (i != 0) {
                temp1[i] = temp1[i - 1] + a[i];
            }
        }

        for (int i = (a.length - 1); i >= 0; i--) {
            if (i == (a.length - 1)) {
                temp2[i] = a[i];
            }
            if (i != (a.length - 1)) {
                temp2[i] = temp2[i + 1] + a[i];
            }
        }

        for (int i = 0; i < a.length; i++) {
            if(i < (a.length - 1)) {
                if (temp1[i] == temp2[i + 1]) {
                    for (int j = 0; j < (a.length - (a.length - i)); j++) {
                        System.out.print(a[j] + " ");

                    }
                    System.out.print(" || ");
                    for (int j = (i + 1); j < a.length; j++) {
                        System.out.print(a[j] + " ");
                    }
                    System.out.print("\n");
                    return true;
                }
            }
            if(i == (a.length - 1)){
                System.out.print("\n");
                return false;
            }
        }
        return false;
    }

    //77777777777777777777777777777777777777777777777
    public static int[] sdvig(int[] a, int b){
        if(a.length <= 1){
            return a;
        }
        int temp = 0;
        for (int i = 0; i < b; i++) {
            temp = a[0];
            a[0] = a[a.length - 1];
            for (int j = 0; j < a.length-1; j++) {
                a[a.length - (j + 1)] = a[a.length - (j + 2)];
            }
            a[1] = temp;
        }
        return a;
    }
}

