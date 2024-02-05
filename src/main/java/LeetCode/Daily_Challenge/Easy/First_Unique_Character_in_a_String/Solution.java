package LeetCode.Daily_Challenge.Easy.First_Unique_Character_in_a_String;

public class Solution {

    public int firstUniqChar(String s) {
        int[] charCount = new int[26];

        for (char c : s.toCharArray())
            charCount[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
