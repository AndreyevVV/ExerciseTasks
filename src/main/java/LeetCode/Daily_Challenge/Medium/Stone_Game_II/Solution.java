package LeetCode.Daily_Challenge.Medium.Stone_Game_II;

public class Solution {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        int[] suffixSum = new int[n];

        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--)
            suffixSum[i] = piles[i] + suffixSum[i + 1];

        return helper(piles, 0, 1, dp, suffixSum);
    }

    private int helper(int[] piles, int i, int M, int[][] dp, int[] suffixSum) {
        if (i == piles.length) return 0;
        if (2 * M >= piles.length - i) return suffixSum[i];

        if (dp[i][M] != 0) return dp[i][M];

        int maxStones = 0;
        for (int x = 1; x <= 2 * M; x++)
            maxStones = Math.max(maxStones, suffixSum[i] - helper(piles, i + x, Math.max(M, x), dp, suffixSum));

        dp[i][M] = maxStones;
        return maxStones;
    }
}
