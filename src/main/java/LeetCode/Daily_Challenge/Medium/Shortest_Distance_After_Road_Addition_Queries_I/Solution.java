package LeetCode.Daily_Challenge.Medium.Shortest_Distance_After_Road_Addition_Queries_I;

import java.util.*;

public class Solution {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++)
            graph.get(i).add(new int[]{i + 1, 1});

        int[] result = new int[queries.length];

        int shortestPath = dijkstra(graph, n);

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            graph.get(u).add(new int[]{v, 1});

            shortestPath = dijkstra(graph, n);

            result[i] = shortestPath;
        }

        return result;
    }

    private int dijkstra(List<List<int[]>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int node = current[1];

            if (d > dist[node]) continue;

            for (int[] edge : graph.get(node)) {
                int nextNode = edge[0];
                int weight = edge[1];

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        return dist[n - 1];
    }
}
