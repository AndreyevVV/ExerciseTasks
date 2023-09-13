package LeetCode.Top_Interview_150.Array_String.Medium.Best_Time_to_Buy_and_Sell_Stock_II.DP_solution;

public class Solution {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] maximumProfit = new int[length][2];     // maximumProfit[i][0] represents the maximum profit on day i when not holding a stock
        // maximumProfit[i][1] represents the maximum profit on day i when holding a stock

        maximumProfit[0][0] = 0;                        // Initial profit on the first day when not holding a stock is 0
        maximumProfit[0][1] = -prices[0];           // Initial profit on the first day when holding a stock is the negative of its price

        for (int i = 1; i < length; i++) {
            // Update the maximum profit on day i when not holding a stock
            maximumProfit[i][0] = Math.max(maximumProfit[i - 1][0], maximumProfit[i - 1][1] + prices[i]);
            // Update the maximum profit on day i when holding a stock
            maximumProfit[i][1] = Math.max(maximumProfit[i - 1][1], maximumProfit[i - 1][0] - prices[i]);
        }
        return maximumProfit[length - 1][0];  // Return the maximum profit on the last day when not holding a stock
    }
}
