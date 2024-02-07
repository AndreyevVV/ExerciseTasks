package LeetCode.Daily_Challenge.Medium.Sort_Characters_By_Frequency;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree"));
    }

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";

        Map<Character, Integer> map = s.chars().mapToObj(c -> (char) c).collect(Collectors
                .toMap(Function.identity(), value -> 1, (e1, e2) -> e1 + 1, HashMap::new));

        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        queue.addAll(map.entrySet());

        StringBuilder sortedString = new StringBuilder();

        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            sortedString.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }

        return sortedString.toString();
    }
}
