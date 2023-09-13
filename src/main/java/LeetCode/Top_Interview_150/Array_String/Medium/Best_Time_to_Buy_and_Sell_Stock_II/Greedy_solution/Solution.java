package LeetCode.Top_Interview_150.Array_String.Medium.Best_Time_to_Buy_and_Sell_Stock_II.Greedy_solution;

public class Solution {

    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maximumProfit += prices[i] - prices[i - 1];
            }
        }
        return maximumProfit;
    }
}
