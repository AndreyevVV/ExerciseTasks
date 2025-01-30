package LeetCode.Daily_Challenge.Hard.Divide_Nodes_Into_the_Maximum_Number_of_Groups;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = buildGraph(n, edges);

        if (!isBipartite(adj, n)) return -1;
        int[] maxDepth = computeBFSDepth(adj, n);
        return findMaxGroupSum(adj, maxDepth, n);
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    private boolean isBipartite(List<List<Integer>> adj, int n) {
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++)
            if (color[i] == 0 && !bfsColor(adj, color, i)) return false;
        return true;
    }

    private boolean bfsColor(List<List<Integer>> adj, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int nextColor = 3 - color[node];

            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == 0) {
                    color[neighbor] = nextColor;
                    queue.add(neighbor);
                } else if (color[neighbor] != nextColor)
                    return false;
            }
        }
        return true;
    }

    private int[] computeBFSDepth(List<List<Integer>> adj, int n) {
        int[] maxDepth = new int[n + 1];
        for (int i = 1; i <= n; i++)
            maxDepth[i] = bfsMaxDepth(adj, i);
        return maxDepth;
    }

    private int bfsMaxDepth(List<List<Integer>> adj, int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 1});
        boolean[] visited = new boolean[adj.size()];
        visited[start] = true;
        int depth = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            depth = node[1];

            for (int neighbor : adj.get(node[0])) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, depth + 1});
                }
            }
        }
        return depth;
    }

    private int findMaxGroupSum(List<List<Integer>> adj, int[] maxDepth, int n) {
        boolean[] visited = new boolean[n + 1];
        int groupSum = 0;

        for (int i = 1; i <= n; i++)
            if (!visited[i])
                groupSum += dfsMaxDepth(adj, visited, maxDepth, i);
        return groupSum;
    }

    private int dfsMaxDepth(List<List<Integer>> adj, boolean[] visited, int[] maxDepth, int node) {
        visited[node] = true;
        int maxComponentDepth = maxDepth[node];

        for (int neighbor : adj.get(node))
            if (!visited[neighbor])
                maxComponentDepth = Math.max(maxComponentDepth, dfsMaxDepth(adj, visited, maxDepth, neighbor));
        return maxComponentDepth;
    }
}
