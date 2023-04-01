package LeetCode.LeetCode_75_Level_1.Day_5_Greedy.Easy.Longest_Palindrome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public int longestPalindrome(String s) {

        int length = s.length();

        Map<Character, Integer> map = s.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(Function.identity(),
                e2 -> 0, (e1, e2) -> e1, HashMap::new));

        s.chars().mapToObj(c -> (char) c).forEach(character -> map.computeIfPresent(character, (k, v) -> v + 1));

        int oddCount = (int) map.values()
                .stream()
                .filter(integer -> integer % 2 != 0)
                .count();

        return oddCount > 0? length - oddCount + 1: length;
    }
}
