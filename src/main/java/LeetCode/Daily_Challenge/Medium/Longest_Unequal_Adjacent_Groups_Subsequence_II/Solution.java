package LeetCode.Daily_Challenge.Medium.Longest_Unequal_Adjacent_Groups_Subsequence_II;

import java.util.*;

public class Solution {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if (isValid(words[j], words[i], groups[j], groups[i]))
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }

        int maxLen = 0, endIndex = 0;
        for (int i = 0; i < n; i++)
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }

        LinkedList<String> result = new LinkedList<>();
        while (endIndex != -1) {
            result.addFirst(words[endIndex]);
            endIndex = prev[endIndex];
        }

        return result;
    }

    private boolean isValid(String a, String b, int groupA, int groupB) {
        if (groupA == groupB || a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
