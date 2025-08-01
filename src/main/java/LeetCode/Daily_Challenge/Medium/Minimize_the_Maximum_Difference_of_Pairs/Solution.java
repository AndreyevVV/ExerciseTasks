package LeetCode.Daily_Challenge.Medium.Minimize_the_Maximum_Difference_of_Pairs;

import java.util.Arrays;

public class Solution {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFormPairs(nums, p, mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length && count < p; ) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2;
            } else
                i++;
        }
        return count >= p;
    }
}
