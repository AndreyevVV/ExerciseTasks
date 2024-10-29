package LeetCode.Daily_Challenge.Medium.Maximum_Number_of_Moves_in_a_Grid;

public class Solution {

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int maxMoves = 0;

        for (int i = 0; i < m; i++)
            maxMoves = Math.max(maxMoves, dfs(grid, i, 0, dp));

        return maxMoves;
    }

    private int dfs(int[][] grid, int row, int col, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (col == n - 1)
            return 0;

        if (dp[row][col] != 0)
            return dp[row][col];

        int max = 0;

        if (row > 0 && grid[row - 1][col + 1] > grid[row][col])
            max = Math.max(max, 1 + dfs(grid, row - 1, col + 1, dp));
        if (grid[row][col + 1] > grid[row][col])
            max = Math.max(max, 1 + dfs(grid, row, col + 1, dp));
        if (row < m - 1 && grid[row + 1][col + 1] > grid[row][col])
            max = Math.max(max, 1 + dfs(grid, row + 1, col + 1, dp));

        dp[row][col] = max;
        return max;
    }
}
