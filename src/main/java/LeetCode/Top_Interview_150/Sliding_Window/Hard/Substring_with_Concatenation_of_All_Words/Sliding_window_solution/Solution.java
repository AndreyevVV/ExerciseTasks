package LeetCode.Top_Interview_150.Sliding_Window.Hard.Substring_with_Concatenation_of_All_Words.Sliding_window_solution;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        Map<String, Integer> wordMap = Arrays.stream(words).collect(Collectors
                .toMap(Function.identity(), e2 -> 1, (e1, e2) -> e1 + 1, HashMap::new));

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> tempMap = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);

                while (tempMap.getOrDefault(word, 0) > wordMap.getOrDefault(word, 0)) {
                    String leftWord = s.substring(left, left + wordLength);
                    left += wordLength;
                    tempMap.put(leftWord, tempMap.get(leftWord) - 1);
                }

                if (right - left == totalLength)
                    result.add(left);
            }
        }
        return result;
    }
}
