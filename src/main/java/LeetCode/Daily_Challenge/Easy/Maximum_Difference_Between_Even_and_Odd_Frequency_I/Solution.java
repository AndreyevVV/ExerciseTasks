package LeetCode.Daily_Challenge.Easy.Maximum_Difference_Between_Even_and_Odd_Frequency_I;

public class Solution {

    public int maxDifference(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < 26; i++)
            if (freq[i] % 2 == 1)
                for (int j = 0; j < 26; j++)
                    if (freq[j] > 0 && freq[j] % 2 == 0)
                        maxDiff = Math.max(maxDiff, freq[i] - freq[j]);

        return maxDiff == Integer.MIN_VALUE ? 0 : maxDiff;
    }
}
