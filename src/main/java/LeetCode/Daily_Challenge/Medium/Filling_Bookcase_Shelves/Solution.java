package LeetCode.Daily_Challenge.Medium.Filling_Bookcase_Shelves;

import java.util.Arrays;

public class Solution {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int width = 0;
            int height = 0;
            for (int j = i; j < n; j++) {
                width += books[j][0];
                if (width > shelfWidth)
                    break;
                height = Math.max(height, books[j][1]);
                dp[i] = Math.min(dp[i], height + dp[j + 1]);
            }
        }
        return dp[0];
    }
}
