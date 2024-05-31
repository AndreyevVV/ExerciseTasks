package LeetCode.Daily_Challenge.Medium.Single_Number_III;

public class Solution {

    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums)
            xor ^= num;

        int bitMask = 1;
        while ((bitMask & xor) == 0)
            bitMask <<= 1;

        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & bitMask) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }

        return new int[]{num1, num2};
    }
}
