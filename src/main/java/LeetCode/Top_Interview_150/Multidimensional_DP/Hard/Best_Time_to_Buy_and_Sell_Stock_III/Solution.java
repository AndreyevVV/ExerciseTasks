package LeetCode.Top_Interview_150.Multidimensional_DP.Hard.Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int maxTransactions = 2;
        int[][][] dp = new int[n][maxTransactions + 1][2];

        for (int k = 0; k <= maxTransactions; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int k = maxTransactions; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i]);
        }
        return dp[n - 1][maxTransactions][0];
    }
}
