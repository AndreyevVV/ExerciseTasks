package LeetCode.Daily_Challenge.Medium.Longest_Binary_Subsequence_Less_Than_or_Equal_to_K;

public class Solution {

    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        long value = 0;
        int power = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (power < 32 && value + (1L << power) <= k) {
                    value += (1L << power);
                    count++;
                }
            } else
                count++;
            power++;
        }

        return count;
    }
}
