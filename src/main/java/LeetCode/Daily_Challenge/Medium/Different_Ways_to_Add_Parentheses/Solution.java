package LeetCode.Daily_Challenge.Medium.Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.diffWaysToCompute("2-1-1"));
        System.out.println(sol.diffWaysToCompute("2*3-4*5"));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+')
                            result.add(left + right);
                        else if (c == '-')
                            result.add(left - right);
                        else if (c == '*')
                            result.add(left * right);
                    }
                }
            }
        }

        if (result.isEmpty())
            result.add(Integer.parseInt(expression));

        return result;
    }
}
