package LeetCode.Daily_Challenge.Easy.Uncommon_Words_from_Two_Sentences;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words = (s1 + " " + s2).split(" ");

        Map<String, Integer> wordCount = new HashMap<>();
        for(String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet())
            if (entry.getValue() == 1)
                result.add(entry.getKey());

        return result.toArray(new String[]{});
    }
}
