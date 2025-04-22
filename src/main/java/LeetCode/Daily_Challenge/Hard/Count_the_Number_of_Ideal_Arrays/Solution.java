package LeetCode.Daily_Challenge.Hard.Count_the_Number_of_Ideal_Arrays;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static final int MOD = 1_000_000_007;
    static final int MAX = 10010;

    long[] fact = new long[MAX];
    long[] invFact = new long[MAX];

    public int idealArrays(int n, int maxValue) {
        precomputeFactorials();

        int maxLen = (int) (Math.log(maxValue) / Math.log(2)) + 1;
        Map<Integer, int[]> dp = new HashMap<>();

        for (int v = 1; v <= maxValue; v++) {
            int[] count = new int[maxLen + 1];
            count[1] = 1;
            dp.put(v, count);
        }

        for (int i = 1; i <= maxValue; i++) {
            int[] base = dp.get(i);
            for (int mult = 2; i * mult <= maxValue; mult++) {
                int[] next = dp.get(i * mult);
                for (int len = 1; len < maxLen; len++)
                    next[len + 1] = (int) ((next[len + 1] + base[len]) % MOD);
            }
        }

        long res = 0;
        for (int[] counts : dp.values()) {
            for (int len = 1; len <= maxLen; len++) {
                long ways = counts[len];
                if (ways == 0) continue;
                long comb = combination(n - 1, len - 1);
                res = (res + ways * comb % MOD) % MOD;
            }
        }

        return (int) res;
    }

    private void precomputeFactorials() {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++)
            fact[i] = fact[i - 1] * i % MOD;
        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 1; i--)
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    private long combination(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
