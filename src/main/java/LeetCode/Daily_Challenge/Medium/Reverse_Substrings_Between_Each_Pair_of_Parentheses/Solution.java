package LeetCode.Daily_Challenge.Medium.Reverse_Substrings_Between_Each_Pair_of_Parentheses;

import java.util.Stack;

public class Solution {

    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(current);
                current = new StringBuilder();
            } else if (c == ')') {
                current.reverse();
                current = stack.pop().append(current);
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
}
