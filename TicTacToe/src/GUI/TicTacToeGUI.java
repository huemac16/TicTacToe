package GUI;

import BL.TicTacToeBL;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeGUI extends JFrame {

    private int count;
    private TicTacToeBL bl;
    private int xCount;
    private int yCount;

    {
        count = 0;
        xCount = 0;
        yCount = 0;
        bl = new TicTacToeBL();
    }

    public TicTacToeGUI() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(500, 500);
        this.setLayout(new GridLayout(3, 3));
        this.setResizable(false);

        bl.generateArray();
        bl.printArray();

        for (int i = 0; i < 9; i++) {
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
                        JOptionPane.showMessageDialog(null, "Dieses Feld kann nicht mehr ausgewählt werden!");
                    }

                }
            });

        }

    }

    public static void main(String[] args) {
        new TicTacToeGUI().setVisible(true);
    }

}
