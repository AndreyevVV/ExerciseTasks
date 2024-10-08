package LeetCode.Daily_Challenge.Medium.Maximum_Number_of_Points_with_Cost;

public class Solution {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[] dp = new long[n];

        for (int j = 0; j < n; j++)
            dp[j] = points[0][j];

        for (int i = 1; i < m; i++) {
            long[] currentDp = new long[n];

            long[] leftMax = new long[n];
            leftMax[0] = dp[0];

            for (int j = 1; j < n; j++)
                leftMax[j] = Math.max(leftMax[j - 1] - 1, dp[j]);

            long[] rightMax = new long[n];
            rightMax[n - 1] = dp[n - 1];

            for (int j = n - 2; j >= 0; j--)
                rightMax[j] = Math.max(rightMax[j + 1] - 1, dp[j]);

            for (int j = 0; j < n; j++)
                currentDp[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);

            dp = currentDp;
        }

        long result = 0;
        for (long score : dp)
            result = Math.max(result, score);

        return result;
    }
}
