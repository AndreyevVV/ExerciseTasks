package LeetCode.Top_Interview_150.Kadanes_Algorithm.Medium.Maximum_Sum_Circular_Subarray.Kadanes_algorithm;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{5,-3,5}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currentMin = 0;

        for (int num : nums) {
            totalSum += num;

            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
        }

        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }
}
