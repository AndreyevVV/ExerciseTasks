package LeetCode.Daily_Challenge.Easy.Minimum_Bit_Flips_to_Convert_Number;

public class Solution {

    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;

        int count = 0;
        while (xor != 0) {
            count += xor & 1;
            xor >>>= 1;
        }

        return count;
    }
}
