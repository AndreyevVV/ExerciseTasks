package LeetCode.Top_Interview_150.Matrix.Medium.Valid_Sudoku;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] boxCheck = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    int digit = currentChar - '1';

                    if (rowCheck[i][digit]) return false;

                    rowCheck[i][digit] = true;

                    if (colCheck[j][digit]) return false;

                    colCheck[j][digit] = true;
                    int boxIndex = (i / 3) * 3 + j / 3;

                    if (boxCheck[boxIndex][digit]) return false;

                    boxCheck[boxIndex][digit] = true;
                }
            }
        }
        return true;
    }
}
