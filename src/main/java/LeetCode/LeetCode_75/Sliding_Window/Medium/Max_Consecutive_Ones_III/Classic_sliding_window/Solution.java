package LeetCode.LeetCode_75.Sliding_Window.Medium.Max_Consecutive_Ones_III.Classic_sliding_window;

public class Solution {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int countZeros = 0;

        while (right < nums.length) {
            if (nums[right] == 0) countZeros++;
            right++;
            if (countZeros > k) {
                if (nums[left] == 0) countZeros--;
                left++;
            }
        }
        return right - left;
    }
}
