package LeetCode.Daily_Challenge.Easy.Clear_Digits;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.clearDigits("abc"));
        System.out.println(sol.clearDigits("cb34"));
        System.out.println(sol.clearDigits("a1b2c3"));
        System.out.println(sol.clearDigits("ab12c3d4e5"));
    }

    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!stack.isEmpty())
                    stack.pop();
            } else stack.push(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack)
            result.append(c);

        return result.toString();
    }
}
