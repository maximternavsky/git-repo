package geekbrains.lesson3;
import java.util.*;

class TicTacToe {

    final int SIZE = 5;        //Размер игрового поля
    final int WIN_COMB = 3;     //Выигрышная комбинация
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    int count = 0;

    public static void main(String[] args) {
        new TicTacToe();
    }

    TicTacToe() {
        initMap();
        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                printMap();
                System.out.println("YOU WIN!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI WIN!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {


        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[x][y] = DOT_O;
    }

    boolean checkWin(char dot) {
        // check horizontals
        for (int i = 0; i < SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot){
                    count++;
                    if (count == WIN_COMB) return true;
                } else {
                    count = 0;
                }
            }
        }
        // check verticals
        for (int i = 0; i < SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == dot){
                    count++;
                    if (count == WIN_COMB) return true;
                } else {
                    count = 0;
                }
            }
        }
        count = 0;
        // check diagonals
//        for (int j = 0; j < SIZE; j++) {
//            if (map[j][j] == dot){
//                count++;
//                if (count == WIN_COMB) return true;
//            } else {
//                count = 0;
//            }
//        }
    int j = 0;
        for (int i = 0; i < SIZE; i++) {
            j = 0;
            while(j + i < SIZE - 1) {
                if(map[j][j+i] == dot){
                        count++;
                        if (count == WIN_COMB) return true;
                }  else {
                count = 0;
            }
            j++;
            }
        }
        count = 0;
        for (int u = 0; u < SIZE; u++) {
            if (map[(SIZE - 1) - u][u] == dot){
                count++;
                if (count == WIN_COMB) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        if (map[y][x] == DOT_EMPTY)
            return true;
        return false;
    }
}