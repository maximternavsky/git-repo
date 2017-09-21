package geekbrains.oop;

/**
 * Created by Максим on 29.08.2017.
 */
public class Human {
    private final char DOT;

    Human(char ch) {
        DOT = ch;
    }

    void turn(int x, int y, Field field, AI ai){
        field.setHum(x,y);
        if(field.notMines()){

            if(field.isCellEmpty(x,y)){
                if(!field.isGameOver()){
                    field.setDot(x,y,DOT);
                }
            } else if(field.isCellBomb(x,y)){
                field.setGameOver(true);
            }
        }

    }
}
