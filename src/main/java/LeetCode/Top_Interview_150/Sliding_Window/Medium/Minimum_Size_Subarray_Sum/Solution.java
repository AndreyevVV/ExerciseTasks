package LeetCode.Top_Interview_150.Sliding_Window.Medium.Minimum_Size_Subarray_Sum;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int windowSum = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            windowSum += nums[r];
            while (windowSum >= target) {
                min = Math.min(min, r - l + 1);
                windowSum -= nums[l];
                l++;
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
