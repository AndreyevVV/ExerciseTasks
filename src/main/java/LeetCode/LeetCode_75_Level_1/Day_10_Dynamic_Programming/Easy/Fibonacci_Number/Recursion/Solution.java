package LeetCode.LeetCode_75_Level_1.Day_10_Dynamic_Programming.Easy.Fibonacci_Number.Recursion;

public class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        else return fib(n - 1) + fib(n - 2);
    }
}
