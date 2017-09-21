package geekbrains.oop;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by Максим on 29.08.2017.
 */
class Field {
    private final int FIELD_SIZE;
    private final int CELL_SIZE;
    private final int BOMB_SIZE = 2;
    private final String MSG_WIN = "YOU WIN!";
    private final char HUMAN_DOT = 'x';
    private final char AI_DOT = 'b';
    private final char BOMB = 'o';
    private final char DOT = '.';
    private final char ONE = '1';
    private final char TWO = '2';
    private final char THREE = '3';
    private final char FOUR = '4';
    private final char FIVE = '5';
    private final char SIX = '6';
    private final char SEVEN = '7';
    private final char EIGHT = '8';
    private final char W = 'S';
    private int[][] n;
    private char[][] field;
    private char[][] field_human;
    private boolean GAME_OVER = false;

    Field(int field_size, int cell_size) {
        FIELD_SIZE = field_size;
        CELL_SIZE = cell_size;
        field = new char[FIELD_SIZE][FIELD_SIZE];
        field_human = new char[FIELD_SIZE][FIELD_SIZE];
        this.n = new int[FIELD_SIZE][FIELD_SIZE];
        init();
    }

    void init() {
        GAME_OVER = false;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = DOT;
                field_human[i][j] = HUMAN_DOT;
            }

        }
        int i = 0;
        int x;
        int y;
        do {
            x = (int) (Math.random() * FIELD_SIZE);
            System.out.println(x);
            y = (int) (Math.random() * FIELD_SIZE);
            if (isCellEmpty(x, y)) {
                field[x][y] = BOMB;
                n[]
                i++;
            }
        } while (i < BOMB_SIZE);

        int numb = 0;
        for (int j = 2; j < FIELD_SIZE - 2; j++) {
            for (int k = 2; k < FIELD_SIZE - 2; k++) {
                if (field[j][k] == BOMB) {
                    for (int l = j - 1; l < j + 2; l++) {
                        for (int m = k - 1; m < k + 2; m++) {
                            if (isCellEmpty(l, m)) {
                                numb = 0;
                                for (int n = l - 1; n < l + 2; n++) {
                                    for (int o = m - 1; o < m + 2; o++) {
                                        if (field[n][o] == BOMB) {
                                            numb++;
                                        }
                                    }
                                }
                                switch (numb) {
                                    case 1:
                                        field[l][m] = ONE;
                                        break;
                                    case 2:
                                        field[l][m] = TWO;
                                        break;
                                    case 3:
                                        field[l][m] = THREE;
                                        break;
                                    case 4:
                                        field[l][m] = FOUR;
                                        break;
                                    case 5:
                                        field[l][m] = FIVE;
                                        break;
                                    case 6:
                                        field[l][m] = SIX;
                                        break;
                                    case 7:
                                        field[l][m] = SEVEN;
                                        break;
                                    case 8:
                                        field[l][m] = EIGHT;
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    int getSize() {
        return FIELD_SIZE;
    }

    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        for (int i = 1; i < FIELD_SIZE; i++) {
            g.drawLine(0, i * CELL_SIZE, FIELD_SIZE * CELL_SIZE, i * CELL_SIZE);
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, FIELD_SIZE * CELL_SIZE);
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == HUMAN_DOT) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                }
                if (field_human[i][j] == W) {
                    g.setColor(Color.green);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 3), (j * CELL_SIZE + 3), CELL_SIZE - 6,
                            CELL_SIZE - 6));
                }
                if ((field[i][j] == BOMB) && (GAME_OVER)) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                    g.setColor(Color.red);
                    g2.fill(new Ellipse2D.Float(i * CELL_SIZE + CELL_SIZE / 4, j * CELL_SIZE + CELL_SIZE / 4,
                            CELL_SIZE / 1.5f, CELL_SIZE / 1.5f));
                }
                if ((field[i][j] == ONE) && (field_human[i][j] == DOT)) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                    g.setColor(Color.blue);
                    g2.drawString("1", (int) ((i * CELL_SIZE) + CELL_SIZE / 3),
                            (int) (((j + 1) * CELL_SIZE) - CELL_SIZE / 3));
                }
                if ((field[i][j] == TWO) && (field_human[i][j] == DOT)) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                    g.setColor(Color.blue);
                    g2.drawString("2", (int) ((i * CELL_SIZE) + CELL_SIZE / 3),
                            (int) (((j + 1) * CELL_SIZE) - CELL_SIZE / 3));
                }
                if ((field[i][j] == THREE) && (field_human[i][j] == DOT)) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                    g.setColor(Color.blue);
                    g2.drawString("3", (int) ((i * CELL_SIZE) + CELL_SIZE / 3),
                            (int) (((j + 1) * CELL_SIZE) - CELL_SIZE / 3));
                }
                if ((field[i][j] == FOUR) && (field_human[i][j] == DOT)) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                    g.setColor(Color.blue);
                    g2.drawString("4", (int) ((i * CELL_SIZE) + CELL_SIZE / 3),
                            (int) (((j + 1) * CELL_SIZE) - CELL_SIZE / 3));
                }
                if ((field[i][j] == FIVE) && (field_human[i][j] == DOT)) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                    g.setColor(Color.blue);
                    g2.drawString("5", (int) ((i * CELL_SIZE) + CELL_SIZE / 3),
                            (int) (((j + 1) * CELL_SIZE) - CELL_SIZE / 3));
                }
                if ((field[i][j] == SIX) && (field_human[i][j] == DOT)) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                    g.setColor(Color.blue);
                    g2.drawString("6", (int) ((i * CELL_SIZE) + CELL_SIZE / 3),
                            (int) (((j + 1) * CELL_SIZE) - CELL_SIZE / 3));
                }
                if ((field[i][j] == SEVEN) && (field_human[i][j] == DOT)) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                    g.setColor(Color.blue);
                    g2.drawString("7", (int) ((i * CELL_SIZE) + CELL_SIZE / 3),
                            (int) (((j + 1) * CELL_SIZE) - CELL_SIZE / 3));
                }
                if ((field[i][j] == EIGHT) && (field_human[i][j] == DOT)) {
                    g.setColor(Color.white);
                    g2.fill(new Rectangle2D.Float((i * CELL_SIZE + 1), (j * CELL_SIZE + 1), CELL_SIZE - 1,
                            CELL_SIZE - 1));
                    g.setColor(Color.blue);
                    g2.drawString("8", (int) ((i * CELL_SIZE) + CELL_SIZE / 3),
                            (int) (((j + 1) * CELL_SIZE) - CELL_SIZE / 3));
                }
            }

        }
    }

    public boolean isCellEmpty(int x, int y) {
        if (field[x][y] == DOT) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCellBomb(int x, int y) {
        if (field[x][y] == BOMB) {
            return true;
        } else {
            return false;
        }
    }

    public char getHumanDot() {
        return HUMAN_DOT;
    }

    public char getAIDot() {
        return AI_DOT;
    }

    public boolean isGameOver() {
        if (GAME_OVER) {
            return true;
        } else {
            return false;
        }
    }

    public void setDot(int x, int y, char dot) {

        field[x][y] = dot;
        if (x > 1 && y >= 1 && x < FIELD_SIZE - 1 && y < FIELD_SIZE - 1) {
            if ((field[x - 1][y - 1] != BOMB) && (field[x - 1][y - 1] != W)) {
                if (isNum(x - 1, y - 1)) {
                    field[x - 1][y - 1] = dot;
                }
            }
            if ((field[x][y - 1] != BOMB) && (field[x][y - 1] != W)) {
                if (isNum(x, y - 1)) {
                    field[x][y - 1] = dot;
                }
            }
            if ((field[x + 1][y - 1] != BOMB) && (field[x + 1][y - 1] != W)) {
                if (isNum(x + 1, y - 1)) {
                    field[x + 1][y - 1] = dot;
                }
            }
            if ((field[x - 1][y] != BOMB) && (field[x - 1][y] != W)) {
                if (isNum(x - 1, y)) {
                    field[x - 1][y] = dot;
                }
            }
            if ((field[x + 1][y] != BOMB) && (field[x + 1][y] != W)) {
                if (isNum(x + 1, y)) {
                    field[x + 1][y] = dot;
                }
            }
            if ((field[x - 1][y + 1] != BOMB) && (field[x - 1][y + 1] != W)) {
                if (isNum(x - 1, y + 1)) {
                    field[x - 1][y + 1] = dot;
                }
            }
            if ((field[x][y + 1] != BOMB) && (field[x][y + 1] != W)) {
                if (isNum(x, y + 1)) {
                    field[x][y + 1] = dot;
                }
            }
            if ((field[x + 1][y + 1] != BOMB) && (field[x + 1][y + 1] != BOMB)) {
                if (isNum(x + 1, y + 1)) {
                    field[x + 1][y + 1] = dot;
                }
            }

        }
    }

    public void setGameOver(boolean i) {
        GAME_OVER = i;
    }

    public void setHum(int x, int y) {
        field_human[x][y] = DOT;
    }

    public boolean isNum(int x, int y) {
        if (this.field[x][y] == ONE) {
            field_human[x][y] = DOT;
            return false;
        }
        if (this.field[x][y] == TWO) {
            field_human[x][y] = DOT;
            return false;
        }
        if (this.field[x][y] == THREE) {
            field_human[x][y] = DOT;
            return false;
        }
        if (this.field[x][y] == FOUR) {
            field_human[x][y] = DOT;
            return false;
        }
        if (this.field[x][y] == FIVE) {
            field_human[x][y] = DOT;
            return false;
        }
        if (this.field[x][y] == SIX) {
            field_human[x][y] = DOT;
            return false;
        }
        if (this.field[x][y] == SEVEN) {
            field_human[x][y] = DOT;
            return false;
        }
        if (this.field[x][y] == EIGHT) {
            field_human[x][y] = DOT;
            return false;
        }

        return true;

    }

    void setMine(int x, int y) {
        if (field_human[x][y] != W) {
            field_human[x][y] = W;
        } else {
            field_human[x][y] = DOT;
        }
    }

    boolean notMines() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == DOT) {
                    return true;
                }
            }
        }
        System.out.println("You Win!");
        return false;
    }
}
