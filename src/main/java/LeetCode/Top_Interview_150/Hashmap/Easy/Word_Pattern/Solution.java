package LeetCode.Top_Interview_150.Hashmap.Easy.Word_Pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!charToWord.containsKey(c) && !wordToChar.containsKey(word)) {
                charToWord.put(c, word);
                wordToChar.put(word, c);
            } else {
                if (!charToWord.containsKey(c) || !wordToChar.containsKey(word) ||
                        !charToWord.get(c).equals(word) || wordToChar.get(word) != c) {
                    return false;
                }
            }
        }
        return true;
    }
}
