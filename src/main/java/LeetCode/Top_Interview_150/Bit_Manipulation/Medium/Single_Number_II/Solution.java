package LeetCode.Top_Interview_150.Bit_Manipulation.Medium.Single_Number_II;

import java.util.Arrays;
import java.util.OptionalInt;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{1, 2, 1, 2, 1, 2, 99}));
    }

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;

            for (int num : nums)
                sum += (num >> i) & 1;

            if (sum % 3 != 0)
                result |= (1 << i);
        }
        return result;
    }
}
