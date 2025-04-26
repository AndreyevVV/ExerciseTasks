package LeetCode.Daily_Challenge.Hard.Count_Subarrays_With_Fixed_Bounds.OptimizedSolution;

public class Solution {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int lastInvalidIndex = -1, lastMinK = -1, lastMaxK = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK)
                lastInvalidIndex = i;
            if (nums[i] == minK)
                lastMinK = i;
            if (nums[i] == maxK)
                lastMaxK = i;

            int validStart = Math.min(lastMinK, lastMaxK);
            if (validStart > lastInvalidIndex)
                count += validStart - lastInvalidIndex;
        }

        return count;
    }
}
