package LeetCode.Daily_Challenge.Medium.Minimum_Increment_to_Make_Array_Unique;

import java.util.Arrays;

public class Solution {

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int newVal = nums[i - 1] + 1;
                moves += newVal - nums[i];
                nums[i] = newVal;
            }
        }
        return moves;
    }
}
