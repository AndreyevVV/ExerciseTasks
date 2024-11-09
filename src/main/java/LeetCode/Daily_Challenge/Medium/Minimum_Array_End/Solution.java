package LeetCode.Daily_Challenge.Medium.Minimum_Array_End;

public class Solution {

    public long minEnd(int n, int x) {
        long result = x;
        long remaining = n - 1;
        long bit = 1;

        while (remaining > 0) {
            if ((x & bit) == 0) {
                result |= (remaining & 1) * bit;
                remaining >>= 1;
            }
            bit <<= 1;
        }

        return result;
    }
}
