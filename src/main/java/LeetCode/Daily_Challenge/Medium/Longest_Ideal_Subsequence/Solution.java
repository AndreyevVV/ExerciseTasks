package LeetCode.Daily_Challenge.Medium.Longest_Ideal_Subsequence;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestIdealString("acfgbd", 2));
    }

    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            int character = s.charAt(i) - 'a';

            for (int j = character; j >= 0 && j >= character - k; j--)
                dp[character] = Math.max(dp[character], dp[j] + 1);

            for (int j = character + 1; j < 26 && j <= character + k; j++)
                dp[character] = Math.max(dp[character], dp[j] + 1);

            maxLength = Math.max(maxLength, dp[character]);
        }
        return maxLength;
    }
}
