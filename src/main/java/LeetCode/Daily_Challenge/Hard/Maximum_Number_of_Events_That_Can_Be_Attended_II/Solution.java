package LeetCode.Daily_Challenge.Hard.Maximum_Number_of_Events_That_Can_Be_Attended_II;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];

        int[] ends = new int[n];
        for (int i = 0; i < n; i++) ends[i] = events[i][1];

        for (int i = 1; i <= n; i++) {
            int[] curr = events[i - 1];
            int start = curr[0], end = curr[1], val = curr[2];

            int prevIndex = binarySearch(ends, start);
            for (int j = 1; j <= k; j++)
                dp[i][j] = Math.max(dp[i - 1][j], dp[prevIndex + 1][j - 1] + val);
        }
        return dp[n][k];
    }

    private int binarySearch(int[] ends, int start) {
        int left = 0, right = ends.length - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ends[mid] < start) {
                res = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return res;
    }
}
