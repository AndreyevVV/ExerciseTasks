package LeetCode.Daily_Challenge.Medium.Minimum_Falling_Path_Sum.Bottom_Up_solution;

public class Solution {

    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for (int j = 0; j < cols; j++)
            dp[rows - 1][j] = matrix[rows - 1][j];

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                int left = (j > 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int right = (j < cols - 1) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;
                int down = dp[i + 1][j];

                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(right, down));
            }
        }

        int minPathSum = Integer.MAX_VALUE;

        for (int j = 0; j < cols; j++)
            minPathSum = Math.min(minPathSum, dp[0][j]);

        return minPathSum;
    }
}
