package LeetCode.Daily_Challenge.Medium.Count_Good_Numbers;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPower = modPow(5, evenCount, MOD);
        long oddPower = modPow(4, oddCount, MOD);

        return (int) ((evenPower * oddPower) % MOD);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}
