package LeetCode.Daily_Challenge.Hard.Student_Attendance_Record_II;

public class Solution {
    public static final int MOD = 1000000007;

    public int checkRecord(int n) {
        long[][][] dp = new long[n + 1][2][3];
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                    if (j > 0)
                        dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][k]) % MOD;
                    if (k > 0)
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }

        long result = 0;
        for (int j = 0; j <= 1; j++)
            for (int k = 0; k <= 2; k++)
                result = (result + dp[n][j][k]) % MOD;

        return (int) result;
    }
}
