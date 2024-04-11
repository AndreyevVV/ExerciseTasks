package LeetCode.Daily_Challenge.Medium.Remove_K_Digits;

import java.util.Stack;

public class Solution {

    public String removeKdigits(String num, int k) {
        if (num.length() == 0 || num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.insert(0, stack.pop());

        while (result.length() > 1 && result.charAt(0) == '0')
            result.deleteCharAt(0);

        return result.toString();
    }
}
