package LeetCode.Daily_Challenge.Easy.Longest_Palindrome;

public class Solution {

    public int longestPalindrome(String s) {
        int[] freqArray = new int[128];

        for (char c : s.toCharArray())
            freqArray[c]++;

        int result = 0;

        for (int count : freqArray) {
            result += count / 2 * 2;
            if (result % 2 == 0 && count % 2 == 1)
                result += 1;
        }

        return result;
    }
}
