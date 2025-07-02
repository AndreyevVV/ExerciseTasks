package LeetCode.Daily_Challenge.Hard.Find_the_Original_Typed_String_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int possibleStringCount(String word, int k) {
        if (word.isEmpty()) return 0;

        List<Integer> groups = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count);

        long totalWays = 1;
        for (int len : groups)
            totalWays = (totalWays * len) % MOD;

        if (k <= groups.size()) return (int) totalWays;

        int[] dp = new int[k];
        dp[0] = 1;

        for (int len : groups) {
            int[] newDp = new int[k];
            long windowSum = 0;
            for (int i = 0; i < k; i++) {
                if (i > 0) windowSum = (windowSum + dp[i - 1]) % MOD;
                if (i > len) windowSum = (windowSum - dp[i - len - 1] + MOD) % MOD;
                newDp[i] = (int) windowSum;
            }
            dp = newDp;
        }

        long invalidWays = 0;
        for (int i = groups.size(); i < k; i++)
            invalidWays = (invalidWays + dp[i]) % MOD;

        return (int) ((totalWays - invalidWays + MOD) % MOD);
    }
}
