package LeetCode.Daily_Challenge.Hard.Shortest_Palindrome;

public class Solution {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;

        String rev = new StringBuilder(s).reverse().toString();
        String newStr = s + "#" + rev;

        int[] lps = kmpProcess(newStr);

        int palindromeLength = lps[lps.length - 1];

        return rev.substring(0, s.length() - palindromeLength) + s;
    }

    private int[] kmpProcess(String str) {
        int[] lps = new int[str.length()];
        int j = 0;

        for (int i = 1; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = lps[j - 1];

            if (str.charAt(i) == str.charAt(j))
                j++;

            lps[i] = j;
        }

        return lps;
    }
}
