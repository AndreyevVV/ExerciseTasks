package LeetCode.Daily_Challenge.Hard.Parsing_A_Boolean_Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ')') {
                List<Character> subExpr = new ArrayList<>();

                while (stack.peek() != '(')
                    subExpr.add(stack.pop());

                stack.pop();

                char operator = stack.pop();

                boolean result = false;

                if (operator == '&') {
                    result = true;
                    for (char c : subExpr)
                        result &= (c == 't');
                } else if (operator == '|') {
                    result = false;
                    for (char c : subExpr)
                        result |= (c == 't');
                } else if (operator == '!')
                    result = subExpr.get(0) == 'f';

                stack.push(result ? 't' : 'f');
            } else if (ch != ',')
                stack.push(ch);
        }

        return stack.pop() == 't';
    }
}
