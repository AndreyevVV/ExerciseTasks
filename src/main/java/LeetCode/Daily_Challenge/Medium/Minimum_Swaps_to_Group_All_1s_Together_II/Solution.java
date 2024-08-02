package LeetCode.Daily_Challenge.Medium.Minimum_Swaps_to_Group_All_1s_Together_II;

public class Solution {

    public int minSwaps(int[] nums) {
        int n = nums.length;

        int totalOnes = 0;
        for (int num : nums)
            if (num == 1) totalOnes++;

        if (totalOnes == 0 || totalOnes == n) return 0;

        int[] extended = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            extended[i] = nums[i % n];

        int minSwaps = Integer.MAX_VALUE;
        int currentZeroCount = 0;

        for (int i = 0; i < totalOnes; i++)
            if (extended[i] == 0) currentZeroCount++;

        minSwaps = Math.min(minSwaps, currentZeroCount);

        for (int i = totalOnes; i < 2 * n; i++) {
            if (extended[i - totalOnes] == 0) currentZeroCount--;

            if (extended[i] == 0) currentZeroCount++;

            minSwaps = Math.min(minSwaps, currentZeroCount);
        }

        return minSwaps;
    }
}
