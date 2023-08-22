package LeetCode.LeetCode_75.DP_1D.Domino_and_Tromino_Tiling;

public class Solution {

    public int numTilings(int n) {
        if (n < 3) return n;
        if (n == 3) return 5;

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]  + dp[i - 3])  % (int)(Math.pow(10 , 9) + 7);
        }
        return (int)(dp[n] % (int)(Math.pow(10 , 9) + 7));
    }
}
