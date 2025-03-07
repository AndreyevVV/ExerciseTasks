package LeetCode.Daily_Challenge.Medium.Closest_Prime_Numbers_in_Range;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.closestPrimes(10, 19);
        System.out.println(result[0] + ", " + result[1]);
    }

    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieve(right);
        List<Integer> primes = new ArrayList<>();

        for (int i = Math.max(left, 2); i <= right; i++)
            if (isPrime[i])
                primes.add(i);

        if (primes.size() < 2) return new int[]{-1, -1};

        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }

        return result;
    }

    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) isPrime[i] = true;

        for (int i = 2; i * i <= n; i++)
            if (isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;

        return isPrime;
    }
}
