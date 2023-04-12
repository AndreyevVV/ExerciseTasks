package LeetCode.LeetCode_75_Level_1.Sliding_Window_Two_Pointer.Medium.Longest_Repeating_Character_Replacement;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int characterReplacement(String s, int k) {

        if (s.length() == 1) return 1;

        int maxWindowSize = 0, maxCharFreq = 0;
        int leftWindowBorder = 0, rightWindowBorder = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        while (rightWindowBorder < s.length()) {

            char right = s.charAt(rightWindowBorder);
            windowMap.put(right, windowMap.getOrDefault(right, 0) + 1);

            maxCharFreq = Math.max(windowMap.get(right), maxCharFreq);

            if (rightWindowBorder - leftWindowBorder + 1 - maxCharFreq > k) {

                char left = s.charAt(leftWindowBorder++);

                if (windowMap.containsKey(left)) {
                    windowMap.put(left, windowMap.get(left) - 1);
                    if (windowMap.get(left) == 0) windowMap.remove(left);
                }

            }
            maxWindowSize = Math.max(maxWindowSize, rightWindowBorder - leftWindowBorder + 1);
            rightWindowBorder++;
        }
        return maxWindowSize;
    }
}
