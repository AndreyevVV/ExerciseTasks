package LeetCode.Daily_Challenge.Medium.Find_Longest_Special_Substring_That_Occurs_Thrice_I;

import java.util.HashMap;

public class Solution {

    public int maximumLength(String s) {
        int n = s.length();
        int left = 1, right = n, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasSpecialSubstring(s, mid)) {
                result = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return result;
    }

    private boolean hasSpecialSubstring(String s, int length) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i <= s.length() - length; i++) {
            String substring = s.substring(i, i + length);
            if (isSpecial(substring)) {
                countMap.put(substring, countMap.getOrDefault(substring, 0) + 1);
                if (countMap.get(substring) >= 3)
                    return true;
            }
        }
        return false;
    }

    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray())
            if (c != firstChar)
                return false;
        return true;
    }
}
