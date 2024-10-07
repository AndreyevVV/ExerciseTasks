package LeetCode.Daily_Challenge.Easy.Minimum_String_Length_After_Removing_Substrings;

public class Solution {

    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int n = stack.length();

            if (n > 0 && ((stack.charAt(n - 1) == 'A' && c == 'B') || (stack.charAt(n - 1) == 'C' && c == 'D')))
                stack.deleteCharAt(n - 1);
             else
                stack.append(c);
        }

        return stack.length();
    }
}
