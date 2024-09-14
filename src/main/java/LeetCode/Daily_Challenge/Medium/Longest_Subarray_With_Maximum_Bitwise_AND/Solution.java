package LeetCode.Daily_Challenge.Medium.Longest_Subarray_With_Maximum_Bitwise_AND;

public class Solution {

    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums)
            maxVal = Math.max(maxVal, num);

        int longest = 0, current = 0;
        for (int num : nums) {
            if (num == maxVal) {
                current++;
                longest = Math.max(longest, current);
            } else
                current = 0;
        }

        return longest;
    }
}
