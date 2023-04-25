package LeetCode.LeetCode_75_Level_1.Day_14_Stack.Easy.Backspace_String_Compare;

import java.util.Stack;

public class Solution {

    public boolean backspaceCompare(String s, String t) {
        return stackFill(s).equals(stackFill(t));
    }

    private static Stack<Character> stackFill(String s) {

        Stack<Character> stack = new Stack<>();

        for (char symbol : s.toCharArray()) {
            if (symbol != '#') {
                stack.push(symbol);
            } else if (!stack.isEmpty()) stack.pop();
        }
        return stack;
    }
}
