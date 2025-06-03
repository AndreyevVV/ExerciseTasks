package LeetCode.Daily_Challenge.Hard.Maximum_Candies_You_Can_Get_from_Boxes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        boolean[] hasKey = new boolean[status.length];
        boolean[] opened = new boolean[status.length];

        for (int box : initialBoxes) {
            queue.offer(box);
            seen.add(box);
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean progress = false;
            for (int i = 0; i < size; i++) {
                int box = queue.poll();

                if (status[box] == 1 || hasKey[box]) {
                    if (opened[box]) continue; // уже обработана
                    opened[box] = true;
                    totalCandies += candies[box];

                    for (int k : keys[box]) {
                        hasKey[k] = true;
                        if (seen.contains(k) && !opened[k])
                            queue.offer(k);
                    }

                    for (int contained : containedBoxes[box]) {
                        if (!seen.contains(contained)) {
                            queue.offer(contained);
                            seen.add(contained);
                        }
                    }

                    progress = true;
                } else
                    queue.offer(box);
            }

            if (!progress) break;
        }

        return totalCandies;
    }
}
