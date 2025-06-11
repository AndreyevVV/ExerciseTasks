package LeetCode.Daily_Challenge.Hard.Maximum_Difference_Between_Even_and_Odd_Frequency_II;

import java.util.Arrays;

public class Solution {

    public int maxDifference(String s, int k) {
        int n = s.length();
        int maxDiff = Integer.MIN_VALUE;

        for (int a = 0; a <= 4; a++) {
            for (int b = 0; b <= 4; b++) {
                if (a == b) continue;

                int[] countA = new int[n + 1];
                int[] countB = new int[n + 1];

                for (int i = 1; i <= n; i++) {
                    int digit = s.charAt(i - 1) - '0';
                    countA[i] = countA[i - 1] + (digit == a ? 1 : 0);
                    countB[i] = countB[i - 1] + (digit == b ? 1 : 0);
                }

                int[][] g = new int[2][2];
                for (int[] row : g) Arrays.fill(row, Integer.MIN_VALUE);

                int j = 0;

                for (int i = k; i <= n; i++) {
                    while (i - j >= k && countA[i] > countA[j] && countB[i] > countB[j]) {
                        int pa = countA[j] % 2;
                        int pb = countB[j] % 2;
                        g[pa][pb] = Math.max(g[pa][pb], countB[j] - countA[j]);
                        j++;
                    }

                    int pa = countA[i] % 2;
                    int pb = countB[i] % 2;
                    int bestPrev = g[1 - pa][pb];
                    if (bestPrev != Integer.MIN_VALUE)
                        maxDiff = Math.max(maxDiff, (countA[i] - countB[i]) + bestPrev);
                }
            }
        }

        return maxDiff == Integer.MIN_VALUE ? -1 : maxDiff;
    }
}
