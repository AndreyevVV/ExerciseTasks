package LeetCode.Top_Interview_150.Bit_Manipulation.Medium.Bitwise_AND_of_Numbers_Range;

public class Solution {

    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}
