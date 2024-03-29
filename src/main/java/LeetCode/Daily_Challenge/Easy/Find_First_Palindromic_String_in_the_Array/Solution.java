package LeetCode.Daily_Challenge.Easy.Find_First_Palindromic_String_in_the_Array;

public class Solution {

    public String firstPalindrome(String[] words) {
        if (words == null || words.length == 0) return "";

        for (String s : words)
            if (isPalindrome(s)) return s;

        return "";
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
}
