package LeetCode.Top_Interview_150.Bit_Manipulation.Easy.Number_of_1_Bits;

public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
