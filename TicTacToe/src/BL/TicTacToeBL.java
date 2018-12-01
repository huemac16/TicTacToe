package BL;

import java.awt.Color;

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
    
    public void printArray()
    {
        for(int i = 0; i < situations.length; i++)
        {
            Situation[] row = situations[i];
            for(int j = 0; j < row.length; j++)
            {
                System.out.print(" " + row[j]);
            }
            System.out.println("");
        }
    }
    
    private void updateArray(Color c)
    {
        
    }

}
