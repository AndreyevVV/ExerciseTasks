package LeetCode.Daily_Challenge.Hard.Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        int[] colorA = new int[n];
        int[] colorB = new int[m];

        int[] countA = buildColorCounts(edges1, colorA);
        int[] countB = buildColorCounts(edges2, colorB);

        int maxGroupB = Math.max(countB[0], countB[1]);
        int[] result = new int[n];

        for (int i = 0; i < n; i++)
            result[i] = countA[colorA[i]] + maxGroupB;

        return result;
    }

    private int[] buildColorCounts(int[][] edges, int[] color) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int evenCount = dfs(0, -1, 0, adj, color);
        int oddCount = n - evenCount;
        return new int[]{evenCount, oddCount};
    }

    private int dfs(int node, int parent, int depth, List<List<Integer>> adj, int[] color) {
        color[node] = depth % 2;
        int evenCount = (color[node] == 0) ? 1 : 0;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            evenCount += dfs(neighbor, node, depth + 1, adj, color);
        }

        return evenCount;
    }
}
