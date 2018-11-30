package GUI;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class TicTacToeGUI extends JFrame {

    public TicTacToeGUI() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(3, 3));
        
    }

    public static void main(String[] args) {
        new TicTacToeGUI().setVisible(true);
    }

}
