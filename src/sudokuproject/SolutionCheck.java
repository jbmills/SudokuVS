package sudokuproject;

/**
 * Created by Brandon on 9/16/2015.
 */
public class SolutionCheck {

    public boolean checkRow(int x, int y, int [][] puzzleIn) {
        int num = puzzleIn[x][y];
        for (int n = 0; n < 9; n++) { // row
            if (n == x) {
                continue;
            }
            if (num == puzzleIn[n][y]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(int x, int y, int [][] puzzleIn) {
        int num = puzzleIn[x][y];
        for (int n = 0; n < 9; n++) {// col
            if (n == y) {
                continue;
            }
            if (num == puzzleIn[x][n]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkBox(int x, int y, int [][] puzzleIn) {
        int num = puzzleIn[x][y];
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
                if (num == puzzleIn[Rowset+m][Colset+n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
