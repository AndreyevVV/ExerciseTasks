package LeetCode.LeetCode_75_Level_1.Day_1_Prefix_Sum.Easy.Running_Sum_of_1d_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().runningSum(new int[]{1, 2, 3, 4})));
    }

    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
