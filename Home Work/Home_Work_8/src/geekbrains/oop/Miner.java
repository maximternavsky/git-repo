package geekbrains.oop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Miner extends JFrame{

    final String TITLE = "Miner";
    final int WINDOW_SIZE = 300;
    final int FIELD_SIZE = 10;
    final int DX = 5;
    final int DY = 55;
    final int CELL_SIZE = WINDOW_SIZE / FIELD_SIZE;
    final String BTN_NEW_GAME = "New Game";
    final String BTN_EXIT = "Exit";

    Canvas canvas = new Canvas();
    Field field = new Field(FIELD_SIZE, CELL_SIZE);
    Human human = new Human(field.getHumanDot());
    AI ai = new AI(field.getAIDot());

    public static void main(String[] args) {
    new Miner();
    }

    Miner(){
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE + DX,WINDOW_SIZE + DY);
        setLocationRelativeTo(null);
        setResizable(false);

        JButton new_game = new JButton(BTN_NEW_GAME);
        JButton exit = new JButton(BTN_EXIT);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.add(new_game);
        panel.add(exit);
        new_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.init();
                canvas.repaint();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLayout(new BorderLayout());
        add(panel,BorderLayout.SOUTH);
        add(canvas,BorderLayout.CENTER);

        //canvas.setBackground(Color.WHITE);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3){
                    super.mouseReleased(e);
                    System.out.println(e.getX() / CELL_SIZE + " : " + e.getY() / CELL_SIZE);
                    field.setMine(e.getX() / CELL_SIZE, e.getY() / CELL_SIZE);
                    canvas.repaint();
                } else {
                    super.mouseReleased(e);
                    System.out.println(e.getX() / CELL_SIZE + " : " + e.getY() / CELL_SIZE);
                    human.turn(e.getX() / CELL_SIZE, e.getY() / CELL_SIZE, field, ai);
                    canvas.repaint();
                }
            }
        });

        setVisible(true);
    }

    class Canvas extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            field.paint(g);
        }
    }
}
