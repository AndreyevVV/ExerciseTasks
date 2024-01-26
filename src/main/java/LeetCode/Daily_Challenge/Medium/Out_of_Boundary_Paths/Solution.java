package LeetCode.Daily_Challenge.Medium.Out_of_Boundary_Paths;

public class Solution {
    Integer[][][] dp;
    private static final int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove + 1];
        return dfs(m, n, maxMove, startRow, startColumn);
    }

    public int dfs(int m, int n, int moves, int row, int col) {
        if (row >= m || col >= n || row < 0 || col < 0)
            return 1;

        if (moves <= 0)
            return 0;

        if (dp[row][col][moves] != null)
            return dp[row][col][moves];

        int ans = 0;

        ans = (ans + dfs(m, n, moves - 1, row - 1, col)) % mod;
        ans = (ans + dfs(m, n, moves - 1, row + 1, col)) % mod;
        ans = (ans + dfs(m, n, moves - 1, row, col - 1)) % mod;
        ans = (ans + dfs(m, n, moves - 1, row, col + 1)) % mod;

        return dp[row][col][moves] = ans;
    }
}
