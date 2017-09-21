package geekbrains.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Window window = new Window();
    }
}

class Window extends JFrame {

    public Window() {
        setTitle("chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        Box bv = new Box(BoxLayout.X_AXIS);

        JTextField textField = new JTextField( 20);
        textField.setHorizontalAlignment(JTextField.LEFT);

        JTextArea textArea = new JTextArea(5,20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);



        JButton button = new JButton("SEND");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().trim().length() > 0) {
                    textArea.append(textField.getText() + "\n");
                    saveText(textField.getText());
                }
                textField.setText("");
                textField.requestFocusInWindow();
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().trim().length() > 0) {
                    textArea.append(textField.getText() + "\n");
                    saveText(textField.getText());
                }
                textField.setText("");
                textField.requestFocusInWindow();
            }
        });

        bv.add(textField);
        bv.add(button);

        getContentPane().add(new JScrollPane(textArea));
        getContentPane().add(bv, BorderLayout.SOUTH);
        setVisible(true);

    }

    public void saveText(String text){
        try(FileWriter writer = new FileWriter("C:\\notes.txt", true))
        {
            writer.write(text + "\r\n");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}