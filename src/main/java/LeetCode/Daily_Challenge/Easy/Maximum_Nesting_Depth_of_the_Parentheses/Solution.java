package LeetCode.Daily_Challenge.Easy.Maximum_Nesting_Depth_of_the_Parentheses;

import java.util.Stack;

public class Solution {

    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                stack.pop();
                currentDepth--;
            }
        }
        return maxDepth;
    }
}
