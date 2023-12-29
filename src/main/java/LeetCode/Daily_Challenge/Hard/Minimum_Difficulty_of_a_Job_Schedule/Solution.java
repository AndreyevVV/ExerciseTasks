package LeetCode.Daily_Challenge.Hard.Minimum_Difficulty_of_a_Job_Schedule;

public class Solution {

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d) return -1;

        int[][] dp = new int[d + 1][n + 1];

        for (int i = 1; i <= n; i++)
            dp[1][i] = Math.max(dp[1][i - 1], jobDifficulty[i - 1]);

        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int maxDifficulty = 0;
                for (int k = j; k >= i; k--) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[k - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + maxDifficulty);
                }
            }
        }
        return dp[d][n];
    }
}
