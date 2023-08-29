package LeetCode.LeetCode_75.Monotonic_Stack.Medium.Online_Stock_Span;

import java.util.Stack;

public class Solution {
    class StockSpanner {
        private final Stack<Pair> stack;

        public StockSpanner() {
            this.stack = new Stack<>();
        }

        public int next(int price) {
            int sum = 1;

            while (!stack.isEmpty() && stack.peek().price <= price)
                sum += stack.pop().sum;

            this.stack.push(new Pair(price, sum));

            return sum;
        }

        private class Pair {
            int price;
            int sum;

            Pair(int value, int index) {
                this.price = value;
                this.sum = index;
            }
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

