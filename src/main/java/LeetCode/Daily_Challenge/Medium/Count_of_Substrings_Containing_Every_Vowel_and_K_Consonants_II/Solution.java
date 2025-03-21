package LeetCode.Daily_Challenge.Medium.Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II;

import java.util.Arrays;

public class Solution {

    public long countOfSubstrings(String word, int k) {
        String vowels = "aeiou";
        int left = 0, mid = 0, uniqueVowelCount = 0;
        int[] frequency = new int[6];
        int[] tempFrequency = new int[6];
        long totalSubstrings = 0;

        for (int right = 0; right < word.length(); right++) {
            int vowelIndex = vowels.indexOf(word.charAt(right)) + 1;
            frequency[vowelIndex]++;

            if (vowelIndex > 0 && frequency[vowelIndex] == 1)
                uniqueVowelCount++;

            while (frequency[0] > k) {
                int leftVowelIndex = vowels.indexOf(word.charAt(left)) + 1;
                frequency[leftVowelIndex]--;
                if (leftVowelIndex > 0 && frequency[leftVowelIndex] == 0)
                    uniqueVowelCount--;
                left++;
            }

            if (uniqueVowelCount == 5 && frequency[0] == k) {
                if (mid < left) {
                    mid = left;
                    Arrays.fill(tempFrequency, 0);
                }

                while (mid < word.length()) {
                    int midVowelIndex = vowels.indexOf(word.charAt(mid)) + 1;
                    if (midVowelIndex == 0 || frequency[midVowelIndex] - tempFrequency[midVowelIndex] == 1)
                        break;
                    tempFrequency[midVowelIndex]++;
                    mid++;
                }

                totalSubstrings += mid - left + 1;
            }
        }

        return totalSubstrings;
    }
}
