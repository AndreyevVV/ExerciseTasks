package LeetCode.LeetCode_75_Level_2.Day_5_Greedy.Longest_Palindrome_by_Concatenating_Two_Letter_Words;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        boolean flag = true;
        int len = 0;

        for (String str : map.keySet()) {

            if (str.charAt(0) != str.charAt(1)) {

                StringBuilder s = new StringBuilder(str);
                char temp = s.charAt(0);

                s.setCharAt(0, s.charAt(1));
                s.setCharAt(1, temp);

                String a = s.toString();

                if (map.containsKey(a)) {
                    int c = Math.min(map.get(str), map.get(a));
                    len += 2 * c;
                }
            } else {
                if ((map.get(str) & 1) == 0) {
                    if (flag) {
                        len += map.get(str) * 2;
                        flag = false;
                    } else {
                        len += (map.get(str) - 1) * 2;
                    }
                } else {
                    len += (map.get(str)) * 2;
                }
            }
        }
        return len;
    }
}
