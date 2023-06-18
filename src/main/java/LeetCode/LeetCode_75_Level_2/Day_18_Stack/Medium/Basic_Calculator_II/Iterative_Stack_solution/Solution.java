package LeetCode.LeetCode_75_Level_2.Day_18_Stack.Medium.Basic_Calculator_II.Iterative_Stack_solution;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        char operation = '+';
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == ' ')
                continue;
            else if (Character.isDigit(charAt)) {
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
            } else if (charAt == '+') {
                operation = '+';
            } else if (charAt == '-') {
                operation = '-';
            } else if (charAt == '*') {
                operation = '*';
            } else if (charAt == '/') {
                operation = '/';
            }
        }

        int result = 0;

        while (!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}
