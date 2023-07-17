package LeetCode.LeetCode_75.Sliding_Window.Medium.Max_Consecutive_Ones_III.Classic_sliding_window;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

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
