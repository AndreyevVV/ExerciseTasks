package LeetCode.Top_Interview_150.Math.Easy.Sqrt_x.Newton_method;

public class Solution {

    public int mySqrt(int x) {
        double n = 1;
        double eps = 1E-15;

        while (true) {
            double nx = (n + x / n) / 2;
            if (Math.abs(n - nx) < eps) break;
            n = nx;
        }
        return (int) n;
    }
}
