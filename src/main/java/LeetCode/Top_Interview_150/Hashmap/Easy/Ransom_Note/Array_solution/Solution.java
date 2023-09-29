package LeetCode.Top_Interview_150.Hashmap.Easy.Ransom_Note.Array_solution;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];

        for (char c : ransomNote.toCharArray()) {
            int i = c - 'a';
            int amount = map[i];

            int param = magazine.indexOf(c, amount);
            if (param == -1) return false;
            else map[i] = param + 1;
        }
        return true;
    }
}
