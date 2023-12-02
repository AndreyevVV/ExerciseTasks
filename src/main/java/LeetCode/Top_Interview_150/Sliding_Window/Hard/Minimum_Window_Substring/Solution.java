package LeetCode.Top_Interview_150.Sliding_Window.Hard.Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int requiredChars = targetMap.size();
        int formedChars = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if (targetMap.containsKey(currentChar) && windowMap.get(currentChar).intValue() == targetMap.get(currentChar).intValue()) {
                formedChars++;
            }

            while (formedChars == requiredChars) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formedChars--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
