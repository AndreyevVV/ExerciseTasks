package LeetCode.Daily_Challenge.Hard.Second_Minimum_Time_to_Reach_Destination;

import java.util.*;

public class Solution {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Deque<int[]> queue = new LinkedList<>();
        int[] visitCount = new int[n + 1];
        int[] arrivalTime = new int[n + 1];
        Arrays.fill(arrivalTime, -1);
        queue.offerLast(new int[]{1, 0});
        arrivalTime[0] = 0;

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                int[] current = queue.pollFirst();

                int nextTime = 0;
                int currentSignalCycle = current[1] / change;
                if (currentSignalCycle % 2 == 0)
                    nextTime = current[1] + time;
                else
                    nextTime = (currentSignalCycle + 1) * change + time;

                for (int nextVertex : graph[current[0]]) {
                    if (visitCount[nextVertex] < 2 && arrivalTime[nextVertex] < nextTime) {
                        queue.offerLast(new int[]{nextVertex, nextTime});
                        visitCount[nextVertex]++;
                        arrivalTime[nextVertex] = nextTime;
                        if (nextVertex == n && visitCount[nextVertex] == 2)
                            return nextTime;
                    }
                }
            }
        }
        return -1;
    }
}
