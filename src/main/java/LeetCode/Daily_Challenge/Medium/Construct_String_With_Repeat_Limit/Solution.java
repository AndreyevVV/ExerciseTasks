package LeetCode.Daily_Challenge.Medium.Construct_String_With_Repeat_Limit;

import java.util.PriorityQueue;

public class Solution {

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                maxHeap.offer(new int[]{i, freq[i]});

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int charIndex = current[0];
            int count = current[1];
            char currentChar = (char) ('a' + charIndex);

            int allowed = Math.min(count, repeatLimit);
            result.append(String.valueOf(currentChar).repeat(Math.max(0, allowed)));

            if (count > allowed) {
                if (maxHeap.isEmpty()) break;

                int[] next = maxHeap.poll();
                int nextCharIndex = next[0];
                char nextChar = (char) ('a' + nextCharIndex);

                result.append(nextChar);
                next[1]--;

                if (next[1] > 0)
                    maxHeap.offer(next);

                maxHeap.offer(new int[]{charIndex, count - allowed});
            }
        }

        return result.toString();
    }
}
