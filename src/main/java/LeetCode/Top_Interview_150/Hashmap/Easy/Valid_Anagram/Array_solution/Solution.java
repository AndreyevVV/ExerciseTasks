package LeetCode.Top_Interview_150.Hashmap.Easy.Valid_Anagram.Array_solution;

public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sMap = new int[26];

        for (char c : t.toCharArray()) {
            int i = c - 'a';
            int amount = sMap[i];

            int param = s.indexOf(c, amount);
            if (param == -1) return false;
            else sMap[i] = param + 1;
        }
        return true;
    }
}
