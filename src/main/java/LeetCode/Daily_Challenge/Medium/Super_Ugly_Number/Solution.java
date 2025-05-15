package LeetCode.Daily_Challenge.Medium.Super_Ugly_Number;

public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int k = primes.length;
        int[] indices = new int[k];
        long[] values = new long[k];

        for (int i = 0; i < k; i++)
            values[i] = primes[i];

        for (int i = 1; i < n; i++) {
            long next = Long.MAX_VALUE;

            for (int j = 0; j < k; j++)
                next = Math.min(next, values[j]);

            ugly[i] = (int) next;

            for (int j = 0; j < k; j++) {
                if (values[j] == next) {
                    indices[j]++;
                    values[j] = (long) primes[j] * ugly[indices[j]];
                }
            }
        }

        return ugly[n - 1];
    }
}
