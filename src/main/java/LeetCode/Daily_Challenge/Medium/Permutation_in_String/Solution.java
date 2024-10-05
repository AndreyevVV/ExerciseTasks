package LeetCode.Daily_Challenge.Medium.Permutation_in_String;

public class Solution {
    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";

        boolean result = (new Solution()).checkInclusion(s1, s2);
        System.out.println("Result: " + result);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        if (areArraysEqual(s1Freq, s2Freq))
            return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            s2Freq[s2.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i - s1.length()) - 'a']--;

            if (areArraysEqual(s1Freq, s2Freq))
                return true;
        }

        return false;
    }

    private boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
}
