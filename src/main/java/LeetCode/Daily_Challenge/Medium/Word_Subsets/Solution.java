package LeetCode.Daily_Challenge.Medium.Word_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];

        for (String word : words2) {
            int[] freq = getCharFrequency(word);
            for (int i = 0; i < 26; i++)
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
        }

        List<String> result = new ArrayList<>();

        for (String word : words1) {
            int[] freq = getCharFrequency(word);
            if (isUniversal(freq, maxFreq))
                result.add(word);
        }

        return result;
    }

    private int[] getCharFrequency(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray())
            freq[c - 'a']++;
        return freq;
    }

    private boolean isUniversal(int[] freq, int[] maxFreq) {
        for (int i = 0; i < 26; i++)
            if (freq[i] < maxFreq[i])
                return false;
        return true;
    }
}
