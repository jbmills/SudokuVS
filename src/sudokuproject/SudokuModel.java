/*
 * To change Sudoku template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuproject;

/**
 *
 * @author Brandon
 */
public class SudokuModel {
    private int [][] sudoku;
    private SudokuModel Sudoku;

    public SudokuModel(){
        sudoku = new int [9][9];
    }

    public boolean isSolved(int i, int j, int num, int[][] sudoku) {
        for (int n = 0; n < 9; ++n) { // row
            if (num == sudoku[n][j]) {
                return false;
            }
        }
        for (int n = 0; n < 9; ++n) {// col
            if (num == sudoku[i][n]) {
                return false;
            }
        }
        int Rowset = (i / 3)*3;
        int Colset = (j / 3)*3;
        for (int n = 0; n < 3; ++n) // box
            for (int m = 0; m < 3; ++m)
                if (num == sudoku[Rowset+n][Colset+m])
                    return false;

        return true; // no violations, so it's legal
    }

    public boolean isSolved3(int [][] sudoku) {
        SolutionCheck.checkRow()
    }

    public boolean isSolved2(int [][] sudoku2) {
        //boolean solved = true;

        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                int num = sudoku2[x][y];

                for (int n = 0; n < 9; n++) { // row
                    if (n == x) {
                        continue;
                    }
                    if (num == sudoku2[n][y]) {
                        return false;
                    }
                }
                for (int n = 0; n < 9; n++) {// col
                    if (n == y) {
                        continue;
                    }
                    if (num == sudoku2[x][n]) {
                        return false;
                    }
                }
                int Rowset = (x / 3)*3;
                int Colset = (y / 3)*3;
                for (int m = 0; m < 3; m++) {// box
                    if (x == Rowset+m) {
                        continue;
                    }
                    for (int n = 0; n < 3; n++) {
                        if (y == Colset+n) {
                            continue;
                        }
                        if (num == sudoku[Rowset+m][Colset+n]) {
                            return false;
                        }
                    }
                }
            }
        }


        return true;
    }



    public int[][] getNewGame(int x) {
        Sudoku = new SudokuModel();

        for (int i = 0; i <= 8; i++)  {
            for (int j = 0; j <= 8; j++)  {
                Sudoku.sudoku[i][j] = -1;
            }
        }
        if (x == 1) {
            Sudoku.sudoku[1][0] = 6;
            Sudoku.sudoku[0][2] = 3;
            Sudoku.sudoku[2][1] = 9;
            Sudoku.sudoku[0][5] = 8;
            Sudoku.sudoku[0][7] = 2;
            Sudoku.sudoku[1][3] = 3;
            Sudoku.sudoku[1][8] = 9;
            Sudoku.sudoku[2][3] = 7;
            Sudoku.sudoku[2][6] = 1;
            Sudoku.sudoku[2][8] = 4;
            Sudoku.sudoku[3][0] = 9;
            Sudoku.sudoku[3][3] = 2;
            Sudoku.sudoku[3][6] = 5;
            Sudoku.sudoku[3][7] = 4;
            Sudoku.sudoku[3][8] = 3;
            Sudoku.sudoku[4][1] = 8;
            Sudoku.sudoku[4][3] = 4;
            Sudoku.sudoku[4][5] = 1;
            Sudoku.sudoku[5][0] = 4;
            Sudoku.sudoku[5][1] = 6;
            Sudoku.sudoku[5][2] = 2;
            Sudoku.sudoku[5][5] = 7;
            Sudoku.sudoku[5][8] = 1;
            Sudoku.sudoku[6][0] = 1;
            Sudoku.sudoku[6][2] = 6;
            Sudoku.sudoku[6][5] = 3;
            Sudoku.sudoku[6][7] = 9;
            Sudoku.sudoku[7][0] = 8;
            Sudoku.sudoku[7][5] = 9;
            Sudoku.sudoku[7][6] = 3;
            Sudoku.sudoku[7][8] = 6;
            Sudoku.sudoku[8][1] = 3;
            Sudoku.sudoku[8][3] = 6;
            Sudoku.sudoku[8][6] = 7;
        }
        else if (x ==2)  {
            Sudoku.sudoku[0][0] = 7;
            Sudoku.sudoku[0][1] = 4;
            Sudoku.sudoku[0][2] = 3;
            Sudoku.sudoku[0][3] = 9;
            Sudoku.sudoku[0][4] = 1;
            Sudoku.sudoku[0][5] = 8;
            Sudoku.sudoku[0][6] = 6;
            Sudoku.sudoku[0][7] = 2;
            Sudoku.sudoku[0][8] = 5;
            Sudoku.sudoku[1][0] = 6;
            Sudoku.sudoku[1][1] = 5;
            Sudoku.sudoku[1][2] = 1;
            Sudoku.sudoku[1][3] = 3;
            Sudoku.sudoku[1][4] = 4;
            Sudoku.sudoku[1][5] = 2;
            Sudoku.sudoku[1][6] = 8;
            Sudoku.sudoku[1][7] = 7;
            Sudoku.sudoku[1][8] = 9;
            Sudoku.sudoku[2][0] = 2;
            Sudoku.sudoku[2][1] = 9;
            Sudoku.sudoku[2][2] = 8;
            Sudoku.sudoku[2][3] = 7;
            Sudoku.sudoku[2][4] = 6;
            Sudoku.sudoku[2][5] = 5;
            Sudoku.sudoku[2][6] = 1;
            Sudoku.sudoku[2][7] = 3;
            Sudoku.sudoku[2][8] = 4;
            Sudoku.sudoku[3][0] = 9;
            Sudoku.sudoku[3][1] = 1;
            Sudoku.sudoku[3][2] = 7;
            Sudoku.sudoku[3][3] = 2;
            Sudoku.sudoku[3][4] = 8;
            Sudoku.sudoku[3][5] = 6;
            Sudoku.sudoku[3][6] = 5;
            Sudoku.sudoku[3][7] = 4;
            Sudoku.sudoku[3][8] = 3;
            Sudoku.sudoku[4][0] = 3;
            Sudoku.sudoku[4][1] = 8;
            Sudoku.sudoku[4][2] = 5;
            Sudoku.sudoku[4][3] = 4;
            Sudoku.sudoku[4][4] = 9;
            Sudoku.sudoku[4][5] = 1;
            Sudoku.sudoku[4][6] = 2;
            Sudoku.sudoku[4][7] = 6;
            Sudoku.sudoku[4][8] = 7;
            Sudoku.sudoku[5][0] = 4;
            Sudoku.sudoku[5][1] = 6;
            Sudoku.sudoku[5][2] = 2;
            Sudoku.sudoku[5][3] = 5;
            Sudoku.sudoku[5][4] = 3;
            Sudoku.sudoku[5][5] = 7;
            Sudoku.sudoku[5][6] = 9;
            Sudoku.sudoku[5][7] = 8;
            Sudoku.sudoku[5][8] = 1;
            Sudoku.sudoku[6][0] = 1;
            Sudoku.sudoku[6][1] = 7;
            Sudoku.sudoku[6][2] = 6;
            Sudoku.sudoku[6][3] = 8;
            Sudoku.sudoku[6][4] = 5;
            Sudoku.sudoku[6][5] = 3;
            Sudoku.sudoku[6][6] = 4;
            Sudoku.sudoku[6][7] = 9;
            Sudoku.sudoku[6][8] = 2;
            Sudoku.sudoku[7][0] = 8;
            Sudoku.sudoku[7][1] = 2;
            Sudoku.sudoku[7][2] = 4;
            Sudoku.sudoku[7][3] = 1;
            Sudoku.sudoku[7][4] = 7;
            Sudoku.sudoku[7][5] = 9;
            Sudoku.sudoku[7][6] = 3;
            Sudoku.sudoku[7][7] = 5;
            Sudoku.sudoku[7][8] = 6;
            Sudoku.sudoku[8][0] = 5;
            Sudoku.sudoku[8][1] = 3;
            Sudoku.sudoku[8][2] = 9;
            Sudoku.sudoku[8][3] = 6;
            Sudoku.sudoku[8][6] = 7;
        }

        return Sudoku.sudoku;
    }

    public int[][] getResetGame() {
        return Sudoku.sudoku;
    }

    public int getHint(int [][] partialPuzzle) {


    }

    public int[][][] errorCheck() {


        return [i][j][number];
    }

}
