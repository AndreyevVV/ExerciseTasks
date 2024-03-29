package LeetCode.Top_Interview_150.Multidimensional_DP.Medium.Minimum_Path_Sum;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++)
            dp[i][0] = grid[i][0] + dp[i - 1][0];

        for (int j = 1; j < grid[0].length; j++)
            dp[0][j] = grid[0][j] + dp[0][j - 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
