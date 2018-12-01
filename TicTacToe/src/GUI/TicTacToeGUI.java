package GUI;

import BL.TicTacToeBL;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TicTacToeGUI extends JFrame {

    private int count;
    private TicTacToeBL bl;
    private int xCount;
    private int yCount;
    private boolean end;
    private int clickCount;

    {
        count = 0;
        xCount = 0;
        yCount = 0;
        end = false;
        bl = new TicTacToeBL();
        clickCount = 0;
    }

    public TicTacToeGUI() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");

        this.setLayout(new GridLayout(3, 3, 1, 0));
        this.setResizable(false);

        bl.generateArray();

        JLabel status = new JLabel();
        status.setText("Rot ist an der Reihe ");
        status.setForeground(Color.RED);

        for (int i = 0; i < 9; i++) {

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
                    if (!end) {
                        if (button.getBackground() == Color.BLACK) {
                            clickCount++;

                            if (count % 2 == 0) {
                                status.setForeground(Color.BLUE);
                                status.setText("Blau ist an der Reihe ");

                                button.setBackground(Color.RED);
                                bl.updateArray(Color.RED, button.getName());
                            } else {
                                status.setForeground(Color.RED);
                                status.setText("Rot ist an der Reihe ");

                                button.setBackground(Color.BLUE);
                                bl.updateArray(Color.BLUE, button.getName());
                            }

                            switch (bl.checkWin()) {
                                case 0:
                                    status.setOpaque(true);
                                    status.setBackground(Color.RED);
                                    status.setForeground(Color.WHITE);
                                    status.setText("Rot hat gewonnen! ");
                                    JOptionPane.showMessageDialog(null, "Rot hat gewonnen!");

                                    end = true;
                                    break;
                                case 1:
                                    status.setOpaque(true);
                                    status.setBackground(Color.BLUE);
                                    status.setForeground(Color.WHITE);
                                    status.setText("Blau hat gewonnen! ");
                                    JOptionPane.showMessageDialog(null, "Blau hat gewonnen");

                                    end = true;
                                    break;
                            }
                            if (clickCount == 9 && bl.checkWin() == -1) {
                                JOptionPane.showMessageDialog(null, "kein Gewinner!");
                            }
                            count++;

                        } else {
                            JOptionPane.showMessageDialog(null, "Dieses Feld kann nicht mehr ausgewählt werden!");
                        }
                    }

                }
            }
            );

        }

        JMenuBar mBar = new JMenuBar();
        JMenu menue = new JMenu();
        JMenuItem restart = new JMenuItem();
        JMenuItem end = new JMenuItem();

        menue.setText("Game Options");

        restart.setText("restart game");
        menue.add(restart);

        end.setText("end game");
        menue.add(end);

        mBar.add(menue);
        mBar.add(Box.createGlue());
        mBar.add(status);

        setJMenuBar(mBar);

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                restart();
            }
        });

        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        this.setSize(500, 500);
        setLocationRelativeTo(null);

    }

    private void restart() {
        this.dispose();
        TicTacToeGUI gui = new TicTacToeGUI();
        gui.setLocation(this.getLocation());
        gui.setVisible(true);

    }

    public static void main(String[] args) {
        new TicTacToeGUI().setVisible(true);
    }

}
