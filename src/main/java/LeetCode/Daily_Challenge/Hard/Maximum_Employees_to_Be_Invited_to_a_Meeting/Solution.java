package LeetCode.Daily_Challenge.Hard.Maximum_Employees_to_Be_Invited_to_a_Meeting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];

        for (int f : favorite)
            indegree[f]++;

        Queue<Integer> queue = new LinkedList<>();
        int[] chainLength = new int[n];
        Arrays.fill(chainLength, 1);

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                queue.offer(i);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int next = favorite[curr];
            chainLength[next] = Math.max(chainLength[next], chainLength[curr] + 1);
            indegree[next]--;

            if (indegree[next] == 0)
                queue.offer(next);
        }

        boolean[] visited = new boolean[n];
        int maxCycleSize = 0;
        int chainContribution = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && indegree[i] > 0) {
                int cycleSize = 0;
                int curr = i;

                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = favorite[curr];
                    cycleSize++;
                }

                if (cycleSize == 2) {
                    int first = i;
                    int second = favorite[i];
                    chainContribution += chainLength[first] + chainLength[second];
                } else
                    maxCycleSize = Math.max(maxCycleSize, cycleSize);
            }
        }

        return Math.max(maxCycleSize, chainContribution);
    }
}
