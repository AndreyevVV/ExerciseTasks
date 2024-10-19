package LeetCode.Daily_Challenge.Medium.Find_Kth_Bit_in_Nth_Binary_String;

public class Solution {

    public char findKthBit(int n, int k) {
        return findKthBitHelper(n, k);
    }

    private char findKthBitHelper(int n, int k) {
        if (n == 1)
            return '0';

        int length = (1 << n) - 1;
        int mid = length / 2 + 1;

        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBitHelper(n - 1, k);
        } else {
            char mirroredChar = findKthBitHelper(n - 1, length - k + 1);
            return invert(mirroredChar);
        }
    }

    private char invert(char bit) {
        return bit == '0' ? '1' : '0';
    }
}
