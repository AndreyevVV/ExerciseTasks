package LeetCode.LeetCode_75_Level_1.Day_10_Dynamic_Programming.Fibonacci_Number.Dynamic;

public class Solution {

    public int fib(int n) {

        if (n < 2) return n;

        int[] f = new int[n];

        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n - 1];
    }
}
