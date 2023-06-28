package LeetCode.Recursion_I.Complexity_analysis.Pow_x_n;

public class Solution {

    public double myPow(double x, int n) {
        if (n == 0) return 1;

        if (n % 2 == 1) return x * myPow(x, n - 1);
        else if (n % 2 == 0) return myPow(x * x, n / 2);

        return 1 / myPow(x, -n);
    }
}
