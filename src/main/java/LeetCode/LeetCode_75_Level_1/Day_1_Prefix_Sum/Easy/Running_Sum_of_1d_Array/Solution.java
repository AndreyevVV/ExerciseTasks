package LeetCode.LeetCode_75_Level_1.Day_1_Prefix_Sum.Easy.Running_Sum_of_1d_Array;

public class Solution {

    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
