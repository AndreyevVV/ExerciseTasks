package LeetCode.Daily_Challenge.Medium.Append_Characters_to_String_to_Make_Subsequence;

public class Solution {

    public int appendCharacters(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int i = 0, j = 0;

        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j))
                j++;
            i++;
        }

        return tLen - j;
    }
}
