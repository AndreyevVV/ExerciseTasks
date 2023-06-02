package LeetCode.LeetCode_75_Level_2.Day_13_Dynamic_Programming.Medium.Partition_Equal_Subset_Sum.Dynamic_Programming_solution;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) sum += num;

        if ((sum & 1) == 1) return false;

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum];
    }
}
