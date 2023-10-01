package LeetCode.Top_Interview_150.Hashmap.Easy.Valid_Anagram;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> sMap = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), value -> 1, (e1, e2) -> e1 + 1, HashMap::new));
        Map<Character, Integer> tMap = t.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), value -> 1, (e1, e2) -> e1 + 1, HashMap::new));

        return sMap.equals(tMap);
    }
}
