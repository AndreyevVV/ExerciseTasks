package LeetCode.LeetCode_75_Level_2.Day_5_Greedy.Task_Scheduler;

import java.util.*;

public class Solution {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char operation : tasks) {
            map.put(operation, map.getOrDefault(operation, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        int repeatedGroup = 0;

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            for (int numberOfPc : list) {
                if (numberOfPc - 1 > 0) {
                    pq.add(numberOfPc - 1);
                }
            }

            if (!pq.isEmpty()) {
                repeatedGroup += n + 1;
            } else {
                repeatedGroup += list.size();
            }
        }
        return repeatedGroup;
    }
}
