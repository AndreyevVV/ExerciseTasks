package LeetCode.LeetCode_75_Level_1.Day_2_String.Easy.Is_Subsequence;

public class Solution {

    public boolean isSubsequence(String s, String t) {

        int i = 0, j = 0, sLength = s.length(), tLength = t.length();
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();

        while (i < sLength && j < tLength) {
            if (sChars[i] == tChars[j]) i++;
            j++;
        }
        return i == sLength;
    }
}
