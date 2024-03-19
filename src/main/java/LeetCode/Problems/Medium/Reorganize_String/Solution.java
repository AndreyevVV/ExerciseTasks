package LeetCode.Problems.Medium.Reorganize_String;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.freq - p1.freq);

        for (Map.Entry<Character, Integer> e : map.entrySet())
            maxHeap.offer(new Pair(e.getKey(), e.getValue()));

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();

            if (sb.length() == 0 || p.c != sb.charAt(sb.length() - 1)) {
                sb.append(p.c);
                if (p.freq > 1)
                    maxHeap.offer(new Pair(p.c, p.freq - 1));
                continue;
            }

            if (maxHeap.isEmpty())
                return "";

            Pair p2 = maxHeap.poll();
            sb.append(p2.c);

            if (p2.freq > 1)
                maxHeap.offer(new Pair(p2.c, p2.freq - 1));

            maxHeap.offer(p);
        }
        return sb.toString();
    }

    private class Pair {
        char c;
        int freq;

        public Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
