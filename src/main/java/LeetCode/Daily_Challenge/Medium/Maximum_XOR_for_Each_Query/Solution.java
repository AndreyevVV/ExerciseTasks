package LeetCode.Daily_Challenge.Medium.Maximum_XOR_for_Each_Query;

public class Solution {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int maxValue = (1 << maximumBit) - 1;
        int[] answer = new int[n];
        int xorSum = 0;

        for (int num : nums)
            xorSum ^= num;

        for (int i = 0; i < n; i++) {
            answer[i] = xorSum ^ maxValue;
            xorSum ^= nums[n - 1 - i];
        }

        return answer;
    }
}
