package LeetCode.Daily_Challenge.Medium.Maximum_Sum_of_Distinct_Subarrays_With_Length_K;

import java.util.HashSet;

public class Solution {

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> window = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (window.contains(nums[right])) {
                window.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            window.add(nums[right]);
            currentSum += nums[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                window.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
