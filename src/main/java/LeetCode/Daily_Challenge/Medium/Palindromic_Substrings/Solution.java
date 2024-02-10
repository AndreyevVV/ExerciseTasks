package LeetCode.Daily_Challenge.Medium.Palindromic_Substrings;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int palindromicSubStrCount = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            StringBuilder substring = new StringBuilder();
            for (int j = i; j < length; j++)
                if (isPalindrome(substring.append(s.charAt(j))))palindromicSubStrCount++;
        }
        return palindromicSubStrCount;
    }

    private boolean isPalindrome(StringBuilder s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
}