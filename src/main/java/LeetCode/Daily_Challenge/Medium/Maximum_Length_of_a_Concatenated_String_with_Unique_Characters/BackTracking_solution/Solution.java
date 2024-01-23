package LeetCode.Daily_Challenge.Medium.Maximum_Length_of_a_Concatenated_String_with_Unique_Characters.BackTracking_solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    int maxLength = 0;

    public int maxLength(List<String> arr) {
        backtrack(arr, new StringBuilder(), 0);
        return maxLength;
    }

    private void backtrack(List<String> arr, StringBuilder s, int index) {
        maxLength = Math.max(maxLength, s.length());

        for (int i = index; i < arr.size(); i++) {
            String curr = arr.get(i);

            if (isUnique(s, curr)) {
                s.append(curr);
                backtrack(arr, s, i+1);
                s.delete(s.length() - curr.length(), s.length());
            }
        }
    }

    private boolean isUnique(StringBuilder s1, String s2) {
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (!charSet.add(ch)) return false;
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (!charSet.add(ch)) return false;
        }
        return true;
    }
}
