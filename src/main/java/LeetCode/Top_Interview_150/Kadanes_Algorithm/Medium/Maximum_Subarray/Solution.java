package LeetCode.Top_Interview_150.Kadanes_Algorithm.Medium.Maximum_Subarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxCurrent = nums[0], maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }
}
