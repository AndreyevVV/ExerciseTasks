package LeetCode.Daily_Challenge.Medium.Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves;

import java.util.Arrays;

public class Solution {

    public int minDifference(int[] nums) {
        if (nums.length <= 4)
            return 0;

        Arrays.sort(nums);

        int n = nums.length;
        int minDifference = Integer.MAX_VALUE;

        minDifference = Math.min(minDifference, nums[n-1] - nums[3]);
        minDifference = Math.min(minDifference, nums[n-2] - nums[2]);
        minDifference = Math.min(minDifference, nums[n-3] - nums[1]);
        minDifference = Math.min(minDifference, nums[n-4] - nums[0]);

        return minDifference;
    }
}
