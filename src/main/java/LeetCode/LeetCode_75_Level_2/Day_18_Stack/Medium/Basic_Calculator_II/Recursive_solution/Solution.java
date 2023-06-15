package LeetCode.LeetCode_75_Level_2.Day_18_Stack.Medium.Basic_Calculator_II.Recursive_solution;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        char operation = '+';
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ')
                continue;
            else if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }

                if (operation == '+')
                    st.push(num);
                else if (operation == '-') {
                    st.push(-num);
                } else if (operation == '*') {
                    st.push(num * st.pop());
                } else {
                    st.push(st.pop() / num);
                }
                i--;
            } else if (ch == '+') {
                operation = '+';
            } else if (ch == '-') {
                operation = '-';
            } else if (ch == '*') {
                operation = '*';
            } else if (ch == '/') {
                operation = '/';
            }
        }

        int res = 0;

        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}
