package LeetCode.LeetCode_75_Level_1.Day_5_Greedy.Easy.Best_Time_to_Buy_and_Sell_Stock;

import java.util.Arrays;

public class Solution {

    public int maxProfit(int[] prices) {

        int buyPointer = 0, sellPointer = 1;
        int profit, maxProfit = 0;

        while (sellPointer < prices.length) {

            if (prices[buyPointer] < prices[sellPointer]) {

                profit = prices[sellPointer] - prices[buyPointer];

                if (profit > maxProfit) maxProfit = profit;
            } else buyPointer = sellPointer;

            sellPointer++;
        }
        return maxProfit;
    }
}
