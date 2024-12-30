package LeetCode.Daily_Challenge.Medium.Count_Ways_To_Build_Good_Strings;

public class Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        int result = 0;

        for (int length = 1; length <= high; length++) {
            if (length >= zero)
                dp[length] = (dp[length] + dp[length - zero]) % MOD;

            if (length >= one)
                dp[length] = (dp[length] + dp[length - one]) % MOD;

            if (length >= low)
                result = (result + dp[length]) % MOD;
        }

        return result;
    }
}
