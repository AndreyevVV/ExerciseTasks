package LeetCode.Top_Interview_150.Array_String.Medium.Jump_Game_II.Greedy_solution;

public class Solution {

    public int jump(int[] nums) {
        int length = nums.length - 1, left = -1, right = 0, count = 0;
        for (int i = 0; right < length; i++) {
            if (i > left) {
                count++;
                left = right;
            }
            right = Math.max(right, nums[i] + i);
        }
        return count;
    }
}
