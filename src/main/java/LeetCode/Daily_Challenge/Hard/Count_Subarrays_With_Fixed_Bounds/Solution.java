package LeetCode.Daily_Challenge.Hard.Count_Subarrays_With_Fixed_Bounds;

public class Solution {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int lastInvalidIndex = -1, left = -1, right = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (!(minK <= nums[i] && nums[i] <= maxK))
                lastInvalidIndex = i;

            if (nums[i] == minK)
                left = i;

            if (nums[i] == maxK)
                right = i;

            count += Math.max(0, Math.min(left, right) - lastInvalidIndex);
        }
        return count;
    }
}
