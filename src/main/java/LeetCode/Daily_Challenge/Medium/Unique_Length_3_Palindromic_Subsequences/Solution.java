package LeetCode.Daily_Challenge.Medium.Unique_Length_3_Palindromic_Subsequences;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int countPalindromicSubsequence(String s) {
        Set<String> uniquePalindromes = new HashSet<>();
        int n = s.length();

        for (char c = 'a'; c <= 'z'; c++) {
            int first = -1;
            int last = -1;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == c) {
                    if (first == -1) first = i;
                    last = i;
                }
            }

            if (first != -1 && last != -1 && last > first) {
                Set<Character> middleChars = new HashSet<>();
                for (int i = first + 1; i < last; i++)
                    middleChars.add(s.charAt(i));

                for (char mid : middleChars)
                    uniquePalindromes.add("" + c + mid + c);
            }
        }

        return uniquePalindromes.size();
    }
}
