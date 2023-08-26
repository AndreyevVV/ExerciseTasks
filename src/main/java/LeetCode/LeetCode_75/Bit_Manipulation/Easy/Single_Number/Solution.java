package LeetCode.LeetCode_75.Bit_Manipulation.Easy.Single_Number;

import java.util.Arrays;

public class Solution {

    public int singleNumber(int[] nums) {
        return (Arrays.stream(nums).reduce((a, b) -> a ^ b)).getAsInt();
    }
}
