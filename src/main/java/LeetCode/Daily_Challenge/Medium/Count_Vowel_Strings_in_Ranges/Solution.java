package LeetCode.Daily_Challenge.Medium.Count_Vowel_Strings_in_Ranges;

public class Solution {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + (isVowelString(words[i]) ? 1 : 0);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = prefixSum[r + 1] - prefixSum[l];
        }

        return result;
    }

    private boolean isVowelString(String s) {
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        return isVowel(first) && isVowel(last);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
