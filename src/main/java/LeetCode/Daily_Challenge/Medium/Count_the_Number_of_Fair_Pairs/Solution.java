package LeetCode.Daily_Challenge.Medium.Count_the_Number_of_Fair_Pairs;

import java.util.Arrays;

public class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int left = findLowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int right = findUpperBound(nums, i + 1, n - 1, upper - nums[i]);
            count += (right - left + 1);
        }

        return count;
    }

    private int findLowerBound(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    private int findUpperBound(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}
