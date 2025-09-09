package LeetCode.Daily_Challenge.Medium.Number_of_People_Aware_of_a_Secret;

public class Solution {
    
    static final int MOD = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long sharing = 0;

        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1)
                sharing = (sharing + dp[day - delay]) % MOD;
            if (day - forget >= 1)
                sharing = (sharing - dp[day - forget] + MOD) % MOD;
            dp[day] = sharing;
        }

        long ans = 0;

        for (int i = n - forget + 1; i <= n; i++)
            if (i >= 1) ans = (ans + dp[i]) % MOD;

        return (int) ans;
    }
}
