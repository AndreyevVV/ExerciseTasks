package LeetCode.Daily_Challenge.Medium.Total_Characters_in_String_After_Transformations_I;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];

        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        while (t-- > 0) {
            long[] next = new long[26];

            for (int i = 0; i < 26; i++) {
                if (i == 25) {
                    next[0] = (next[0] + freq[25]) % MOD;
                    next[1] = (next[1] + freq[25]) % MOD;
                } else
                    next[i + 1] = (next[i + 1] + freq[i]) % MOD;
            }

            freq = next;
        }

        long total = 0;
        for (int i = 0; i < 26; i++)
            total = (total + freq[i]) % MOD;

        return (int) total;
    }
}
