package LeetCode.Daily_Challenge.Hard.Find_Minimum_Diameter_After_Merging_Two_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = getDiameter(edges1);
        int diameter2 = getDiameter(edges2);

        return Math.max(diameter1, Math.max(diameter2, (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1));
    }

    private int getDiameter(int[][] edges) {
        if (edges.length == 0) return 0;

        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] farthestFromStart = bfs(0, graph);
        int farthestNode = farthestFromStart[0];
        int[] farthestFromEnd = bfs(farthestNode, graph);

        return farthestFromEnd[1];
    }

    private int[] bfs(int start, List<Integer>[] graph) {
        int n = graph.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];

        queue.offer(start);
        visited[start] = true;
        int farthestNode = start;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);

                    if (dist[neighbor] > dist[farthestNode])
                        farthestNode = neighbor;
                }
            }
        }

        return new int[]{farthestNode, dist[farthestNode]};
    }
}
