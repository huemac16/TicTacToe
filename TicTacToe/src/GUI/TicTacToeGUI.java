package GUI;

import BL.TicTacToeBL;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            //System.out.println(String.format("y: %d  x: %d    %d", yCount, xCount, i));
            JButton button = new JButton();
            if (i % 3 == 0 && i != 0) {
                yCount++;
            }
            button.setName(String.format("%d;%d", yCount, xCount));

            if (xCount >= 2) {
                xCount = 0;
            } else {
                xCount++;
            }

            button.setOpaque(true);
            button.setBackground(Color.BLACK);
            this.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //JOptionPane.showMessageDialog(null, button.getName());
                    if (button.getBackground() == Color.BLACK) {
                        if (count % 2 == 0) {
                            button.setBackground(Color.RED);

                            bl.updateArray(Color.RED, button.getName());

                        } else {
                            button.setBackground(Color.BLUE);
                            bl.updateArray(Color.BLUE, button.getName());
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
