package LeetCode.LeetCode_75_Level_2.Day_5_Greedy.Longest_Palindrome_by_Concatenating_Two_Letter_Words;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome(new String[]{"lc", "cl", "gg"}));
    }

    public int longestPalindrome(String[] words) {

        Hashtable<String, Integer> ht = new Hashtable<>();

        int count = 0;
        int nonCount = 0;
        int oddCount = 0;
        int result = 0;
        String plMaxStr = "";

        for (String word : words) {
            ht.put(word, ht.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> m : ht.entrySet()) {

            char[] charArr = m.getKey().toCharArray();

            if (charArr[0] == charArr[1]) {
                if (ht.get(m.getKey()) % 2 != 0 && ht.get(m.getKey()) > oddCount) {
                    oddCount = ht.get(m.getKey()) * 2;
                    plMaxStr = m.getKey();
                }
            }
        }

        for (Map.Entry<String, Integer> m : ht.entrySet()) {

            if (m.getKey().equals(plMaxStr)) continue;

            char[] charArr = m.getKey().toCharArray();

            if (charArr[0] == charArr[1]) {
                count += m.getValue() % 2 == 0 ? m.getValue() * 2 : (m.getValue() - 1) * 2;
            } else {
                String reverse = charArr[1] + "" + charArr[0];
                if (ht.containsKey(reverse)) {
                    nonCount += Math.min(ht.get(reverse), m.getValue()) * 2;
                }
            }
        }
        result = nonCount + count + oddCount;
        return result;
    }
}
