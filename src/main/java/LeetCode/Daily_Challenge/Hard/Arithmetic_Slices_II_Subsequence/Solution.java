package LeetCode.Daily_Challenge.Hard.Arithmetic_Slices_II_Subsequence;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{0,2000000000,-294967296}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;

        HashMap<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                int count = dp[j].getOrDefault(diff, 0);
                result += count;

                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + count + 1);
            }
        }
        return result;
    }
}
