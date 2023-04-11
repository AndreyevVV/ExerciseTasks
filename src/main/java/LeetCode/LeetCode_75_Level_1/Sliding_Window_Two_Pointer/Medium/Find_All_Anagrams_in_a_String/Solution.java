package LeetCode.LeetCode_75_Level_1.Sliding_Window_Two_Pointer.Medium.Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> indexes = new ArrayList<>();

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int leftWindowBorder = 0, rightWindowBorder = 0;

        while (rightWindowBorder < s.length()) {

            char right = s.charAt(rightWindowBorder++);

            windowMap.put(right, windowMap.getOrDefault(right, 0) + 1);

            if (pMap.equals(windowMap)) indexes.add(leftWindowBorder);

            if (rightWindowBorder - leftWindowBorder == p.length()) {

                char left = s.charAt(leftWindowBorder++);

                if (windowMap.containsKey(left)) {
                    windowMap.put(left, windowMap.get(left) - 1);
                    if (windowMap.get(left) == 0) windowMap.remove(left);
                }
            }
        }
        return indexes;
    }
}
