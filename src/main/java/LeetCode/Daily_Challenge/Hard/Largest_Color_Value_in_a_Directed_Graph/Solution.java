package LeetCode.Daily_Challenge.Hard.Largest_Color_Value_in_a_Directed_Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        int[][] count = new int[n][26];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                queue.offer(i);

        int visited = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            int colorIdx = colors.charAt(node) - 'a';
            count[node][colorIdx]++;
            max = Math.max(max, count[node][colorIdx]);

            for (int neighbor : graph.get(node)) {
                for (int i = 0; i < 26; i++)
                    count[neighbor][i] = Math.max(count[neighbor][i], count[node][i]);
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        return visited == n ? max : -1;
    }
}
