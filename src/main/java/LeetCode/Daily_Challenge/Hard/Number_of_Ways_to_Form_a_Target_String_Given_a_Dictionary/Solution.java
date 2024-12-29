package LeetCode.Daily_Challenge.Hard.Number_of_Ways_to_Form_a_Target_String_Given_a_Dictionary;

import java.util.Arrays;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();

        int[][] count = new int[n][26];
        for (String word : words)
            for (int j = 0; j < n; j++)
                count[j][word.charAt(j) - 'a']++;

        long[][] dp = new long[m + 1][n + 1];

        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];

                char c = target.charAt(i - 1);
                dp[i][j] += dp[i - 1][j - 1] * count[j - 1][c - 'a'];
                dp[i][j] %= MOD;
            }
        }

        return (int) dp[m][n];
    }
}
