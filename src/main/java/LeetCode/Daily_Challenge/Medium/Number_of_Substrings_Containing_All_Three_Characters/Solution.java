package LeetCode.Daily_Challenge.Medium.Number_of_Substrings_Containing_All_Three_Characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numberOfSubstrings(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);

            while (count.size() == 3) {
                result += s.length() - right;
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                if (count.get(s.charAt(left)) == 0)
                    count.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }
}
