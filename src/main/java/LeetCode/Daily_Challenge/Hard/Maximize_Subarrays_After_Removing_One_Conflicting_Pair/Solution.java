package LeetCode.Daily_Challenge.Hard.Maximize_Subarrays_After_Removing_One_Conflicting_Pair;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] right = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            right[i] = new ArrayList<>();

        for (int[] pair : conflictingPairs) {
            int a = pair[0], b = pair[1];
            right[Math.max(a, b)].add(Math.min(a, b));
        }

        long totalValid = 0;
        long[] topLeft = {0, 0};
        long[] bonus = new long[n + 1];

        for (int r = 1; r <= n; r++) {
            for (int l : right[r]) {
                if (l > topLeft[0]) {
                    topLeft[1] = topLeft[0];
                    topLeft[0] = l;
                } else if (l > topLeft[1])
                    topLeft[1] = l;
            }

            totalValid += r - topLeft[0];

            if (topLeft[0] > 0)
                bonus[(int) topLeft[0]] += topLeft[0] - topLeft[1];
        }

        long maxBonus = 0;
        
        for (long b : bonus)
            maxBonus = Math.max(maxBonus, b);

        return totalValid + maxBonus;
    }
}
