package LeetCode.Problems.Easy.Longest_Unequal_Adjacent_Groups_Subsequence_I;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words1 = {"e", "a", "b"};
        int[] groups1 = {0, 0, 1};
        System.out.println(solution.getLongestSubsequence(words1, groups1));

        String[] words2 = {"a", "b", "c", "d"};
        int[] groups2 = {1, 0, 1, 1};
        System.out.println(solution.getLongestSubsequence(words2, groups2));
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        List<String>[] dp = new List[n];
        dp[0] = new ArrayList<>();
        dp[0].add(words[0]);

        int maxLen = 1;
        List<String> result = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(words[i]);
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && dp[j].size() + 1 > dp[i].size()) {
                    dp[i] = new ArrayList<>(dp[j]);
                    dp[i].add(words[i]);
                    if (dp[i].size() > maxLen) {
                        maxLen = dp[i].size();
                        result = dp[i];
                    }
                }
            }
        }
        return result;
    }
}
