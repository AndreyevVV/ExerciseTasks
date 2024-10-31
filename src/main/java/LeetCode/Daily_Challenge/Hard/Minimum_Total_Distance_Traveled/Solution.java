package LeetCode.Daily_Challenge.Hard.Minimum_Total_Distance_Traveled;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(f -> f[0]));

        int m = robot.size();
        int n = factory.length;

        long[] dp = new long[m + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int[] f : factory) {
            int factoryPos = f[0];
            int limit = f[1];

            long[] newDp = Arrays.copyOf(dp, dp.length);

            for (int i = 0; i < m; i++) {
                long totalDist = 0;

                for (int k = 1; k <= limit && i + k <= m; k++) {
                    totalDist += Math.abs(factoryPos - robot.get(i + k - 1));
                    if (dp[i] != Long.MAX_VALUE)
                        newDp[i + k] = Math.min(newDp[i + k], dp[i] + totalDist);
                }
            }

            dp = newDp;
        }

        return dp[m];
    }
}
