package LeetCode.Daily_Challenge.Easy.Maximum_Value_of_an_Ordered_Triplet_I;

public class Solution {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = 0;

        int[] maxPrefix = new int[n];
        maxPrefix[0] = nums[0];

        for (int i = 1; i < n; i++)
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);

        for (int j = 1; j < n - 1; j++) {
            int maxSuffix = 0;
            for (int k = j + 1; k < n; k++) {
                maxSuffix = Math.max(maxSuffix, nums[k]);
                maxValue = Math.max(maxValue, (long) (maxPrefix[j - 1] - nums[j]) * maxSuffix);
            }
        }

        return maxValue;
    }
}
