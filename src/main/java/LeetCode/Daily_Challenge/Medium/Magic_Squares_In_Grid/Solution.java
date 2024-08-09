package LeetCode.Daily_Challenge.Medium.Magic_Squares_In_Grid;

public class Solution {

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++)
            for (int j = 0; j < grid[0].length - 2; j++)
                if (isMagicSquare(grid, i, j))
                    count++;
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        return (grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2] == sum &&
                grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] == sum &&
                grid[row][col] + grid[row + 1][col] + grid[row + 2][col] == sum &&
                grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1] == sum &&
                grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2] == sum &&
                grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] == sum &&
                grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] == sum);
    }
}
