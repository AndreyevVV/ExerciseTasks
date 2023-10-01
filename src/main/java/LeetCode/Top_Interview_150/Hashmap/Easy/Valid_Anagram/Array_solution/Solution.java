package LeetCode.Top_Interview_150.Hashmap.Easy.Valid_Anagram.Array_solution;

public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sMap = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
            sMap[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (sMap[i] != 0) return false;
        }
        return true;
    }
}
