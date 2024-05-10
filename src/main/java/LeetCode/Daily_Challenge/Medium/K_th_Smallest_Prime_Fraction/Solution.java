package LeetCode.Daily_Challenge.Medium.K_th_Smallest_Prime_Fraction;

public class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0, right = 1;

        int[] result = new int[2];
        while (true) {
            double mid = (left + right) / 2;
            double maxFraction = 0;
            int count = 0;
            int j = 1;

            for (int i = 0; i < n - 1; i++) {
                while (j < n && arr[i] >= arr[j] * mid) j++;
                count += n - j;
                if (j < n) {
                    double fraction = (double) arr[i] / arr[j];
                    if (fraction > maxFraction) {
                        maxFraction = fraction;
                        result[0] = arr[i];
                        result[1] = arr[j];
                    }
                }
            }

            if (count == k)
                return result;
            else if (count < k)
                left = mid;
            else
                right = mid;
        }
    }
}