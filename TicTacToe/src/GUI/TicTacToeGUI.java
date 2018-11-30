package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToeGUI extends JFrame {

    private int count = 0;

    public TicTacToeGUI() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(500, 500);
        this.setLayout(new GridLayout(3, 3));
        this.setResizable(false);

        for (int i = 0; i <= 8; i++) {
            JButton button = new JButton();
            button.setOpaque(true);
            button.setBackground(Color.BLACK);
            this.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (button.getBackground() == Color.BLACK) {
                        if (count % 2 == 0) {
                            button.setBackground(Color.RED);

                        } else {
                            button.setBackground(Color.BLUE);
                        }
                        count++;
                    } else {
                        //disable hover effect ???
                    }

                }
            });

        }

    }

    public static void main(String[] args) {
        new TicTacToeGUI().setVisible(true);
    }

}
