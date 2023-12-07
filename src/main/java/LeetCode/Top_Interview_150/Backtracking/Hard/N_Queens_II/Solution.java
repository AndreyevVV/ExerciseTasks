package LeetCode.Top_Interview_150.Backtracking.Hard.N_Queens_II;

public class Solution {

    public int totalNQueens(int n) {
        int[] result = {0};
        int[] queens = new int[n];

        solveNQueensHelper(n, 0, queens, result);

        return result[0];
    }

    private void solveNQueensHelper(int n, int row, int[] queens, int[] result) {
        if (row == n) {
            result[0]++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, queens)) {
                queens[row] = col;
                solveNQueensHelper(n, row + 1, queens, result);
            }
        }
    }

    private boolean isValid(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == row - i)
                return false;
        }
        return true;
    }
}
