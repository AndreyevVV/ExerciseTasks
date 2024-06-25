package LeetCode.Daily_Challenge.Hard.Minimum_Number_of_K_Consecutive_Bit_Flips;

public class Solution {

    public int minKBitFlips(int[] nums, int k) {
        int currentFlips = 0;
        int result = 0;
        boolean[] flipped = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && flipped[i - k])
                currentFlips--;

            if (currentFlips % 2 == nums[i]) {
                if (i + k > nums.length)
                    return -1;

                currentFlips++;
                flipped[i] = true;
                result++;
            }
        }
        return result;
    }
}
