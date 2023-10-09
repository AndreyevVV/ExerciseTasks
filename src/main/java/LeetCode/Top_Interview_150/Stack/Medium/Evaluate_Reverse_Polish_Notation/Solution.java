package LeetCode.Top_Interview_150.Stack.Medium.Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String character : tokens) {
            if (isOperator(character)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = operation(operand1, operand2, character);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(character));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int operation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                return 0;
        }
    }
}
