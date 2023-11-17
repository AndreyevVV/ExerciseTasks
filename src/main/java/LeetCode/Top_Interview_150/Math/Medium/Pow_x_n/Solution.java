package LeetCode.Top_Interview_150.Math.Medium.Pow_x_n;

public class Solution {
    public static void main(String[] args) {
        double x = 2.0000;
        int n = -2147483648;
        System.out.println("Результат: " + myPow(x, n));
    }
    public static double myPow(double x, int n) {
        if (n == 0) return 1;

        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                x *= x;
                n /= 2;
            }
            n = -n;
        }

        double result = 1.0;
        while (n > 0) {
            if (n % 2 == 1)
                result *= x;
            x *= x;
            n >>>= 1;
        }
        return result;
    }
}
