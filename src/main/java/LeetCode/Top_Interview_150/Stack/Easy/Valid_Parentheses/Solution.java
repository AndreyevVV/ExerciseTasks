package LeetCode.Top_Interview_150.Stack.Easy.Valid_Parentheses;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;

                Character character = stack.pop();

                if ((c == ')' && character != '(') ||
                        (c == '}' && character != '{') ||
                        (c == ']' && character != '[')) return false;
            }

        }
        return stack.isEmpty();
    }
}
