package LeetCode.Daily_Challenge.Medium.Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition;

import java.util.Arrays;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow2 = new int[n];
        pow2[0] = 1;

        for (int i = 1; i < n; i++)
            pow2[i] = (pow2[i - 1] * 2) % MOD;

        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow2[right - left]) % MOD;
                left++;
            } else
                right--;
        }

        return result;
    }
}
