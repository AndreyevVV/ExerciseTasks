package LeetCode.Top_Interview_150.Backtracking.Medium.Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String current, int open, int close, int maxPairs) {
        if (current.length() == maxPairs * 2)
            result.add(current);

        if (open < maxPairs)
            generate(result, current + "(", open + 1, close, maxPairs);

        if (close < open)
            generate(result, current + ")", open, close + 1, maxPairs);
    }
}
