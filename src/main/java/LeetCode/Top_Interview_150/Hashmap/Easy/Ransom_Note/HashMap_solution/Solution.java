package LeetCode.Top_Interview_150.Hashmap.Easy.Ransom_Note.HashMap_solution;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = magazine.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), value -> 1, (e1, e2) -> e1 + 1, HashMap::new));

        for (char character : ransomNote.toCharArray()) {
            Integer param = magazineMap.computeIfPresent(character, (k, v) -> v - 1);
            if (param == null || param < 0) return false;
        }
        return true;
    }
}
