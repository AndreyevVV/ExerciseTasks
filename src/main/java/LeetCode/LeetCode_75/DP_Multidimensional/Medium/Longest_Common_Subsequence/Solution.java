package LeetCode.LeetCode_75.DP_Multidimensional.Medium.Longest_Common_Subsequence;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int sr = text1.length();
        int sc = text2.length();

        if(sr == 0 || sc == 0) return 0;

        int[][] dp = new int[sr + 1][sc + 1];

        for (int i = 1; i <= sr; i++) {
            for (int j = 1; j <= sc; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[sr][sc];
    }
}
