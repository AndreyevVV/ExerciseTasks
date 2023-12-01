package LeetCode.Top_Interview_150.Sliding_Window.Hard.Substring_with_Concatenation_of_All_Words;

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
                    .toMap(Function.identity(), e2 -> 0, (e1, e2) -> e1 + 1, HashMap::new));

            for (int i = 0; i <= s.length() - totalLength; i++) {
                String subString = s.substring(i, i + totalLength);
                Map<String, Integer> tempMap = new HashMap<>();

                for (int j = 0; j < totalLength; j += wordLength) {
                    String word = subString.substring(j, j + wordLength);
                    tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);
                }

                if (tempMap.equals(wordMap))
                    result.add(i);
            }
            return result;
        }
}
