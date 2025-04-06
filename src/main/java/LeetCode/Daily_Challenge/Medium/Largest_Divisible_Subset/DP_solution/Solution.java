package LeetCode.Daily_Challenge.Medium.Largest_Divisible_Subset.DP_solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex])
                maxIndex = i;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            result.add(nums[i]);
            if (prev[i] == -1) break;
        }

        Collections.reverse(result);
        return result;
    }
}
