package LeetCode.Daily_Challenge.Medium.Largest_Divisible_Subset.DP_solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1,2,4,8}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxSize = 1, maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int currentSize = maxSize;
        int currentNum = nums[maxIndex];

        for (int i = maxIndex; i >= 0; i--) {
            if (currentSize > 0 && currentNum % nums[i] == 0 && dp[i] == currentSize) {
                result.add(nums[i]);
                currentNum = nums[i];
                currentSize--;
            }
        }
        return result;
    }
}
