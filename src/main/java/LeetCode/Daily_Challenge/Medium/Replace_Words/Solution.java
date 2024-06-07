package LeetCode.Daily_Challenge.Medium.Replace_Words;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> roots = new HashSet<>(dictionary);

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String replacement = word;
            for (int j = 1; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                if (roots.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }
            words[i] = replacement;
        }

        return String.join(" ", words);
    }
}
