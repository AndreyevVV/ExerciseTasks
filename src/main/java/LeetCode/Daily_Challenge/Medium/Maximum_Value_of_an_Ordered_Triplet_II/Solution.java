package LeetCode.Daily_Challenge.Medium.Maximum_Value_of_an_Ordered_Triplet_II;

public class Solution {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTripletValue = 0;

        int maxPrefix = nums[0];

        int[] maxDiff = new int[n];
        maxDiff[1] = Integer.MIN_VALUE;

        for (int j = 1; j < n - 1; j++) {
            maxDiff[j] = Math.max(maxDiff[j - 1], maxPrefix - nums[j]);
            maxPrefix = Math.max(maxPrefix, nums[j]);
        }

        for (int k = 2; k < n; k++)
            if (maxDiff[k - 1] != Integer.MIN_VALUE)
                maxTripletValue = Math.max(maxTripletValue, (long) maxDiff[k - 1] * nums[k]);

        return maxTripletValue;
    }
}
