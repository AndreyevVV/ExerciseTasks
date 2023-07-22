package LeetCode.LeetCode_75.Hash_Map_Set.Medium.Determine_if_Two_Strings_Are_Close;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().closeStrings("aaabbbbcccddddeeeefffff", "aaaaabbbcccdddeeeefffff"));
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) return false;

        Map<Character, Integer> word1Map = word1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), value -> 1
                        , (entry1, entry2) -> entry1 + 1, HashMap::new));

        Map<Character, Integer> word2Map = word2.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), value -> 1
                        , (entry1, entry2) -> entry1 + 1, HashMap::new));

        boolean alphabetsCountAdequation = word1Map.values().stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).equals(
                word2Map.values().stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())));

        return word1Map.keySet().equals(word2Map.keySet()) && alphabetsCountAdequation;
    }
}
