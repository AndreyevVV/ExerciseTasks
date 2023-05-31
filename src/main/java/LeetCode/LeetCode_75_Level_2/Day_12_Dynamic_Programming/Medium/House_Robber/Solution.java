package LeetCode.LeetCode_75_Level_2.Day_12_Dynamic_Programming.Medium.House_Robber;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        int[] exc = new int[nums.length];
        exc[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                exc[i] = Math.max(nums[i], exc[i - 1]);
            } else {
                exc[i] = Math.max(nums[i] + exc[i - 2], exc[i - 1]);
            }
        }
        return exc[nums.length - 1];
    }
}
