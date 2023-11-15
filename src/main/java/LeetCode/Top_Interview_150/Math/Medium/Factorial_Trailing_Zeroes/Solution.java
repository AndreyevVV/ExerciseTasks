package LeetCode.Top_Interview_150.Math.Medium.Factorial_Trailing_Zeroes;

public class Solution {

    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}
