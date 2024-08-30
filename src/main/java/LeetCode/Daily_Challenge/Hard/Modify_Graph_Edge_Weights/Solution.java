package LeetCode.Daily_Challenge.Hard.Modify_Graph_Edge_Weights;

import java.util.*;

public class Solution {
    private static final int UNASSIGNED_WEIGHT = -1;
    private static final int INITIAL_WEIGHT = 1;
    private static final int INF = Integer.MAX_VALUE;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adjList = buildAdjacencyList(n, edges);

        int[][] distances = initializeDistances(n, source);

        // First run of Dijkstra to find the shortest paths without modifying edges with weight -1
        runDijkstra(adjList, edges, distances, source, 0, 0);

        int difference = target - distances[destination][0];
        if (difference < 0) return new int[0][];  // Impossible to reach the target

        // Second run of Dijkstra considering the difference
        runDijkstra(adjList, edges, distances, source, difference, 1);
        if (distances[destination][1] < target) return new int[0][];  // Impossible to reach the target

        // Update edges with weight -1 to minimal values
        updateUnassignedEdges(edges);

        return edges;
    }

    private List<int[]>[] buildAdjacencyList(int n, int[][] edges) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList[u].add(new int[]{v, i});
            adjList[v].add(new int[]{u, i});
        }
        return adjList;
    }

    private int[][] initializeDistances(int n, int source) {
        int[][] distances = new int[n][2];

        for (int i = 0; i < n; i++)
            distances[i][0] = distances[i][1] = (i == source) ? 0 : INF;

        return distances;
    }

    private void runDijkstra(List<int[]>[] adjList, int[][] edges, int[][] distances, int source, int difference, int run) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});
        distances[source][run] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > distances[currentNode][run]) continue;

            for (int[] neighbor : adjList[currentNode]) {
                int nextNode = neighbor[0], edgeIndex = neighbor[1];
                int weight = edges[edgeIndex][2] == UNASSIGNED_WEIGHT ? INITIAL_WEIGHT : edges[edgeIndex][2];

                if (run == 1 && edges[edgeIndex][2] == UNASSIGNED_WEIGHT) {
                    int newWeight = difference + distances[nextNode][0] - distances[currentNode][1];
                    if (newWeight > weight)
                        edges[edgeIndex][2] = weight = newWeight;
                }

                if (distances[nextNode][run] > distances[currentNode][run] + weight) {
                    distances[nextNode][run] = distances[currentNode][run] + weight;
                    pq.offer(new int[]{nextNode, distances[nextNode][run]});
                }
            }
        }
    }

    private void updateUnassignedEdges(int[][] edges) {
        for (int[] edge : edges)
            if (edge[2] == UNASSIGNED_WEIGHT)
                edge[2] = INITIAL_WEIGHT;
    }
}
