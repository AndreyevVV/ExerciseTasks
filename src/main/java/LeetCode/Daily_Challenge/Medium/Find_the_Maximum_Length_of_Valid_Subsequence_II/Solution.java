package LeetCode.Daily_Challenge.Medium.Find_the_Maximum_Length_of_Valid_Subsequence_II;

public class Solution {

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return n;

        int res = 1;
        int[] mods = new int[n];

        for (int i = 0; i < n; i++)
            mods[i] = nums[i] % k;

        for (int r = 0; r < k; r++) {
            int[] dp = new int[k];
            for (int mod : mods) {
                int prev = (r - mod + k) % k;
                dp[mod] = dp[prev] + 1;
                res = Math.max(res, dp[mod]);
            }
        }
        return res;
    }
}
