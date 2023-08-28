package LeetCode.LeetCode_75.Monotonic_Stack.Medium.Daily_Temperatures;

import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek().value <= temperatures[i]) stack.pop();
            if (!stack.empty()) answer[i] = stack.peek().index - i;
            stack.push(new Pair(temperatures[i], i));
        }
        return answer;
    }

    private static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
