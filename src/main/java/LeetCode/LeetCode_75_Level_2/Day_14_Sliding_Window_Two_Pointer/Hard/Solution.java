package LeetCode.LeetCode_75_Level_2.Day_14_Sliding_Window_Two_Pointer.Hard;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        String ans = "";
        int i = -1;
        int j = -1;
        int matchCount = 0;
        int reqCount = t.length();
        Map<Character, Integer> map2 = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        ;

        for (char character : t.toCharArray()) {
            map2.put(character, map2.getOrDefault(character, 0) + 1);
        }

        while (true) {

            boolean matchCondition = false;

            while (i < s.length() - 1 && matchCount < reqCount) {
                i++;
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) matchCount++;
                matchCondition = true;
            }

            while (j < i && matchCount == reqCount) {

                String pans = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || pans.length() < ans.length()) ans = pans;

                j++;
                char ch = s.charAt(j);
                if (map1.get(ch) == 1) map1.remove(ch);
                else map1.put(ch, map1.get(ch) - 1);

                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    matchCount--;
                }
            }
            if (!matchCondition) break;
        }
        return ans;
    }
}
