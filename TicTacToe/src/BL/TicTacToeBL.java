package BL;

import java.awt.Color;

enum Situation {
    BLACK, RED, BLUE
}

public class TicTacToeBL {

    private Situation[][] situations;

    public void generateArray() {
        situations = new Situation[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                situations[i][j] = Situation.BLACK;
            }
        }
    }

    public void printArray() {
        for (int i = 0; i < situations.length; i++) {
            Situation[] row = situations[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(" " + row[j]);
            }
            System.out.println("");
        }

    }

    public void updateArray(Color c, String pos) {
        int xPos;
        int yPos;

        String[] split = pos.split(";");
        yPos = Integer.parseInt(split[0]);
        xPos = Integer.parseInt(split[1]);

        if (c == Color.RED) {
            situations[yPos][xPos] = Situation.RED;
        } else if (c == Color.BLUE) {
            situations[yPos][xPos] = Situation.BLUE;
        }

    }

    public int checkWin() {

        // check if red is the winner
        if (situations[0][0] == Situation.RED && situations[0][1] == Situation.RED && situations[0][2] == Situation.RED) {
            return 0;
        } else if (situations[1][0] == Situation.RED && situations[1][1] == Situation.RED && situations[1][2] == Situation.RED) {
            return 0;
        } else if (situations[2][0] == Situation.RED && situations[2][1] == Situation.RED && situations[2][2] == Situation.RED) {
            return 0;
        } else if (situations[0][0] == Situation.RED && situations[1][0] == Situation.RED && situations[2][0] == Situation.RED) {
            return 0;
        } else if (situations[0][1] == Situation.RED && situations[1][1] == Situation.RED && situations[2][1] == Situation.RED) {
            return 0;
        } else if (situations[0][2] == Situation.RED && situations[1][2] == Situation.RED && situations[2][2] == Situation.RED) {
            return 0;
        } else if (situations[0][0] == Situation.RED && situations[1][1] == Situation.RED && situations[2][2] == Situation.RED) {
            return 0;
        } else if (situations[0][2] == Situation.RED && situations[1][1] == Situation.RED && situations[2][0] == Situation.RED) {
            return 0;
        }

        // check if blue is the winner
        if (situations[0][0] == Situation.BLUE && situations[0][1] == Situation.BLUE && situations[0][2] == Situation.BLUE) {
            return 1;
        } else if (situations[1][0] == Situation.BLUE && situations[1][1] == Situation.BLUE && situations[1][2] == Situation.BLUE) {
            return 1;
        } else if (situations[2][0] == Situation.BLUE && situations[2][1] == Situation.BLUE && situations[2][2] == Situation.BLUE) {
            return 1;
        } else if (situations[0][0] == Situation.BLUE && situations[1][0] == Situation.BLUE && situations[2][0] == Situation.BLUE) {
            return 1;
        } else if (situations[0][1] == Situation.BLUE && situations[1][1] == Situation.BLUE && situations[2][1] == Situation.BLUE) {
            return 1;
        } else if (situations[0][2] == Situation.BLUE && situations[1][2] == Situation.BLUE && situations[2][2] == Situation.BLUE) {
            return 1;
        } else if (situations[0][0] == Situation.BLUE && situations[1][1] == Situation.BLUE && situations[2][2] == Situation.BLUE) {
            return 1;
        } else if (situations[0][2] == Situation.BLUE && situations[1][1] == Situation.BLUE && situations[2][0] == Situation.BLUE) {
            return 1;
        }

        return -1;

    }

}
