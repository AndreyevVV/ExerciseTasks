package LeetCode.Top_Interview_150.Array_String.Medium.Jump_Game.Greedy_solution;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        int length = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) if (nums[i] + i >= length) length = i;
        return length == 0;
    }
}
