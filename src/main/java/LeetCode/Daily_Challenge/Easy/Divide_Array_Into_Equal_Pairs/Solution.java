package LeetCode.Daily_Challenge.Easy.Divide_Array_Into_Equal_Pairs;

import java.util.Arrays;

public class Solution {

    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2)
            if (nums[i] != nums[i + 1])
                return false;
        return true;
    }
}
