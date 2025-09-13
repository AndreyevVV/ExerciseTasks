package LeetCode.Daily_Challenge.Easy.Find_Most_Frequent_Vowel_and_Consonant;

import java.util.Set;

public class Solution {
    
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int maxVowel = 0, maxConsonant = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            char c = (char) ('a' + i);
            if (vowels.contains(c))
                maxVowel = Math.max(maxVowel, freq[i]);
            else
                maxConsonant = Math.max(maxConsonant, freq[i]);
        }

        return maxVowel + maxConsonant;
    }
}
