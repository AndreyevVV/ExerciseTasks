package LeetCode.Top_Interview_150.Array_String.Easy.Majority_Element;

import java.util.Arrays;

public class Solution {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
