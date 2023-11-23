package LeetCode.Top_Interview_150.Multidimensional_DP.Medium.Unique_Paths_II;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        int rw = obstacleGrid.length;
        int cl = obstacleGrid[0].length;

        int[][] dp = new int[rw][cl];

        for (int i = 0; i < rw; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }

        for (int j = 0; j < cl; j++) {
            if (obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }

        for (int i = 1; i < rw; i++) {
            for (int j = 1; j < cl; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[rw - 1][cl - 1];
    }
}
