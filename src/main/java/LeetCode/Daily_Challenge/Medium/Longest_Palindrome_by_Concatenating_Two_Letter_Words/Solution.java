package LeetCode.Daily_Challenge.Medium.Longest_Palindrome_by_Concatenating_Two_Letter_Words;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words)
            count.put(word, count.getOrDefault(word, 0) + 1);

        int length = 0;
        boolean centerUsed = false;

        for (String word : count.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();
            int freq = count.get(word);

            if (word.equals(rev)) {
                int pairs = freq / 2;
                length += pairs * 4;
                if (freq % 2 == 1 && !centerUsed) {
                    length += 2;
                    centerUsed = true;
                }
            } else if (word.compareTo(rev) < 0 && count.containsKey(rev)) {
                int pairs = Math.min(freq, count.get(rev));
                length += pairs * 4;
            }
        }

        return length;
    }
}
