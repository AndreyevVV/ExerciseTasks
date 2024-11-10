package LeetCode.Daily_Challenge.Medium.Shortest_Subarray_With_OR_at_Least_K_II;

public class Solution {

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bitCount = new int[32];
        int start = 0, minLength = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            updateBits(bitCount, nums[end], 1);

            while (start <= end && calculateOrValue(bitCount) >= k) {
                minLength = Math.min(minLength, end - start + 1);
                updateBits(bitCount, nums[start], -1);
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private void updateBits(int[] bitCount, int num, int delta) {
        for (int i = 0; i < 32; i++)
            if ((num & (1 << i)) != 0)
                bitCount[i] += delta;
    }

    private int calculateOrValue(int[] bitCount) {
        int orValue = 0;
        for (int i = 0; i < 32; i++)
            if (bitCount[i] > 0)
                orValue |= (1 << i);
        return orValue;
    }
}
