package LeetCode.Daily_Challenge.Easy.Final_Prices_With_a_Special_Discount_in_a_Shop;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = prices[index];
        }

        return result;
    }
}
