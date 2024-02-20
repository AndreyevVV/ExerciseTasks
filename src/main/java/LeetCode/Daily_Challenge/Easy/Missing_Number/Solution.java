package LeetCode.Daily_Challenge.Easy.Missing_Number;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int missingNumber = nums.length;

        for (int i = 0; i < nums.length; i++)
            missingNumber ^= i ^ nums[i];

        return missingNumber;
    }
}
