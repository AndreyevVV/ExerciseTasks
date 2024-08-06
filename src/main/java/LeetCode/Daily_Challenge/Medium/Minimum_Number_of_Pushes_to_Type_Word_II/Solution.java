package LeetCode.Daily_Challenge.Medium.Minimum_Number_of_Pushes_to_Type_Word_II;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public int minimumPushes(String word) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : word.toCharArray())
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

        PriorityQueue<Integer> freqHeap = new PriorityQueue<>((a, b) -> b - a);
        freqHeap.addAll(charCount.values());

        int totalPresses = 0;
        int keyPosition = 0;

        while (!freqHeap.isEmpty()) {
            totalPresses += (keyPosition / 8 + 1) * freqHeap.poll();
            keyPosition++;
        }

        return totalPresses;
    }
}
