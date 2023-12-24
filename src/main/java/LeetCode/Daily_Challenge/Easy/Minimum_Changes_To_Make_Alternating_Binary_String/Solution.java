package LeetCode.Daily_Challenge.Easy.Minimum_Changes_To_Make_Alternating_Binary_String;

public class Solution {

    public static int minOperationsToMakeAlternating(String s) {
        int n = s.length();
        int operationsToMakeZero = 0;
        int operationsToMakeOne = 0;

        for (int i = 0; i < n; i++) {
            char expected = ((i & 1) == 0) ? '0' : '1';
            if (s.charAt(i) != expected)
                operationsToMakeZero++;
        }

        for (int i = 0; i < n; i++) {
            char expected = ((i & 1) == 0) ? '1' : '0';
            if (s.charAt(i) != expected)
                operationsToMakeOne++;
        }
        return Math.min(operationsToMakeZero, operationsToMakeOne);
    }
}
