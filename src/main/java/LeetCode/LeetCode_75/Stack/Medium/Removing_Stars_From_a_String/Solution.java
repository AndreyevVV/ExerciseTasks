package LeetCode.LeetCode_75.Stack.Medium.Removing_Stars_From_a_String;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeStars("leet**cod*e"));
    }

    public String removeStars(String s) {
        if (s == null || s.length() == 0) return "";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && !stack.isEmpty()) {
                stack.pop();
                continue;
            } else if (s.charAt(i) == '*' && stack.isEmpty()) continue;
            stack.push(s.charAt(i));
        }

        StringBuilder str = new StringBuilder();

        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
