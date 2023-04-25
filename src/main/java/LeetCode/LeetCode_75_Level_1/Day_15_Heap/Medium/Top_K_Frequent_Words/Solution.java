package LeetCode.LeetCode_75_Level_1.Day_15_Heap.Medium.Top_K_Frequent_Words;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freqMap = Arrays.stream(words).collect(Collectors
                .toMap(Function.identity(), v -> 0, (k1, k2) -> k1, LinkedHashMap::new));

        Arrays.stream(words).forEach(i -> freqMap.computeIfPresent(i, (key, value) -> value + 1));

        Comparator<Map.Entry<String, Integer>> comparator = (entry1, entry2) -> {

            int freqOrder = entry2.getValue() - entry1.getValue();

            if (freqOrder == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            } else return freqOrder;
        };

        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(comparator);

        queue.addAll(freqMap.entrySet());

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            answer.add(queue.remove().getKey());
        }
        return answer;
    }
}
