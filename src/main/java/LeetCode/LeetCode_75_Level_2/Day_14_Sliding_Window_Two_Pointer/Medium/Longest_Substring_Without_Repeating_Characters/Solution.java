package LeetCode.LeetCode_75_Level_2.Day_14_Sliding_Window_Two_Pointer.Medium.Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        if (s.length() == 1) return 1;

        int r = 0, l = 0, substringMaxSize = 0;
        Set<Character> set = new HashSet<>();

        while ( r < s.length()) {
            char symbol = s.charAt(r);
            if (set.add(symbol)) {
                r++;
                substringMaxSize = Math.max(set.size(), substringMaxSize);
            } else {
            set.clear();
            r = l++;
            }
        }
        return substringMaxSize;
    }
}
