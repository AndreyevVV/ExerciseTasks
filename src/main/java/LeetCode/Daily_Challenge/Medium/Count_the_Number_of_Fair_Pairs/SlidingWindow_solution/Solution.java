package LeetCode.Daily_Challenge.Medium.Count_the_Number_of_Fair_Pairs.SlidingWindow_solution;

import java.util.Arrays;

public class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairsWithSumAtMost(nums, upper) - countPairsWithSumAtMost(nums, lower - 1);
    }

    private long countPairsWithSumAtMost(int[] nums, int maxSum) {
        long pairCount = 0;
        int right = nums.length - 1;

        for (int left = 0; left < right; left++) {
            while (left < right && nums[left] + nums[right] > maxSum)
                right--;
            pairCount += right - left;
        }

        return pairCount;
    }
}
