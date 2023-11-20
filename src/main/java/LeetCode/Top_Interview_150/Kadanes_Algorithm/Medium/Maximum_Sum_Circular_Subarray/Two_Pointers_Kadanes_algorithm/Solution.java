package LeetCode.Top_Interview_150.Kadanes_Algorithm.Medium.Maximum_Sum_Circular_Subarray.Two_Pointers_Kadanes_algorithm;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{5, -3, 5}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxGlobal = nums[0];
        int length = nums.length;

        for (int l = 0, r = length - 1; r < length * 2; l++, r++) {
            int maxCurrent = nums[l % length];
            int currentSum = nums[l % length];

            for (int j = l + 1; j <= r; j++) {
                currentSum = Math.max(nums[j % length], currentSum + nums[j % length]);
                maxCurrent = Math.max(maxCurrent, currentSum);
            }
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }
}
